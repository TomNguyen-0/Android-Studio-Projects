package com.example.syntheticcloudversion2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tom on 6/24/2016.
 */
public class EnterActivity extends Activity {

    ListView listView;
    int[] product_poster_resource = {R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5,
            R.drawable.image_6,

    };
    String[] product_labels;
    String[] product_costs;
    ProductAdapter adapter;
    ProductDataProvider dataProvider;

    public int item_number=1;
    Context context2;
    ImageView[] imageViews; //this stores the images
    TextView[] textViews; //this stores the description for the images
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_layout);
        SharedPreferences sharedPreferences = EnterActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                MODE_PRIVATE);
        String font_color = sharedPreferences.getString(getString(R.string.BACKGROUND_COLOR),"");
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relative_layout);
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

        listView = (ListView)findViewById(R.id.list_view);

        product_costs = getResources().getStringArray(R.array.product_costs);
        product_labels = getResources().getStringArray(R.array.product_titles); //get source from the value strings.xml movie_titles
        int i=0;
        registerForContextMenu(listView);
        adapter = new ProductAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(adapter);
        for(String titles: product_labels)//this is the same as android_versions
        {
            dataProvider = new ProductDataProvider( product_poster_resource[i],
                    titles,product_costs[i]);
            adapter.add(dataProvider);
            i++;
        }



    }





    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Context context;

        switch (item.getItemId())
        {
            case R.id.id_delete:
                Toast.makeText(getApplicationContext(),"Removed item" ,Toast.LENGTH_LONG).show();
                adapter.remove(adapter.getItem(info.position));
                adapter.notifyDataSetChanged();  //display a message telling the user of the change
                return true;
            case R.id.id_help:
                Toast.makeText(getApplicationContext(),"You need help?",Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_share:
                Toast.makeText(getApplicationContext(),"Do you want to share?",Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_buy:

                        AlertDialog.Builder a_builder = new AlertDialog.Builder(EnterActivity.this);
                AlertDialog.Builder builder = a_builder.setMessage("Do you want to add this to your Cart?").setCancelable(false)
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override

                            public void onClick(DialogInterface dialog, int which) {

                                SharedPreferences sharedPreferences = EnterActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),
                                        MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();

                                if (item_number == 1) {
                                    editor.putString(getString(R.string.CART_ITEM_1), adapter.getTitle(info.position));
                                    editor.putString(getString(R.string.CART_ITEM_1_COST), adapter.getCost(info.position));
                                    editor.commit();
                                    Toast.makeText(getApplicationContext(), adapter.getTitle(info.position)+" added to Cart", Toast.LENGTH_SHORT).show();
                                    item_number++;
                                } else if (item_number == 2) {
                                    editor.putString(getString(R.string.CART_ITEM_2), adapter.getTitle(info.position));
                                    editor.putString(getString(R.string.CART_ITEM_2_COST), adapter.getCost(info.position));
                                    editor.commit();
                                    item_number++;
                                    Toast.makeText(getApplicationContext(), adapter.getTitle(info.position)+" added to Cart", Toast.LENGTH_SHORT).show();
                                } else if (item_number == 3) {
                                    editor.putString(getString(R.string.CART_ITEM_3), adapter.getTitle(info.position));
                                    editor.putString(getString(R.string.CART_ITEM_3_COST), adapter.getCost(info.position));
                                    editor.commit();
                                    Toast.makeText(getApplicationContext(), adapter.getTitle(info.position)+" added to Cart", Toast.LENGTH_SHORT).show();
                                    item_number++;
                                } else if (item_number == 4) {
                                    editor.putString(getString(R.string.CART_ITEM_4), adapter.getTitle(info.position));
                                    editor.putString(getString(R.string.CART_ITEM_4_COST), adapter.getCost(info.position));
                                    editor.commit();
                                    Toast.makeText(getApplicationContext(), adapter.getTitle(info.position)+" added to Cart", Toast.LENGTH_SHORT).show();
                                    item_number++;
                                } else if (item_number == 5) {
                                    editor.putString(getString(R.string.CART_ITEM_5), adapter.getTitle(info.position));
                                    editor.putString(getString(R.string.CART_ITEM_5_COST), adapter.getCost(info.position));
                                    editor.commit();
                                    Toast.makeText(getApplicationContext(), adapter.getTitle(info.position)+" added to Cart", Toast.LENGTH_SHORT).show();
                                    item_number++;
                                } else if (item_number == 6) {
                                    editor.putString(getString(R.string.CART_ITEM_6), adapter.getTitle(info.position));
                                    editor.putString(getString(R.string.CART_ITEM_6_COST), adapter.getCost(info.position));
                                    editor.commit();
                                    Toast.makeText(getApplicationContext(), adapter.getTitle(info.position)+" added to Cart", Toast.LENGTH_SHORT).show();
                                    item_number++;
                                } else {
                                    Toast.makeText(getApplicationContext(), "Cart is full", Toast.LENGTH_SHORT).show();
                                }
                            }


                        });
                AlertDialog alert = a_builder.create();
                        alert.setTitle("Add to Checkout,");
                        alert.show();
                return true;
            case R.id.id_cart:
                Intent intent2 = new Intent(this,Cart.class);
                startActivity(intent2);
                return true;
            case R.id.id_details:
                if(R.drawable.image_1== adapter.getImage(info.position)) {
                    Intent intent = new Intent(this, Detail_Image_1.class);
                    startActivity(intent);
                    return true;
                }
                else if(R.drawable.image_2 == adapter.getImage(info.position))
                {
                    Intent intent = new Intent(this, Detail_Image_2.class);
                    startActivity(intent);
                    return true;
                }
                else if(R.drawable.image_3 == adapter.getImage(info.position))
                {
                    Intent intent = new Intent(this, Detail_Image_3.class);
                    startActivity(intent);
                    return true;
                }
                else if(R.drawable.image_4 == adapter.getImage(info.position))
                {
                    Intent intent = new Intent(this, Detail_Image_4.class);
                    startActivity(intent);
                    return true;
                }
                else if(R.drawable.image_5 ==adapter.getImage(info.position))
                {
                    Intent intent = new Intent(this, Detail_Image_5.class);
                    startActivity(intent);
                    return true;
                }
                else if(R.drawable.image_6 == adapter.getImage(info.position))
                {
                    Intent intent = new Intent(this, Detail_Image_6.class);
                    startActivity(intent);
                    return true;
                }

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.floating_content_menu,menu);
    }




}
