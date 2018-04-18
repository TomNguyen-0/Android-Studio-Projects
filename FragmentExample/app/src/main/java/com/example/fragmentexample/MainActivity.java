package com.example.fragmentexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bn;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {//this is another way of doing it instead of making a method for onclick.
            @Override
            public void onClick(View view) {
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(!status)
                {
                    FragmentOne f1 = new FragmentOne();
                    fragmentTransaction.add(R.id.fragment_container,f1);
                    fragmentTransaction.addToBackStack(null); //this is so when you press back on the phone it does not close the application
                    fragmentTransaction.commit();
                    bn.setText("LOAD SECOND FRAGMENT");
                    status = true;
                }
                else
                {
                    FragmentTwo f2 = new FragmentTwo();
                    fragmentTransaction.add(R.id.fragment_container,f2);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    bn.setText("LOAD FIRST FRAGMENT");
                    status = false;
                }
            }
        });
    }
}
