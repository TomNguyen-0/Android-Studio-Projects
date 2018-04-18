package com.example.syntheticcloudversion4;

import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class EnterActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_layout);
        SharedPreferences sharedPreferences = EnterActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        String font_color = sharedPreferences.getString(getString(R.string.BACKGROUND_COLOR), "");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        if (font_color.equals("BLACK")) {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
        } else if (font_color.equals("RED")) {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        } else if (font_color.equals("BLUE")) {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        } else if (font_color.equals("GREEN")) {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        } else if (font_color.equals("PURPLE")) {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
        }
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
