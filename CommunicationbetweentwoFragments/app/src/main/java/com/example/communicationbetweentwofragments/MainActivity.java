package com.example.communicationbetweentwofragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnNameSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setName(String name) {
        FragmentTwo f2 = (FragmentTwo)getFragmentManager().findFragmentById(R.id.fragment_two);
        f2.updateInfo(name);
    }
}
