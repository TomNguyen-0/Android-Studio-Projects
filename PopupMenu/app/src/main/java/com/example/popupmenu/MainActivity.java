package com.example.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void popup(View view)
    {
        PopupMenu popupMenu = new PopupMenu(this,view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.popup_action,popupMenu.getMenu());
        PopUpMenuEventHandler popUpMenuEventHandler = new PopUpMenuEventHandler(getApplicationContext());
        popupMenu.setOnMenuItemClickListener(popUpMenuEventHandler);
        popupMenu.show();
    }
}
