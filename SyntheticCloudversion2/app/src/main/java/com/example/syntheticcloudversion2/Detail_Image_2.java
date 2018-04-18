package com.example.syntheticcloudversion2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by tom on 6/29/2016.
 */
public class Detail_Image_2 extends Activity{

    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        SharedPreferences sharedPreferences = Detail_Image_2.this.getSharedPreferences(getString(R.string.PREF_FILE),
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

        imageView.setImageResource(R.drawable.image_2);
        textView = (TextView)findViewById(R.id.textView2);
        textView.setText("Spectra Box Mod (Black/Black)\n" +
                "$90.00\n" +
                "\n" +
                "Specifications:\n" +
                "• Chip: SBT-200UTC\n" +
                "• Max Wattage: 200W\n" +
                "• Temperature Control Support: Kanthal A-1, Ni200, Titanium, SS\n" +
                "• Resistance Support: 0.04Ω - 2.0Ω\n" +
                "• Temperature Range: 200°F - 600°F/100°C - 300°C\n" +
                "• Battery Requirement: (2) - 18650 35Amp*\n" +
                "• Chip Update Requirement: Microchip PICkit 3*\n" +
                "\n" +
                "Features:\n" +
                "• Spring Electrode\n" +
                "• Magnet Cover\n" +
                "• Input High Voltage Warning\n" +
                "• Low Voltage Protection\n" +
                "• Low Resistance Protection\n" +
                "• Output Short-Circuit Protection\n" +
                "• Reverse Battery Protection\n" +
                "• Overheating Protection\n" +
                "• Overtime Protection\n" );
    }
}
