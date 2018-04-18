package com.example.syntheticcloudversion4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.synthetic_cloud_icon);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(toggle);
        final RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.main_background);
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        String font_color = sharedPreferences.getString(getString(R.string.BACKGROUND_COLOR),"");
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.black_id:
                        relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
                        drawerLayout.closeDrawers();
                        editor.putString(getString(R.string.BACKGROUND_COLOR),"BLACK");
                        editor.commit();
                        break;
                    case R.id.red_id:
                        relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                        drawerLayout.closeDrawers();
                        editor.putString(getString(R.string.BACKGROUND_COLOR),"RED");
                        editor.commit();
                        break;
                    case R.id.blue_id:
                        relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
                        drawerLayout.closeDrawers();
                        editor.putString(getString(R.string.BACKGROUND_COLOR),"BLUE");
                        editor.commit();
                        break;
                    case R.id.green_id:
                        relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                        drawerLayout.closeDrawers();
                        editor.putString(getString(R.string.BACKGROUND_COLOR),"GREEN");
                        editor.commit();
                        break;
                    case R.id.purple_id:
                        relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                        drawerLayout.closeDrawers();
                        editor.putString(getString(R.string.BACKGROUND_COLOR),"PURPLE");
                        editor.commit();
                        break;
                }

                return false;
            }
        });

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

        public void button_enter(View view){
        String button_text;
        button_text = ((Button)view).getText().toString();
        if (button_text.equals("Enter"))
        {

            Intent intent = new Intent(this, EnterActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"There is nothing here for you",Toast.LENGTH_LONG).show();
        }
    }
}
