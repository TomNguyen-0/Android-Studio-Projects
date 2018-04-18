package com.example.syntheticcloudversion2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by tom on 7/1/2016.
 */
public class Detail_Image_3 extends Activity {

    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        SharedPreferences sharedPreferences = Detail_Image_3.this.getSharedPreferences(getString(R.string.PREF_FILE),
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
        imageView = (ImageView)findViewById(R.id.imageView2); //note that the iamge need to be 360 x ### or else the textView will not show.

        imageView.setImageResource(R.drawable.image_33);
        textView = (TextView)findViewById(R.id.textView2);
        textView.setText("HeavyWeight v2 by Vault Mods\n" +
                "$95.00\n" +
                "\n" +
                "The Heavyweight V2 is similar to the V1 as it emulates the same American cowboy roots with its rugged undertones paired alongside a unique yet elegant body. However, hidden beneath its admirable aesthetics is a new custom 200W chip that renovates its traditional functionality with a refreshing modernization. This dual 18650 box mod supports Ni200, Titanium, and Stainless Steel wire with a resistance support of 0.05Ω - 2.5Ω and temperature support of 212°F-662°F/100°C-350°C.");
    }
}