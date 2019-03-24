 package com.example.luci4.sqltesting;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

 public class Main2Activity extends AppCompatActivity {

    DatabaseHelper db;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new DatabaseHelper(this);

        populateListView();
    }

     private void populateListView() {
         Cursor data = db.getData();
         data.moveToNext();

         ArrayList<String> listData = new ArrayList<>();
         listData.add(data.getString(1));

         ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
         listView.setAdapter(adapter);
     }
 }
