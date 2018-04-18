package com.example.readfromdatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tom on 7/4/2016.
 */
public class UpdateContactActivity extends AppCompatActivity{
    UserDbHelper userDbHelper;
    String NewMobile,NewEmail,NewName,SearchName;
    SQLiteDatabase sqLiteDatabase;
    Button UpdateButton;
    EditText Name_Search,New_Name,New_Mobile,New_Email;
    TextView title_text;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_contact_activity);
        Name_Search = (EditText)findViewById(R.id.name_search);
        New_Name = (EditText)findViewById(R.id.new_name);
        New_Mobile = (EditText)findViewById(R.id.new_mobile);
        New_Email = (EditText)findViewById(R.id.new_email) ;
        UpdateButton = (Button)findViewById(R.id.update_button);
        title_text = (TextView)findViewById(R.id.title_text);
        New_Name.setVisibility(View.GONE);
        New_Mobile.setVisibility(View.GONE);
        New_Email.setVisibility(View.GONE);
        UpdateButton.setVisibility(View.GONE);
        title_text.setVisibility(View.GONE);
    }

    public void searchContact(View view)
    {
        SearchName = Name_Search.getText().toString();
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        Cursor cursor = userDbHelper.getContact(SearchName,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            NewMobile = cursor.getString(0);
            NewEmail = cursor.getString(1);
            NewName = SearchName;
            New_Name.setText(NewName);
            New_Mobile.setText(NewMobile);
            New_Email.setText(NewEmail);
            New_Name.setVisibility(View.VISIBLE);
            New_Mobile.setVisibility(View.VISIBLE);
            New_Email.setVisibility(View.VISIBLE);
            UpdateButton.setVisibility(View.VISIBLE);
            title_text.setVisibility(View.VISIBLE);
        }
    }

    public void updateContact(View view)
    {
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        String name,email,mobile;
        name = New_Name.getText().toString();
        email = New_Email.getText().toString();
        mobile = New_Mobile.getText().toString();
        int count = userDbHelper.updateInformation(SearchName,name,mobile,email,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),count+" contact updated",Toast.LENGTH_SHORT).show();
        finish();
    }
}
