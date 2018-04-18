package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText message;
    SeekBar seekBar;
    float font_size;
    String font_color;
    String text_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (EditText)findViewById(R.id.message);
        seekBar = (SeekBar)findViewById(R.id.seek_bar);
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        text_info = sharedPreferences.getString(getString(R.string.TEXT_INFO),"");
        message.setText(text_info);
        font_size = sharedPreferences.getFloat(getString(R.string.FONT_SIZE),25);
        font_color = sharedPreferences.getString(getString(R.string.FONT_COLOR),"");
        message.setTextSize(TypedValue.COMPLEX_UNIT_PX,font_size);
        if(font_size == 25)
        {
            seekBar.setProgress(0);
        }
        else
        {
            seekBar.setProgress((int)font_size);
        }

        if(font_color.equals("RED"))
        {
            message.setTextColor(Color.parseColor("#FC0116"));
        }
        else if(font_color.equals("BLUE"))
        {
            message.setTextColor(Color.parseColor("#0810F5"));
        }
        else if(font_color.equals("GREEN"))
        {
            message.setTextColor(Color.parseColor("#03FF20"));

        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                message.setTextSize(TypedValue.COMPLEX_UNIT_PX,i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            font_size = message.getTextSize();
            }
        });
    }

    public void changeColor(View view)
    {
        switch (view.getId())
        {
            case R.id.id_red_color:
                message.setTextColor(Color.parseColor("#FC0116"));
                font_color = "RED";
                break;
            case R.id.id_blue_color:

                message.setTextColor(Color.parseColor("#0810F5"));
                font_color = "BLUE";
                break;
            case R.id.id_green_color:
                message.setTextColor(Color.parseColor("#03FF20"));
                font_color = "GREEN";
                break;
        }
    }

    public void saveSettings(View view )
    {
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(getString(R.string.FONT_SIZE),font_size);
        editor.putString(getString(R.string.FONT_COLOR),font_color);
        editor.putString(getString(R.string.TEXT_INFO),message.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(),"Settings are saved",Toast.LENGTH_LONG).show();
    }

    public void clearSettings(View view)
    {
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(getApplicationContext(),"Settings are cleared.",Toast.LENGTH_SHORT).show();
    }
}
