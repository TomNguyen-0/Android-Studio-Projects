package com.example.syntheticcloudviewlist;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] product_poster_resource = {R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5,
            R.drawable.image_6,
            R.drawable.image_7
    };
    String[] product_labels;
    String[] product_costs;
    ProductAdapter adapter;
    private  static Button button_1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        button_1 = (Button)findViewById(R.id.button);
        product_costs = getResources().getStringArray(R.array.product_costs);
        product_labels = getResources().getStringArray(R.array.product_titles); //get source from the value strings.xml movie_titles
        int i=0;
        registerForContextMenu(listView);
        adapter = new ProductAdapter(getApplicationContext(),R.layout.layout_row);
        listView.setAdapter(adapter);
        for(String titles: product_labels)//this is the same as android_versions
        {
            ProductDataProvider dataProvider = new ProductDataProvider( product_poster_resource[i],
                    titles,product_costs[i]);
            adapter.add(dataProvider);
            i++;
        }

        onButtonClickListener();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relative_layout);
        RelativeLayout relativeLayouRow = (RelativeLayout)findViewById(R.id.relative_row);
        switch (item.getItemId())
        {
            case R.id.title_blue:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
                relativeLayouRow.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
                break;
            case R.id.title_red:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                relativeLayouRow.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                break;
            case R.id.title_green:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                relativeLayouRow.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                break;
            case R.id.title_purple:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                relativeLayouRow.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                break;
            case R.id.title_black:
                relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
                relativeLayouRow.setBackgroundColor(getResources().getColor(android.R.color.black));
                break;
        }
        return true;
    }

    public void onButtonClickListener()
    {
        button_1 = (Button)findViewById(R.id.button);
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


}
