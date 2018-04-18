package com.example.readfromdatabase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tom on 7/2/2016.
 */
public class NewContactActivity  extends Activity{

    EditText ContactName, ContactMobile, ContactEmail;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact_layout);
        ContactName = (EditText)findViewById(R.id.contact_name);
        ContactMobile = (EditText)findViewById(R.id.contact_mobile);
        ContactEmail = (EditText)findViewById(R.id.contact_email);
    }

    public void addContact(View view)//onclick for save button in new_contact_layout.xml
    {
        String name = ContactName.getText().toString(); //coverts to string
        String mob = ContactMobile.getText().toString();
        String email = ContactEmail.getText().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformatoins(name, mob,email,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_SHORT).show();
        userDbHelper.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
