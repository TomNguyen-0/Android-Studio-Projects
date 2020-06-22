package com.example.magictrick;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class think_of_a_card extends AppCompatActivity {

    static String card_picked;
    static think_of_a_card think_card;  //this is used later to end the session

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_think_of_a_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        think_card = this;      //to change the title of the the tool bar go to values > strings.xml
        card_picked="12h";  //default is set to queen of hearts
    }


    public void button_top_left(View view){      //queen_of_hearts
        card_picked="12h";   //Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_LONG).show();
    }
    public void button_top_right(View view){      //ace_of_spades
        card_picked="1s";   //Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_LONG).show();
    }
    public void button_bottom_left(View view){      //ace_of_hearts
        card_picked="1h";   //Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_LONG).show();
    }
    public void button_bottom_right(View view){      //king_of_hearts
        card_picked="13h";   //Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_LONG).show();
    }
    public void button_enter(View view){      //reveals the card
        Intent intent = new Intent(this, think_of_a_card_reveal.class);
        startActivity(intent);
    }

    public static String getCard(){return card_picked;}
    public static think_of_a_card getInstance(){return think_card;}
}
