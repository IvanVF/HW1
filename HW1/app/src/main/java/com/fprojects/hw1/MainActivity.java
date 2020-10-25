package com.fprojects.hw1;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_READ_CONTACTS=1;
    private static boolean READ_CONTACTS_GRANTED =false;

    ListView contactList;
    ArrayList<String> contacts = new ArrayList<String>();

    Button mainANextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainANextbtn = (Button) findViewById(R.id.mainANextbtn);
        mainANextbtn.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.mainANextbtn:
                Intent toSecondActivity = new Intent(this, SecondActivity.class);
                startActivity(toSecondActivity);
                break;
            default:
                break;
        }
    }
}