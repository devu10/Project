package test.com.smarttravelcompanion;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.com.smarttravelcompanion.tododatabase.TodoDbHelper;

/**
 * Created by devu on 2/9/2016.
 */
public class AddTodoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText addTitle, addDescription;
<<<<<<< HEAD
    Button save;
=======
    Button save,back;
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581
    Context context = this;
    TodoDbHelper todoDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtodo_layout);

        addTitle = (EditText)findViewById(R.id.txtaddtitile);
        addDescription=(EditText)findViewById(R.id.txtadddetail);
        save = (Button)findViewById(R.id.btnAddsave);
<<<<<<< HEAD


        save.setOnClickListener(this);

=======
        back = (Button)findViewById(R.id.btnGohome);

        save.setOnClickListener(this);
        back.setOnClickListener(this);
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddsave:
                addContact();
                break;
<<<<<<< HEAD
=======
            case R.id.btnGohome:
                startActivity(new Intent(this,TodoActivity.class));
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581
        }

    }

    public void addContact(){
        String title = addTitle.getText().toString();
        String des = addDescription.getText().toString();
        todoDbHelper = new TodoDbHelper(context);
        sqLiteDatabase=todoDbHelper.getWritableDatabase();
        todoDbHelper.addDetails(title,des,sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved into the todo list....", Toast.LENGTH_LONG).show();

        todoDbHelper.close();
    }


}
