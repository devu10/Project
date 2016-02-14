package test.com.smarttravelcompanion.tododatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.PublicKey;

/**
 * Created by devu on 2/9/2016.
 */
public class TodoDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TODODETAILS.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+todoclass.todoDescription.TABLE_NAME+"("+todoclass.todoDescription.TODO_TITLE+" TEXT,"+
                    todoclass.todoDescription.TODO_DESCRIPTION+" TEXT);";
    public TodoDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("Database operation","Databse created or opened");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("Database operation", "TABLE CREATED  ");
    }

    public void addDetails(String title, String des, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(todoclass.todoDescription.TODO_TITLE,title);
        contentValues.put(todoclass.todoDescription.TODO_DESCRIPTION,des);
        db.insert(todoclass.todoDescription.TABLE_NAME, null, contentValues);
        Log.e("Database operation", "one row is inserted ");

    }

    public Cursor getDetails (SQLiteDatabase db){
        Cursor cursor;
        String[] projection = {todoclass.todoDescription.TODO_TITLE,todoclass.todoDescription.TODO_DESCRIPTION};
        cursor = db.query(todoclass.todoDescription.TABLE_NAME,projection,null,null,null,null,null);
        return cursor;
    }

    public Cursor getSearchedDetails (String title,SQLiteDatabase sqLiteDatabase){
        String[] projections = {todoclass.todoDescription.TODO_TITLE,todoclass.todoDescription.TODO_DESCRIPTION};
        String selection = todoclass.todoDescription.TODO_TITLE+" LIKE ?";
        String[] selection_args = {title};
        Cursor cursor = sqLiteDatabase.query(todoclass.todoDescription.TABLE_NAME,projections,selection,selection_args,null,null,null);
        return cursor;
    }

    public void deletedetails(String title, SQLiteDatabase sqLiteDatabase){
        String selection = todoclass.todoDescription.TODO_TITLE+" LIKE ?";
        String[] selection_args = {title};
        sqLiteDatabase.delete(todoclass.todoDescription.TABLE_NAME,selection,selection_args);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
