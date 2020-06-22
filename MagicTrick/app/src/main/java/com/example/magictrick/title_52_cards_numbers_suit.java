package com.example.magictrick;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class title_52_cards_numbers_suit extends AppCompatActivity {

    static title_52_cards_numbers_suit cards52number;
    static String aanswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_title_52_cards_numbers_suit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cards52number = this;   //aanswer = String.valueOf(title_52_cards.getNumber());       // aanswer = aanswer + title_52_cards_numbers.getSuit();      //Toast.makeText(getApplicationContext(),aanswer,Toast.LENGTH_LONG).show();
    }

    public static title_52_cards_numbers_suit getInstance(){
        return cards52number;
    }

    public void button_ready (View view) {
        Intent intent = new Intent(this, title_52_cards_numbers_suit_ready_slide.class);
        startActivity(intent);
    }
    public void button_ready2 (View view) {
        Intent intent = new Intent(this, title_52_cards_numbers_suit_ready.class);
        startActivity(intent);
    }
    public void button_enter(View view) {
        Toast.makeText(getApplicationContext(), "Have a nice day!", Toast.LENGTH_LONG).show();
        title_52_cards_numbers_suit.getInstance().finish();
        title_52_cards_numbers.getInstance().finish();
        title_52_cards.getInstance().finish();
        MainActivity.getInstance().finish();
        finish();
    }

    }
