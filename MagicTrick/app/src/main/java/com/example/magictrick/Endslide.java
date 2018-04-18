package com.example.magictrick;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Endslide extends AppCompatActivity {

    public int Magic_Answer;
    public String yesResult=null;
    TextView Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endslide);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.magic);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        Magic_Answer = 0;
        if( (Slide1.getYes()).equals("YES")){
            Magic_Answer = 1;
        }
        if( (Slide2.getYes()).equals("YES")){
            Magic_Answer += 2;
        }
        if( (Slide3.getYes()).equals("YES")){
            Magic_Answer += 4;
        }
        if( (Slide4.getYes()).equals("YES")){
            Magic_Answer += 8;
        }
        Answer = (TextView)findViewById(R.id.answer_text);
        Answer.setText(String.valueOf(Magic_Answer));
    }

    public void button_enter(View view){
        Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_LONG).show();
        Slide4.getInstance().finish();
        Slide3.getInstance().finish();
        Slide2.getInstance().finish();
        Slide1.getInstance().finish();
        MainActivity.getInstance().finish();
        finish();

    }
}
