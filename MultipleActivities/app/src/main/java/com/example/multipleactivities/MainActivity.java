package com.example.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textview1);
    }

    public void showGreetings(View view)
    {
        String message = "Welcome to my first app..";
        textView.setText(message);
    }

    public void showGreetings2 (View view)
    {
        String button_text;
        button_text = ((Button)view).getText().toString();//to find out which button the user clicked on;
        if (button_text.equals("Open Second Activity"))
        {
            Intent intent = new Intent(this,SecondActivity.class);//to create a new activity in android.
            startActivity(intent);
        }
        else if(button_text.equals("Open Third Activity"))
        {
            Intent intent = new Intent (this, ThirdActivity.class);
            startActivity(intent);
        }
    }
}
