package com.example.luci4.sqltesting;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.luci4.sqltesting.DatabaseContract.Entry;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context,"test.db",null,1);
        Log.i("Status of DB","Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Entry.TABLE_NAME_GOALS + " ("
                + Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Entry.COLUMN_NAME + " TEXT );");}

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("drop table if exists goals");
//        onCreate(db);
    }
//    public boolean insert(String name)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name",name);
//        long ins = db.insert("goals",null,contentValues);
//        db.close();
//
//        Log.i("Insert: ","Done");
//
//        if(ins==-1)
//            return false;
//        else
//            return true;
//    }

//    public Cursor getData(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor data = db.rawQuery("SELECT * FROM goals",null);
//        return data;
//    }
}
