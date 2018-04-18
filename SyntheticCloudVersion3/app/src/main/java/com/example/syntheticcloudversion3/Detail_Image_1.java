package com.example.syntheticcloudversion3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RelativeLayout;

/**
 * Created by tom on 6/29/2016.
 */
public class Detail_Image_1 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        SharedPreferences sharedPreferences = Detail_Image_1.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        String font_color = sharedPreferences.getString(getString(R.string.BACKGROUND_COLOR),"");
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.detail_layout);
        if(font_color.equals("BLACK")) {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
        }
        else if (font_color.equals("RED"))
        {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        }
        else if(font_color.equals("BLUE"))
        {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        }
        else if(font_color.equals("GREEN"))
        {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        }
        else if(font_color.equals("PURPLE"))
        {
            relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
        }
    }
}
