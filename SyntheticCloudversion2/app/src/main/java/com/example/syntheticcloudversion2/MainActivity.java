package com.example.syntheticcloudversion2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class MainActivity extends Activity {

    Button button_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        String font_color = sharedPreferences.getString(getString(R.string.BACKGROUND_COLOR),"");
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.main_background);
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
       onButtonClickListener();

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


    public void onButtonClickListener()
    {
        button_1 = (Button)findViewById(R.id.button2);
        button_1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("you want to Close this App?").setCancelable(false)
                                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                                        MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.commit();
                                finish();
                            }
                        });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Are you sure,");
                        alert.show();
                    }
                }
        );
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.color_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.main_background);
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (item.getItemId())
        {
            case R.id.title_blue:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
                editor.putString(getString(R.string.BACKGROUND_COLOR),"BLUE");
                editor.commit();
                break;
            case R.id.title_red:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                editor.putString(getString(R.string.BACKGROUND_COLOR),"RED");
                editor.commit();
                break;
            case R.id.title_green:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                editor.putString(getString(R.string.BACKGROUND_COLOR),"GREEN");
                editor.commit();
                break;
            case R.id.title_purple:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                editor.putString(getString(R.string.BACKGROUND_COLOR),"PURPLE");
                editor.commit();
                break;
            case R.id.title_black:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
                editor.putString(getString(R.string.BACKGROUND_COLOR),"BLACK");
                editor.commit();
                break;
        }
        return true;
    }
}
