package test.com.smarttravelcompanion;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
<<<<<<< HEAD
import android.os.Bundle;
=======
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import test.com.smarttravelcompanion.adapter.ListToDoAdapter;
import test.com.smarttravelcompanion.tododatabase.TodoDbHelper;

/**
 * Created by devu on 2/9/2016.
 */
public class DataListActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    TodoDbHelper todoDbHelper;
    Cursor cursor;
    ListToDoAdapter listToDoAdapter;

    @Override
<<<<<<< HEAD
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
=======
    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder builder) {
        super.onCreateSupportNavigateUpTaskStack(builder);
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581
        setContentView(R.layout.data_list_layout);
        listView = (ListView)findViewById(R.id.list_view);

        todoDbHelper = new TodoDbHelper(getApplicationContext());
        sqLiteDatabase = todoDbHelper.getReadableDatabase();

        listToDoAdapter = new ListToDoAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listToDoAdapter);

        cursor = todoDbHelper.getDetails(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String title,des;
                title=cursor.getString(0);
                des = cursor.getString(1);


                todoProvider todoProv = new todoProvider(title,des);
                listToDoAdapter.add(todoProv);

            }while (cursor.moveToNext());
        }
    }
<<<<<<< HEAD


=======
>>>>>>> 0b41ced8297b07cc5eb736254991b8dfa05e8581
}
