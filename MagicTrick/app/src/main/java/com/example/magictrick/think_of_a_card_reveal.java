package com.example.magictrick;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class think_of_a_card_reveal extends AppCompatActivity {

    static String card_picked;
    Drawable drawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   // makes your screen full screen not showing time or the menu button.
        setContentView(R.layout.activity_think_of_a_card_reveal);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_think_of_a_card_reveal);  //the id that you gave in the layout activity
        Resources res = getResources();  //resource handle
        card_picked=think_of_a_card.getCard();      //Toast.makeText(getApplicationContext(),card_picked,Toast.LENGTH_LONG).show();
        switch(card_picked) {
            case "12h":
                drawable = res.getDrawable(R.drawable.hq);
                break;
            case "1h":
                drawable = res.getDrawable(R.drawable.ha);
                break;
            case "1s":
                drawable = res.getDrawable(R.drawable.sa);
                break;
            case "13h":
                drawable = res.getDrawable(R.drawable.hk);
                break;
        }
        ImageView imageView= (ImageView) findViewById(R.id.image_slide2);
        imageView.setImageDrawable(drawable);
        //relativeLayout.setBackground(drawable);
    }

    public void button_exit(View view){    //Toast.makeText(getApplicationContext(),"Have a nice day!",Toast.LENGTH_LONG).show();
        think_of_a_card.getInstance().finish();
        finish();
    }

}
