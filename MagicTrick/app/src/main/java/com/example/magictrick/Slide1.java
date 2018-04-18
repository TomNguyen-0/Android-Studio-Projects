package com.example.magictrick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Slide1 extends AppCompatActivity {

    static Slide1 activity1;
    static String yes_1= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_slide1);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.magic);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        activity1 = this;
    }

    public static Slide1 getInstance(){
        return activity1;
    }

    public void button_enter(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("YES")) {
            yes_1="YES";
            Intent intent = new Intent(this, Slide2.class);
            startActivity(intent);
        } else {
            yes_1="NO";
            Intent intent = new Intent(this, Slide2.class);
            startActivity(intent);
        }
    }

    public  static String getYes(){return yes_1;}
}