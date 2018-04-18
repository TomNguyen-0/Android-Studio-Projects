package com.example.listviewwithcontextualactionmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] android_versions;
    List data_provider = new ArrayList();
    ArrayAdapter<String> adapter;
    List second_list_to_save_to = new ArrayList();
    int count = 0;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        android_versions = getResources().getStringArray(R.array.android_versions);
        for(String item: android_versions)
        {
            data_provider.add(item);
        }

        adapter = new ArrayAdapter<String>(this,R.layout.row_layout, R.id.row_item,data_provider);
        listView.setAdapter(adapter);

        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if(checked)
                {
                    second_list_to_save_to.add(data_provider.get(position));//the item that the user selected will be saved to this array
                    count++;
                    Toast.makeText(getApplicationContext(),data_provider.get(position)+" add",Toast.LENGTH_LONG).show();
                    mode.setTitle(count +" selected");
                }
                else
                {
                    second_list_to_save_to.remove(data_provider.get(position));
                    count--;
                    Toast.makeText(getApplicationContext(),data_provider.get(position) + " removed",Toast.LENGTH_LONG).show();
                    mode.setTitle(count + " selected");
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.my_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if(item.getItemId()==R.id.id_delete)
                {
                    for(Object Item: second_list_to_save_to)
                    {
                        String ITEM = Item.toString();
                        data_provider.remove(ITEM);
                    }
                    adapter.notifyDataSetChanged();
                    mode.finish();
                    return true;
                }
//                else if(item.getItemId()==R.id.id_share) //does not work. missing the function for share on menu
//                {
//                    Toast.makeText(getApplicationContext(),"You are about to share this image.",Toast.LENGTH_LONG).show();
//                    mode.finish();
//                    return true;
//                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                count = 0;
                second_list_to_save_to.clear();  //this will reset the action bar when the user exits.
            }
        });
    }
}
