package com.example.luci4.sqltesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);

        db = new DatabaseHelper(this);
    }

    public void onClick(View view)
    {
        String s = e1.getText().toString();
        boolean ins = db.insert(s);

        if(ins == true)
            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Unsuccessful",Toast.LENGTH_SHORT).show();
    }

    public void onView(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
