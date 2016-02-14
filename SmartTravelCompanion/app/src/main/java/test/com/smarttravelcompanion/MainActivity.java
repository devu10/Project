package test.com.smarttravelcompanion;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import test.com.smarttravelcompanion.maps.CurrentLocation;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    TextView txtFacebookName;
    CallbackManager callbackManager;
//    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
         setContentView(R.layout.activity_main);
=======
        setContentView(R.layout.activity_main);
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtFacebookName = (TextView)findViewById(R.id.facebookname);
        //      userLocalStore = new UserLocalStore(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initFacebookData();
        generateKeyHash();
    }

    public void onLoginClick() {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email"));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }

    private void initFacebookData() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, callback);
    }

    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            final GraphRequest request = GraphRequest.newMeRequest(
                    AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {
                            if (object != null) {

                                try {

                                    txtFacebookName.setText( object.getString("name"));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }


                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender, birthday");
            request.setParameters(parameters);
            request.executeAsync();

        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }

    };

    public void generateKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

 /*        if (authenticate()== true) {
            displayUserDetail();
        }
       else{
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
*/
    }

/*    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetail(){
        User user = userLocalStore.getLoggedInuser();
        //txtName.setText(user.Name);
    }
*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent mIntent;

        if (id == R.id.nav_topdestination) {

            mIntent = new Intent(MainActivity.this,TopDestinationActivity.class);
            startActivity(mIntent);
        } else if (id == R.id.nav_travellingtips) {
            mIntent = new Intent(MainActivity.this,TravellingTipsActivity.class);
            startActivity(mIntent);

        } else if (id == R.id.nav_currentlocation) {

            mIntent = new Intent(MainActivity.this,CurrentLocation.class);
            startActivity(mIntent);

        } else if (id == R.id.nav_currentweather) {
            mIntent=  new Intent(MainActivity.this,WeatherActivity.class);
            startActivity(mIntent);

        } else if (id == R.id.nav_login) {

            onLoginClick();

        } else if (id == R.id.nav_share) {
            String playStoreLink = "https://play.google.com/store/apps/details?id=" +
                    getPackageName();

            String msg = getResources().getString(R.string.share_msg) + playStoreLink;
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                startActivity(new Intent(this,TodoActivity.class));
                break;
        }
    }
}
