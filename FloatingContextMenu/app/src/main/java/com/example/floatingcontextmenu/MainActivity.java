package com.example.floatingcontextmenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] android_versions;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList = new ArrayList<String>();
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        registerForContextMenu(listView);
        android_versions = getResources().getStringArray(R.array.android_versions);
        for(String item: android_versions)
        {
            arrayList.add(item);
        }
        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.row_layout,R.id.row_item,arrayList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Context context;
        switch (item.getItemId())
        {
            case R.id.id_delete:
                arrayList.remove(info.position);       //removes the item from the list
                adapter.notifyDataSetChanged();  //display a message telling the user of the change
                return true;
            case R.id.id_help:
                Toast.makeText(getApplicationContext(),"You need help?",Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_share:
                Toast.makeText(getApplicationContext(),"Do you want to share?",Toast.LENGTH_LONG).show();
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
        menuInflater.inflate(R.menu.my_concept_menu,menu);
    }
}
