package com.example.simpleuserinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText message_text;
    public final static String MESSAGE_KEY = "com.example.simpleuserinterface.message_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void button_send(View view){
        message_text = (EditText)findViewById(R.id.message_text);
        String message = message_text.getText().toString();
//        Intent intent = new Intent(this,MainActivity.class);
        Intent intent = new Intent (this, SecondActivity.class);
        intent.putExtra(MESSAGE_KEY,message);
        startActivity(intent);
//        message = intent.getStringExtra(MESSAGE_KEY);
//        TextView textView = new TextView(this);
//        textView.setTextSize(45);
//        textView.setText(message);
//        setContentView(textView);
    }

}
