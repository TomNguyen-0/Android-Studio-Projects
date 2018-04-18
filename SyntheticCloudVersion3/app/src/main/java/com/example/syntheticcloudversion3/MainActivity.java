package com.example.syntheticcloudversion3;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity{

    Button button_1;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        drawerLayout = (DrawerLayout) findViewById(R.id.main_background);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);
//        fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.main_container,new HomeFragment());
//        fragmentTransaction.commit();
//        getSupportActionBar().setTitle("Home Fragment...");
//        navigationView = (NavigationView)findViewById(R.id.navigation_view);
//        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
//                MODE_PRIVATE);
//        final String font_color = sharedPreferences.getString(getString(R.string.BACKGROUND_COLOR),"");
//        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.main_background);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem item) {
//                switch (item.getItemId())
//
//                {
//                    case R.id.title_red:
//                        font_color = "RED";
//                        break;
//                    case R.id.t:
//                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.main_container, new MessageFragment());
//                        fragmentTransaction.commit();
//                        getSupportActionBar().setTitle("Message Fragment");
//                        item.setChecked(true);
//                        drawerLayout.closeDrawers();
//                        break;
//                    case R.id.settings_id:
//                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.main_container, new SettingsFragment());
//                        fragmentTransaction.commit();
//                        getSupportActionBar().setTitle("Settings Fragment");
//                        item.setChecked(true);
//                        drawerLayout.closeDrawers();
//                        break;
//
//                }
//                return true;
//            }
//        });

//        if(font_color.equals("BLACK")) {
//            drawerLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
//        }
//        else if (font_color.equals("RED"))
//        {
//            drawerLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
//        }
//        else if(font_color.equals("BLUE"))
//        {
//            drawerLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
//        }
//        else if(font_color.equals("GREEN"))
//        {
//            drawerLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
//        }
//        else if(font_color.equals("PURPLE"))
//        {
//            drawerLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
//        }


    }}
//
//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        actionBarDrawerToggle.syncState();
//    }
//}



//       onButtonClickListener();
//
//    }
//
//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        actionBarDrawerToggle.syncState();
//    }
//
//
//    public void button_enter(View view){
//        String button_text;
//        button_text = ((Button)view).getText().toString();
//        if (button_text.equals("Enter"))
//        {
//
//            Intent intent = new Intent(this, EnterActivity.class);
//            startActivity(intent);
//        }
//        else
//        {
//            Toast.makeText(getApplicationContext(),"There is nothing here for you",Toast.LENGTH_LONG).show();
//        }
//    }
//
//
//    public void onButtonClickListener()
//    {
//        button_1 = (Button)findViewById(R.id.button2);
//        button_1.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
//                        a_builder.setMessage("you want to Close this App?").setCancelable(false)
//                                .setPositiveButton("No", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        dialog.cancel();
//                                    }
//                                }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
//                                        MODE_PRIVATE);
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.clear();
//                                editor.commit();
//                                finish();
//                            }
//                        });
//                        AlertDialog alert = a_builder.create();
//                        alert.setTitle("Are you sure,");
//                        alert.show();
//                    }
//                }
//        );
//    }
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.color_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.main_background);
//        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
//                MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        switch (item.getItemId())
//        {
//            case R.id.title_blue:
//                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
//                editor.putString(getString(R.string.BACKGROUND_COLOR),"BLUE");
//                editor.commit();
//                break;
//            case R.id.title_red:
//                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
//                editor.putString(getString(R.string.BACKGROUND_COLOR),"RED");
//                editor.commit();
//                break;
//            case R.id.title_green:
//                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
//                editor.putString(getString(R.string.BACKGROUND_COLOR),"GREEN");
//                editor.commit();
//                break;
//            case R.id.title_purple:
//                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
//                editor.putString(getString(R.string.BACKGROUND_COLOR),"PURPLE");
//                editor.commit();
//                break;
//            case R.id.title_black:
//                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
//                editor.putString(getString(R.string.BACKGROUND_COLOR),"BLACK");
//                editor.commit();
//                break;
//        }
//        return true;
//    }

