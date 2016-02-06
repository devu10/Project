package test.com.smarttravelcompanion.listener;

import test.com.smarttravelcompanion.data.LocationResult;

/**
 * Created by devu on 2/6/2016.
 */
public interface GeocodingServiceListener {

    void geocodeSuccess(LocationResult location);


    void geocodeFailure(Exception exception);
}
