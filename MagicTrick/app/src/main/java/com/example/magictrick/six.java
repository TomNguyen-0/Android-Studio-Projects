package com.example.magictrick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class six extends Activity {

    static six activitysix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_six);
        activitysix = this;
    }

    public static six getInstance(){
        return activitysix;
    }

    public void button_enter(View view) {
        Intent intent = new Intent(this, six_s.class);
        startActivity(intent);
    }
}
