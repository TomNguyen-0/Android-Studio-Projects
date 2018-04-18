package com.example.magictrick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Slide2 extends AppCompatActivity {

    static Slide2 activity2;
    static String yes_2= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide2);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.magic);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        activity2 = this;
    }

    public static Slide2 getInstance(){
        return activity2;
    }

    public void button_enter(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("YES")) {
            yes_2="YES";
            Intent intent = new Intent(this, Slide3.class);
            startActivity(intent);
        } else {

            yes_2="NO";
            Intent intent = new Intent(this, Slide3.class);
            startActivity(intent);
        }
    }
    public static String getYes(){return yes_2;}
}
