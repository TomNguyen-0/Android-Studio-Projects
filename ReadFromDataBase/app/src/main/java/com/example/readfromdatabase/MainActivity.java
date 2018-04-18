package com.example.readfromdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void addContact(View view)//onclick on activity_main.xml
    {
        Intent intent = new Intent( this, NewContactActivity.class);
        startActivity(intent);
    }

    public void viewContact(View view){
        Intent intent = new Intent(this,DataListActivity.class);
        startActivity(intent);
    }

    public void searchContact(View view){
        Intent intent = new Intent(this,SearchContactActivity.class);
        startActivity(intent);
    }

    public void updateContact(View view){
        Intent intent = new Intent(this,UpdateContactActivity.class);
        startActivity(intent);
    }

    public void deleteContact(View view)
    {
        Intent intent = new Intent(this, DeleteContactActivity.class);
        startActivity(intent);
    }
}
