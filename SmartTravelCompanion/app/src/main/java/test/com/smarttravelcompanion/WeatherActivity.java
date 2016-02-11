package test.com.smarttravelcompanion;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import test.com.smarttravelcompanion.data.Channel;
import test.com.smarttravelcompanion.data.Item;
import test.com.smarttravelcompanion.data.LocationResult;
import test.com.smarttravelcompanion.listener.GeocodingServiceListener;
import test.com.smarttravelcompanion.listener.WeatherServiceListener;

import test.com.smarttravelcompanion.service.GoogleMapsGeocodingService;
import test.com.smarttravelcompanion.service.WeatherCacheService;
import test.com.smarttravelcompanion.service.YahooWeatherService;

/**
 * Created by devu on 2/6/2016.
 */
public class WeatherActivity extends AppCompatActivity implements WeatherServiceListener, GeocodingServiceListener, LocationListener {


    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService weatherService;
    private GoogleMapsGeocodingService geocodingService;
    private WeatherCacheService cacheService;

    private ProgressDialog dialog;

    // counter for failed weather service attempts
    private int weatherServiceFailures = 0;

    private SharedPreferences preferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherIconImageView = (ImageView) findViewById(R.id.weatherIconImageView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        conditionTextView = (TextView) findViewById(R.id.conditionTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);

        weatherService = new YahooWeatherService(this);
        geocodingService = new GoogleMapsGeocodingService(this);
        cacheService = new WeatherCacheService(this);

        preferences = getPreferences(Context.MODE_PRIVATE);

        dialog = new ProgressDialog(this);
        dialog.setMessage(getString(R.string.loading));
        dialog.setCancelable(false);
        dialog.show();


        String cachedLocation = preferences.getString(getString(R.string.location), null);

        if (cachedLocation == null) {
            getWeatherFromCurrentLocation();
        } else {
            weatherService.refreshWeather(cachedLocation);
        }

    }

    private void getWeatherFromCurrentLocation() {
        // system's LocationManager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        // medium accuracy for weather, good for 100 - 500 meters
        Criteria locationCriteria = new Criteria();
        locationCriteria.setAccuracy(Criteria.ACCURACY_MEDIUM);

        String provider = locationManager.getBestProvider(locationCriteria, true);

        // single location update
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestSingleUpdate(provider, this, null);
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();

        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);

        weatherIconImageView.setImageDrawable(weatherIconDrawable);


        String temperatureLabel = getResources().getString(R.string.temperature_output, item.getCondition().getTemperature(), channel.getUnits().getTemperature());

        temperatureTextView.setText(temperatureLabel);
        //temperatureTextView.setText(item.getCondition().getTemperature()+"\u00B0"+channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(channel.getLocation());

    }

    @Override
    public void serviceFailure(Exception exception) {
        // display error if this is the second failure
        if (weatherServiceFailures > 0) {
            dialog.hide();
            Toast.makeText(this, exception.getMessage()+"EEeeeeeeeeeeeeror at weather activity  servicefailure method", Toast.LENGTH_LONG).show();


        } else {
            // error doing reverse geocoding, load weather data from cache
            weatherServiceFailures++;
            cacheService.load(this);
        }
    }

    @Override
    public void geocodeSuccess(LocationResult location) {

        // completed geocoding successfully
        weatherService.refreshWeather(location.getAddress());



        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(getString(R.string.location), location.getAddress());
        editor.commit();

    }

    @Override
    public void geocodeFailure(Exception exception) {

        // GeoCoding failed, try loading weather data from the cache

        cacheService.load(this);

    }

    @Override
    public void onLocationChanged(Location location) {
        geocodingService.refreshLocation(location);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {



    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
