package com.example.syntheticcloudversion3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by tom on 7/1/2016.
 */
public class Detail_Image_4 extends Activity {

    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        SharedPreferences sharedPreferences = Detail_Image_4.this.getSharedPreferences(getString(R.string.PREF_FILE),
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

        imageView.setImageResource(R.drawable.image_4);
        textView = (TextView)findViewById(R.id.textView2);
        textView.setText("Aeolus Lite - Teal\n" +
                "$42.00" +
                "\n" +
                "• Vertical Airflow System\n" +
                "• Anti-Leak System\n" +
                "• PEEK Insulators (649.4°F)\n" +
                "• Unparalleled Flavor\n" +
                "• Wide Range of Airflow Configurations\n" +
                "• Additional Small Airholes for Tighter Draws\n" +
                "• Anti-Spin Square Centerpost\n" +
                "• Large Post Holes\n" +
                "• 18K Gold-Plated Brass Contacts\n" +
                "• Top Cap, Barrel, and AFC: Anodized Aluminum\n" +
                "• 22 mm Diameter\n");
    }
}