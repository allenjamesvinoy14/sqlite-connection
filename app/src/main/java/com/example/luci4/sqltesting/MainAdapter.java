package com.example.luci4.sqltesting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;


import com.example.luci4.sqltesting.DatabaseContract.Entry;

public class MainAdapter extends CursorAdapter {

    public MainAdapter(Context context, Cursor c) {
        super(context, c, 0 );
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    @Override

    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.name);


        String name = cursor.getString(cursor.getColumnIndexOrThrow(Entry.COLUMN_NAME));

        nameTextView.setText(name);

    }
}

