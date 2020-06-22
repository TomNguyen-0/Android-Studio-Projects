package com.example.magictrick;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class title_52_cards_numbers_suit_ready_slide extends AppCompatActivity {

    static String aanswer;
    View view;
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   // makes your screen full screen not showing time or the menu button.
        setContentView(R.layout.activity_title_52_cards_numbers_suit_ready_slide);

        aanswer = String.valueOf(title_52_cards.getNumber());
        aanswer = aanswer + title_52_cards_numbers.getSuit(); //Toast.makeText(getApplicationContext(),aanswer,Toast.LENGTH_LONG).show();     //will print out the choice

        //view = this.getWindow().getDecorView(); //getting this window's configuration
        //LinearLayout linearLayout = (LinearLayout) findViewById(R.id.title_52_cards_numbers_suit_ready_slide);
        Resources res = getResources();  //resource handle

        //  ViewPager viewPager = findViewById(R.id.viewPager2);
        //   ImageAdapter adapter = new ImageAdapter(this);
        //    viewPager.setAdapter(adapter);
        switch(aanswer){
            case "1h":
                drawable = res.getDrawable(R.drawable.ha);
                break;
            case "1d":
                drawable = res.getDrawable(R.drawable.da);
                break;
            case "1c":
                drawable = res.getDrawable(R.drawable.ca);
                break;
            case "1s":
                drawable = res.getDrawable(R.drawable.sa);
                break;
            case "2h":
                drawable = res.getDrawable(R.drawable.h2);
                break;
            case "2d":
                drawable = res.getDrawable(R.drawable.d2);
                break;
            case "2c":
                drawable = res.getDrawable(R.drawable.c2);
                break;
            case "2s":
                drawable = res.getDrawable(R.drawable.s2);
                break;
            case "3h":
                drawable = res.getDrawable(R.drawable.h3);
                break;
            case "3d":
                drawable = res.getDrawable(R.drawable.d3);
                break;
            case "3c":
                drawable = res.getDrawable(R.drawable.c3);
                break;
            case "3s":
                drawable = res.getDrawable(R.drawable.s3);
                break;
            case "4h":
                drawable = res.getDrawable(R.drawable.h4);
                break;
            case "4d":
                drawable = res.getDrawable(R.drawable.d4);
                break;
            case "4c":
                drawable = res.getDrawable(R.drawable.c4);
                break;
            case "4s":
                drawable = res.getDrawable(R.drawable.s4);
                break;
            case "5h":
                drawable = res.getDrawable(R.drawable.h5);
                break;
            case "5d":
                drawable = res.getDrawable(R.drawable.d5);
                break;
            case "5c":
                drawable = res.getDrawable(R.drawable.c5);
                break;
            case "5s":
                drawable = res.getDrawable(R.drawable.s5);
                break;
            case "6h":
                drawable = res.getDrawable(R.drawable.h6);
                break;
            case "6d":
                drawable = res.getDrawable(R.drawable.d6);
                break;
            case "6c":
                drawable = res.getDrawable(R.drawable.c6);
                break;
            case "6s":
                drawable = res.getDrawable(R.drawable.s6);
                break;
            case "7h":
                drawable = res.getDrawable(R.drawable.h7);
                break;
            case "7d":
                drawable = res.getDrawable(R.drawable.d7);
                break;
            case "7c":
                drawable = res.getDrawable(R.drawable.c7);
                break;
            case "7s":
                drawable = res.getDrawable(R.drawable.s7);
                break;
            case "8h":
                drawable = res.getDrawable(R.drawable.h8);
                break;
            case "8d":
                drawable = res.getDrawable(R.drawable.d8);
                break;
            case "8c":
                drawable = res.getDrawable(R.drawable.c8);
                break;
            case "8s":
                drawable = res.getDrawable(R.drawable.s8);
                break;
            case "9h":
                drawable = res.getDrawable(R.drawable.h9);
                break;
            case "9d":
                drawable = res.getDrawable(R.drawable.d9);
                break;
            case "9c":
                drawable = res.getDrawable(R.drawable.c9);
                break;
            case "9s":
                drawable = res.getDrawable(R.drawable.s9);
                break;
            case "10h":
                drawable = res.getDrawable(R.drawable.h10);
                break;
            case "10d":
                drawable = res.getDrawable(R.drawable.d10);
                break;
            case "10c":
                drawable = res.getDrawable(R.drawable.c10);
                break;
            case "10s":
                drawable = res.getDrawable(R.drawable.s10);
                break;
            case "11h":
                drawable = res.getDrawable(R.drawable.hj);
                break;
            case "11d":
                drawable = res.getDrawable(R.drawable.dj);
                break;
            case "11c":
                drawable = res.getDrawable(R.drawable.cj);
                break;
            case "11s":
                drawable = res.getDrawable(R.drawable.sj);
                break;
            case "12h":
                drawable = res.getDrawable(R.drawable.hq);
                break;
            case "12d":
                drawable = res.getDrawable(R.drawable.dq);
                break;
            case "12c":
                drawable = res.getDrawable(R.drawable.cq);
                break;
            case "12s":
                drawable = res.getDrawable(R.drawable.sq);
                break;
            case "13h":
                drawable = res.getDrawable(R.drawable.hk);
                break;
            case "13d":
                drawable = res.getDrawable(R.drawable.dk);
                break;
            case "13c":
                drawable = res.getDrawable(R.drawable.ck);
                break;
            case "13s":
                drawable = res.getDrawable(R.drawable.sk);
                break;
        }
        //LinearLayout linearLayout = (LinearLayout) findViewById(R.id.title_52_cards_numbers_suit_ready_slide);
        ImageView imageView= (ImageView) findViewById(R.id.image_slide);
        imageView.setImageDrawable(drawable);
        //relativeLayout.setBackground(drawable);     //Toast.makeText(getApplicationContext(),"what is up?",Toast.LENGTH_LONG).show();
       // LinearLayout gallery = (LinearLayout)findViewById(R.id.gallery);
       // LayoutInflater inflater = LayoutInflater.from(this);
       // for (int i=0; i<2; i++){
         //   View view = inflater.inflate(R.layout.activity_title_52_cards_numbers_suit_ready_slide, gallery);
            //TextView textView = view.findViewById(R.id.text);
            //textView.setText("Item " + i);
           // ImageView imageView = (ImageView) view.findViewById(R.id.image_slide);
            //imageView.setImageResource(R.drawable.c2);
            //gallery.addView(view);
       // }
        //ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        //ImageAdapter adapter = new ImageAdapter(this);
        //viewPager.setAdapter(adapter);

    }


}
