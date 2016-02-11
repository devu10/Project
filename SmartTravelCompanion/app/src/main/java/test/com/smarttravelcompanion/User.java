package test.com.smarttravelcompanion;

/**
 * Created by devu on 2/3/2016.
 */
public class User {

    String Name,email,password;
    int phone;

    public User (String name, String email, String password, int phone){
        this.Name = name;
        this.email=email;
        this.password=password;
        this.phone=phone;
    }

    public User(String email, String password){
        this.email=email;
        this.password=password;
        this.Name="";
        this.phone= -1;
    }

}
