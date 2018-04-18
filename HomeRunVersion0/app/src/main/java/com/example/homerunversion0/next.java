package com.example.homerunversion0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class next extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    public void button_enter(View view){

        String button_text;
        button_text = ((Button)view).getText().toString();
        if (button_text.equals("Quit"))
        {
            finish();
            moveTaskToBack(true);
        }
        else
        {
            finish();
            moveTaskToBack(true);
        }
    }
}
