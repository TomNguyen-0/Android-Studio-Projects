package com.example.readfromdatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tom on 7/3/2016.
 */
public class SearchContactActivity extends AppCompatActivity {

    TextView Display_email, Display_Mobile;
    EditText Search_Name;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_contact_layout);
        Search_Name = (EditText)findViewById(R.id.search_name);
        Display_email = (TextView) findViewById(R.id.display_email);
        Display_Mobile = (TextView)findViewById(R.id.display_Mobile);
        Display_Mobile.setVisibility(View.GONE);
        Display_email.setVisibility(View.GONE);
    }

    public void searchContact(View view)
    {
        search_name = Search_Name.getText().toString();
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        Cursor cursor = userDbHelper.getContact(search_name,sqLiteDatabase);
        if(cursor.moveToFirst())//if this return true then there is something there
        {
            String MOBILE = cursor.getString(0);
            String EMAIL = cursor.getString(1);
            Display_Mobile.setText(MOBILE);
            Display_email.setText(EMAIL);
            Display_email.setVisibility(View.VISIBLE);
            Display_Mobile.setVisibility(View.VISIBLE);
        }
    }

    public void deleteContact(View view)
    {
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        userDbHelper.deleteInformation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Contact deleted",Toast.LENGTH_SHORT).show();
    }
}
