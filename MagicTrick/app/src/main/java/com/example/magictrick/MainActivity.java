package com.example.magictrick;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    static MainActivity activity0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.magic);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        activity0 = this;
    }

    public static MainActivity getInstance(){
        return activity0;
    }

    public void button_enter(View view){
        String button_text;
        button_text = ((Button)view).getText().toString();
        if (button_text.equals("Ready?"))
        {

            Intent intent = new Intent(this, Slide1.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"There is nothing here for you",Toast.LENGTH_LONG).show();
        }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.info_menu,menu);        //this is where you pick which menu to use from: menu > info_menu.xml
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId())
        {
            case R.id.title_info:
                intent = new Intent(this, info.class);
                startActivity(intent);
                break;
            case R.id.title_sixDiamonds:
                intent = new Intent(this, six.class);
                startActivity(intent);
                break;
            case R.id.title_52_cards:
                intent = new Intent(this, title_52_cards.class);
                startActivity(intent);
                break;
            case R.id.think_of_a_card:      //don't forget to add this to the menu > info_menu.xml
                intent = new Intent(this, think_of_a_card.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    public void exit_button(View view){
        Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_LONG).show();
        finish();
    }
}
