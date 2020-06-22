package com.example.magictrick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class title_52_cards extends AppCompatActivity {

    static title_52_cards cards52;
    static int number;
    TextView Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_title_52_cards);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        number=0;
        cards52 = this;
    }

    public static title_52_cards getInstance(){return cards52;}

    public void button_number1 (View view) {
        number=1;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }

    public void button_number2 (View view) {
        number=2;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }

    public void button_number3 (View view) {
        number=3;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number4 (View view) {
        number=4;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number5 (View view) {
        number=5;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number6 (View view) {
        number=6;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number7 (View view) {
        number=7;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number8 (View view) {
        number=8;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number9 (View view) {
        number=9;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number10 (View view) {
        number=10;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number11 (View view) {
        number=11;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number12 (View view) {
        number=12;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public void button_number13 (View view) {
        number=13;
        Intent intent = new Intent(this, title_52_cards_numbers.class);
        startActivity(intent);
    }
    public  static int getNumber(){return number;}       //returns the number that was selected

}
