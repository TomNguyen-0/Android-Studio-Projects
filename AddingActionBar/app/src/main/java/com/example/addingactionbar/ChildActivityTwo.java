package com.example.addingactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChildActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_layout_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}
