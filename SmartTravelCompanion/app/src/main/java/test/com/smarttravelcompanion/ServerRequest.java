package test.com.smarttravelcompanion;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by devu on 2/6/2016.
 */
public class ServerRequest {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://devdahal.comxa.com";

    public ServerRequest(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("processing");
        progressDialog.setMessage("please wait.....");


    }

    public void storeUserDataInBackground(User user, GetUserCallBack userCallBack) {
        progressDialog.show();
        new StoreUserDataAsyncCTask(user, userCallBack).execute();
    }

    public void fetchUserDataInBackground(User user, GetUserCallBack callBack) {
        progressDialog.show();
        new fetchUserDataAsyncTask(user, callBack).execute();
    }

    public class StoreUserDataAsyncCTask extends AsyncTask<Void, Void, Void> {

        User user;
        GetUserCallBack userCallBack;

        public StoreUserDataAsyncCTask(User user, GetUserCallBack userCallBack) {
            this.user = user;
            this.userCallBack = userCallBack;
        }

        @Override
        protected Void doInBackground(Void... params) {
            Map<String, String> dataToSend = new HashMap<>();
            dataToSend.put("name", user.Name);
            dataToSend.put("email", user.email);
            dataToSend.put("password", user.password);
            dataToSend.put("phone", user.phone + "");

            String encodedStr = getEncodedData(dataToSend);

            BufferedReader reader = null;
            try {
                //Converting address String to URL
                URL url = new URL(SERVER_ADDRESS + "Register.php");
                //Opening the connection (Not setting or using CONNECTION_TIMEOUT)
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                //Post Method
                con.setRequestMethod("POST");
                //To enable inputting values using POST method
                //(Basically, after this we can write the dataToSend to the body of POST method)
                con.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
                //Writing dataToSend to outputstreamwriter
                writer.write(encodedStr);
                //Sending the data to the server - This much is enough to send data to server
                //But to read the response of the server, you will have to implement the procedure below
                writer.flush();

                //Data Read Procedure - Basically reading the data comming line by line
                StringBuilder sb = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) { //Read till there is something available
                    sb.append(line + "\n");     //Reading and saving line by line - not all at once
                }
                line = sb.toString();           //Saving complete data received in string, you can do it differently

                //Just check to the values received in Logcat
                Log.i("custom_check", "The values received in the store part are as follows:");
                Log.i("custom_check", line);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();     //Closing the
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            //Same return null, but if you want to return the read string (stored in line)
            //then change the parameters of AsyncTask and return that type, by converting
            //the string - to say JSON or user in your case
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {

            progressDialog.dismiss();
            userCallBack.done(null);
            super.onPostExecute(aVoid);
        }
    }


    public class fetchUserDataAsyncTask extends AsyncTask<Void, Void, User> {

        User user;
        GetUserCallBack userCallback;

        public fetchUserDataAsyncTask(User user, GetUserCallBack userCallback) {
            this.user = user;
            this.userCallback = userCallback;

            @Override
            protected User doInBackground (Void...params){
                Map<String, String> dataToSend = new HashMap<>();

                dataToSend.put("email", user.email);
                dataToSend.put("password", user.password);

                String encodedStr = getEncodedData(dataToSend);

                BufferedReader reader = null;
                User returnedUser = null;
                try {
                    //Converting address String to URL
                    URL url = new URL(SERVER_ADDRESS + "FetchUserData.php");
                    //Opening the connection (Not setting or using CONNECTION_TIMEOUT)
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    //Post Method
                    con.setRequestMethod("POST");
                    //To enable inputting values using POST method
                    //(Basically, after this we can write the dataToSend to the body of POST method)
                    con.setDoOutput(true);
                    OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
                    //Writing dataToSend to outputstreamwriter
                    writer.write(encodedStr);
                    //Sending the data to the server - This much is enough to send data to server
                    //But to read the response of the server, you will have to implement the procedure below
                    writer.flush();

                    //Data Read Procedure - Basically reading the data comming line by line
                    StringBuilder sb = new StringBuilder();
                    reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String line;
                    while ((line = reader.readLine()) != null) { //Read till there is something available
                        sb.append(line + "\n");     //Reading and saving line by line - not all at once
                    }
                    line = sb.toString();           //Saving complete data received in string, you can do it differently

                    JSONObject jObject = new JSONObject(line);
                    if(jObject.length()== 0){
                        returnedUser = null;
                    } else {
                        String name = jObject.getString("name");
                        String email = jObject.getString("email");
                        String password = jObject.getString("password");
                        int phone = jObject.getInt("phone");

                        returnedUser = new User(name, user.email, user.password,phone);
                    }

                    //Just check to the values received in Logcat
                    Log.i("custom_check", "The values received in the store part are as follows:");
                    Log.i("custom_check", line);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();     //Closing the
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return returnedUser;
            }
            @Override
            protected void onPostExecute (User returnedUser){
                progressDialog.dismiss();
                userCallback.done(returnedUser);

                super.onPostExecute(user);
            }
        }

    }
    private String getEncodedData(Map<String,String> data)
    {
        StringBuilder sb = new StringBuilder();
        for(String key : data.keySet()) {
            String value = null;
            try {
                value = URLEncoder.encode(data.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if(sb.length()>0)
                sb.append("&");

            sb.append(key + "=" + value);
        }
        return sb.toString();
    }
}
