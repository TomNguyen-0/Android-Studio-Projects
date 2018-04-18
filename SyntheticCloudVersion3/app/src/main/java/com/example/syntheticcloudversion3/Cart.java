package com.example.syntheticcloudversion3;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

/**
 * Created by tom on 7/1/2016.
 */
public class Cart extends Activity{

    TextView textView1;
    String string;
    double item_1,item_2,item_3,item_4,item_5,item_6,item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_layout);


        SharedPreferences sharedPreferences = Cart.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        string = sharedPreferences.getString(getString(R.string.CART_ITEM_1_COST),"0");
        string = string.replaceAll("\\$","");
        item_1 = Double.parseDouble(string);

        string = sharedPreferences.getString(getString(R.string.CART_ITEM_2_COST), "0");
        string = string.replaceAll("\\$", "");
        item_2 = Double.parseDouble(string);

        string = sharedPreferences.getString(getString(R.string.CART_ITEM_3_COST), "0");
        string = string.replaceAll("\\$", "");
        item_3 = Double.parseDouble(string);

        string = sharedPreferences.getString(getString(R.string.CART_ITEM_4_COST), "0");
        string = string.replaceAll("\\$", "");
        item_4 = Double.parseDouble(string);

        string = sharedPreferences.getString(getString(R.string.CART_ITEM_5_COST), "0");
        string = string.replaceAll("\\$", "");
        item_5 = Double.parseDouble(string);

        string = sharedPreferences.getString(getString(R.string.CART_ITEM_6_COST), "0");
        string = string.replaceAll("\\$", "");
        item_6 = Double.parseDouble(string);

        String font_color = sharedPreferences.getString(getString(R.string.BACKGROUND_COLOR),"");
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.cart_background);
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

        if(item_1 == 0)
        {
            textView1 = (TextView) findViewById(R.id.textView3);
            textView1.setText("No items");
            textView1 = (TextView) findViewById(R.id.textView15);
            textView1.setText("$0.00");
            textView1 = (TextView) findViewById(R.id.textView4);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView5);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView6);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView7);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView8);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView9);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView10);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView11);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView12);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView13);
            textView1.setText("");
            textView1 = (TextView) findViewById(R.id.textView14);
            textView1.setText("");
        }
        else {
            textView1 = (TextView) findViewById(R.id.textView3);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_1), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView4);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_1_COST), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView5);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_2), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView6);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_2_COST), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView7);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_3), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView8);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_3_COST), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView9);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_4), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView10);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_4_COST), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView11);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_5), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView12);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_5_COST), "");
            textView1.setText(string);


            textView1 = (TextView) findViewById(R.id.textView13);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_6), "");
            textView1.setText(string);

            textView1 = (TextView) findViewById(R.id.textView14);
            string = sharedPreferences.getString(getString(R.string.CART_ITEM_6_COST), "");
            textView1.setText(string);


            item = item_1 + item_2 + item_3 + item_4 + item_5 + item_6;

            string = Double.toString(item);

            textView1 = (TextView) findViewById(R.id.textView15);
            textView1.setText("$" + string + "0");
        }

    }

}
