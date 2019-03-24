package com.example.luci4.sqltesting;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luci4.sqltesting.DatabaseContract.Entry;

import java.io.ByteArrayInputStream;

public class MainActivity extends AppCompatActivity{

    EditText e1;

    private static final int EXISTING_WOMEN_LOADER = 0;
    private Uri mCurrentWomenUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);

        //db = new DatabaseHelper(this);
    }

    public void onClick(View view)
    {
        String s = e1.getText().toString();
//        boolean ins = db.insert(s);
//
//        if(ins == true)
//            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(getApplicationContext(),"Unsuccessful",Toast.LENGTH_SHORT).show();

        ContentValues values = new ContentValues();

        values.put(Entry.COLUMN_NAME, s);

        Uri newUri = getContentResolver().insert(Entry.CONTENT_URI_PRODUCT, values);

        if (newUri == null) {
            Toast.makeText(this, "Insert failed",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Insert successful",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void onView(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
