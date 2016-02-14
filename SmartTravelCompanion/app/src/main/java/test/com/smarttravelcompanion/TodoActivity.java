package test.com.smarttravelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by devu on 2/9/2016.
 */
public class TodoActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnadd, btnview, btndelete;
    Intent mintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_layout);

        btnadd = (Button)findViewById(R.id.btnAdd);
        btnview = (Button)findViewById(R.id.btnView);
        btndelete = (Button)findViewById(R.id.btnDelete);

        btnadd.setOnClickListener(this);
        btnview.setOnClickListener(this);
        btndelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                mintent = new Intent(TodoActivity.this,AddTodoActivity.class);
                startActivity(mintent);
                break;
            case R.id.btnView:
                mintent = new Intent(TodoActivity.this,DataListActivity.class);
                startActivity(mintent);
                break;
            case R.id.btnDelete:
<<<<<<< HEAD
                mintent = new Intent(TodoActivity.this,SearchTodoAcivity.class);
                startActivity(mintent);
=======
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581
                break;
        }

    }
}
