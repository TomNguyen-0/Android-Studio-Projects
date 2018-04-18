package com.example.addingactionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChildActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_layout_one);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //this is for the back button to take it back to the parent screen at the top where the action bar is.
    }

    public void startChild(View view)
    {
        startActivity(new Intent(this,ChildActivityTwo.class));
    }
}
