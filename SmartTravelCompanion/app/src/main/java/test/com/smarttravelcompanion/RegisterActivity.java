package test.com.smarttravelcompanion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button bregister;
    EditText edEmail,edPassword,edName,edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bregister = (Button)findViewById(R.id.bregister);

        edEmail = (EditText) findViewById(R.id.edEmail);
        edPassword = (EditText) findViewById(R.id.edPassword);
        edName = (EditText) findViewById(R.id.edName);
        edPhone = (EditText) findViewById(R.id.edPhone);

        bregister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bregister:
                String name = edName.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                int phone = Integer.parseInt(edPhone.getText().toString());

                User registerdData = new User(name,email,password,phone);
                break;
        }
    }
}
