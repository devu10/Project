package test.com.smarttravelcompanion;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import test.com.smarttravelcompanion.tododatabase.TodoDbHelper;

/**
 * Created by user on 2/12/2016.
 */
public class SearchTodoAcivity extends AppCompatActivity {

    TextView  displaytitle, displaydetails;
    EditText searctitle;
    TodoDbHelper todoDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String searchedtitle;
    Button btndelete,searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tododelete_layout);
        btndelete = (Button)findViewById(R.id.btnDelete);
        searchbtn = (Button)findViewById(R.id.btnsearch);
        displaytitle = (TextView)findViewById(R.id.txt_todosearch_title);
        displaydetails = (TextView)findViewById(R.id.txt_todosearch_detail);

        searctitle = (EditText)findViewById(R.id.edtxt_search);

        displaydetails.setVisibility(View.GONE);
        displaytitle.setVisibility(View.GONE);
    }

    public void searchtodo (View view){
        searchedtitle = searctitle.getText().toString();
        todoDbHelper = new TodoDbHelper(getApplicationContext());
        sqLiteDatabase=todoDbHelper.getReadableDatabase();
        Cursor cursor = todoDbHelper.getSearchedDetails(searchedtitle,sqLiteDatabase);
        if (cursor.moveToFirst()){
            String title = cursor.getString(0);
            String des = cursor.getString(1);
            displaytitle.setText(title);
            displaydetails.setText(des);
            displaytitle.setVisibility(View.VISIBLE);
            displaydetails.setVisibility(View.VISIBLE);

        }
    }

    public void deletetodo(View view){
        todoDbHelper = new TodoDbHelper(getApplicationContext());
        sqLiteDatabase=todoDbHelper.getReadableDatabase();
        todoDbHelper.deletedetails(searchedtitle,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"contact deleted",Toast.LENGTH_LONG).show();
        cleartext();


    }

    public void cleartext(){
        searctitle.setVisibility(View.GONE);
        displaytitle.setVisibility(View.GONE);
        displaydetails.setVisibility(View.GONE);
        btndelete.setVisibility(View.GONE);
        searchbtn.setVisibility(View.GONE);
    }
}
