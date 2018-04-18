package com.example.readfromdatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by tom on 7/4/2016.
 */
public class DeleteContactActivity extends AppCompatActivity{

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapterDelete listDataAdapter, listDataAdapterDelete;
    String search_name;
    EditText Search_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_contact_layout);
        Search_Name = (EditText)findViewById(R.id.search_name);
        makeTheList();

    }
    public void deleteContact(View view)
    {
        search_name = Search_Name.getText().toString();
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        userDbHelper.deleteInformation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Contact deleted",Toast.LENGTH_SHORT).show();
        makeTheList();

    }
    public void makeTheList()
    {
        listView = (ListView)findViewById(R.id.listView);
//        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.delete_contact_layout);

        listDataAdapter = new ListDataAdapterDelete(getApplicationContext(),R.layout.row_delete_layout);
        listView.setAdapter(listDataAdapter);

        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        cursor = userDbHelper.getInformation(sqLiteDatabase);
        if(cursor.moveToFirst())//look at the first row
        {
            do {

                String name,mob,email;
                name = cursor.getString(0);
                mob = cursor.getString(1);
                email = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(name,mob,email);
                listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext());//this will return true if it can move to the next row.
        }
    }
}
