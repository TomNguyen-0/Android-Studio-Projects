package com.example.app_a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClickOne(View view)
    {
        Intent intent = new Intent(this, ActivityOne.class);
        startActivity(intent);//this is an example of explicit intent
    }
    public void buttonClickTwo(View view)
    {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);//this is an example of explicit intent

        //if you want to use this method in a different app use these commands:
        //Intent intent = new Intent("com.example.app_a.activitytwo");
        //startActivity(intent);
        //this method of using a different method from a different app is called implicit
    }
}
