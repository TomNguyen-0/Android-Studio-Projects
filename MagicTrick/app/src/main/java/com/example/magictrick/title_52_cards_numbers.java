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
import android.widget.TextView;
import android.widget.Toast;

public class title_52_cards_numbers extends AppCompatActivity {

    static title_52_cards_numbers cards52number;
    static String suit;
    static String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_title_52_cards_numbers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cards52number = this;       //answer = String.valueOf(title_52_cards.getNumber());    //convert int to string       //Toast.makeText(getApplicationContext(),answer,Toast.LENGTH_LONG).show();
    }

    public static title_52_cards_numbers getInstance(){return cards52number;}

    public void button_heart (View view) {
        suit="h";
        Intent intent = new Intent(this, title_52_cards_numbers_suit.class);
        startActivity(intent);
    }
    public void button_diamonds (View view) {
        suit="d";
        Intent intent = new Intent(this, title_52_cards_numbers_suit.class);
        startActivity(intent);
    }
    public void button_clubs (View view) {
        suit="c";
        Intent intent = new Intent(this, title_52_cards_numbers_suit.class);
        startActivity(intent);
    }
    public void button_spades (View view) {
        suit="s";
        Intent intent = new Intent(this, title_52_cards_numbers_suit.class);
        startActivity(intent);
    }

    public static String getSuit(){return suit;}
}
