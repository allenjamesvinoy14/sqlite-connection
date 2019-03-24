package com.example.luci4.sqltesting;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by james on 3/24/2019.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context,"test.db",null,1);
        Log.i("Status of DB","Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table goals(id INTEGER PRIMARY KEY,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists goals");
        onCreate(db);
    }
    public boolean insert(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        long ins = db.insert("goals",null,contentValues);
        db.close();

        Log.i("Insert: ","Done");

        if(ins==-1)
            return false;
        else
            return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM goals",null);
        return data;
    }
}
