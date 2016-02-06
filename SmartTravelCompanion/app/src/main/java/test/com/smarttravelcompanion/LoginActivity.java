package test.com.smarttravelcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button blogin,bloginfacebook;
    EditText edEmail,edPassword;
    TextView txtregister;
    Intent mintent;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        blogin = (Button)findViewById(R.id.blogin);
        bloginfacebook = (Button)findViewById(R.id.bloginfacebook);

        edEmail = (EditText) findViewById(R.id.edEmail);
        edPassword = (EditText) findViewById(R.id.edPassword);

        txtregister = (TextView)findViewById(R.id.txtregister);

        blogin.setOnClickListener(this);
        bloginfacebook.setOnClickListener(this);
        txtregister.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.blogin:
                User user = new User(null,null);

                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
                break;

            case R.id.bloginfacebook:
                mintent = new Intent(LoginActivity.this,FacebookLogin.class);
                startActivity(mintent);
                break;
            case R.id.txtregister:
                mintent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(mintent);
                break;
        }

    }
}
