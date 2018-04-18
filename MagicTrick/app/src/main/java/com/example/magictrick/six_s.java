package com.example.magictrick;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class six_s extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_s);
    }

    public void button_enter(View view){
        Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_LONG).show();
        six.getInstance().finish();
        MainActivity.getInstance().finish();
        finish();

    }
}
