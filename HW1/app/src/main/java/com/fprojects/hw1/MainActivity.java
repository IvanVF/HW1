package com.fprojects.hw1;

import android.Manifest;
import android.content.*;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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

        contactList = (ListView) findViewById(R.id.contactList);

        int hasReadContactPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS); //Разрешение для API>23
        if(hasReadContactPermission == PackageManager.PERMISSION_GRANTED){ READ_CONTACTS_GRANTED = true; } //Разрешение для API<23
        else{ ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE_READ_CONTACTS); }

        if (READ_CONTACTS_GRANTED){
            loadContacts();
        }
    }

    private void loadContacts(){
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if(cursor!=null){
            while (cursor.moveToNext()) {
                String contact = cursor.getString( cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));// получить контакт
                contacts.add(contact); // добавить список
            }
            cursor.close();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        contactList.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        switch (requestCode){
            case REQUEST_CODE_READ_CONTACTS:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    READ_CONTACTS_GRANTED = true;
                }
        }
        if(READ_CONTACTS_GRANTED){
            loadContacts();
        }
        else{
            Toast.makeText(this, "Требуется установить разрешения", Toast.LENGTH_LONG).show();
        }
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