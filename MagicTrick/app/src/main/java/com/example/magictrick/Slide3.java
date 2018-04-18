package com.example.magictrick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Slide3 extends AppCompatActivity {

    static Slide3 activity3;
    static String yes_3= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide3);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.magic);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        activity3 = this;
    }

    public static Slide3 getInstance(){
        return activity3;
    }

    public void button_enter(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("YES")) {
            yes_3="YES";
            Intent intent = new Intent(this, Slide4.class);
            startActivity(intent);
        } else {

            yes_3="NO";
            Intent intent = new Intent(this, Slide4.class);
            startActivity(intent);
        }
    }

    public static String getYes(){return yes_3;}
}
