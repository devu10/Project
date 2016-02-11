package test.com.smarttravelcompanion;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by devu on 2/3/2016.
 */
public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);

    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name",user.Name);
        spEditor.putString("email",user.email);
        spEditor.putString("password",user.password);
        spEditor.putInt("phone",user.phone);
        spEditor.commit();
    }

    public User getLoggedInuser(){
        String name = userLocalDatabase.getString("name", "");
        String email = userLocalDatabase.getString("email","");
        String password = userLocalDatabase.getString("password","");
        int phone = userLocalDatabase.getInt("phone", -1);

        User storedUser = new User(name,email,password,phone);
        return storedUser;
    }

    public void setUserLoggedIn (boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn",loggedIn);
        spEditor.commit();
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("LoggedIn",false)== true){
            return true;
        }else {
            return false;
        }
    }
}
