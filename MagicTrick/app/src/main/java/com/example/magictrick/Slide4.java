package com.example.magictrick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Slide4 extends AppCompatActivity {

    static Slide4 activity4;
    static String yes_4= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide4);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.magic);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        activity4 = this;
    }

    public static Slide4 getInstance(){
        return activity4;
    }

    public void button_enter(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("YES")) {
            yes_4="YES";
            Intent intent = new Intent(this, Endslide.class);
            startActivity(intent);
        } else {

            yes_4="NO";
            Intent intent = new Intent(this, Endslide.class);
            startActivity(intent);
        }
    }

    static public String getYes(){return yes_4;}
}
