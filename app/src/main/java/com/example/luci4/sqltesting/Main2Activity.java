package com.example.luci4.sqltesting;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


import com.example.luci4.sqltesting.DatabaseContract.Entry;

public class Main2Activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    MainAdapter adapter;
    private static final int WOMEN_LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ListView listView = findViewById(R.id.list);

        adapter = new MainAdapter(this,null);
        listView.setAdapter(adapter);

        getLoaderManager().initLoader(WOMEN_LOADER, null, this);
    }

    private void populateListView() {
//         Cursor data = db.getData();
//         data.moveToNext();
//
//         ArrayList<String> listData = new ArrayList<>();
//         listData.add(data.getString(1));



    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] projection = {

                Entry._ID,
                Entry.COLUMN_NAME};

        return new CursorLoader(this,
                Entry.CONTENT_URI_PRODUCT,
                projection,null,null, null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        adapter.swapCursor(null);
    }

}
