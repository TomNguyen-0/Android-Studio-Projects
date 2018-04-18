package com.example.homerunversion0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EnterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void button_next(View view){
        String button_text;
        button_text = ((Button)view).getText().toString();
        if (button_text.equals("next"))
        {
            Intent intent = new Intent(this, next.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"There is nothing here for you",Toast.LENGTH_LONG).show();
        }
    }

}
