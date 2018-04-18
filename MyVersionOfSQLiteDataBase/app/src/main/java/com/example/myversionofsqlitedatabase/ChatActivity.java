package com.example.myversionofsqlitedatabase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tom on 7/5/2016.
 */
public class ChatActivity extends AppCompatActivity
{

    ListView listView;
    SQLiteDatabase sqLiteDatabase;

    ChatDbHelper chatDbHelper;
    Cursor cursor;
    ListChatAdapter listDataAdapter;
    String delete_name, edit_name;
    EditText ChatMessage;
    Context context = this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.notepad);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        ChatMessage = (EditText)findViewById(R.id.message_editText);
        makeTheList();
    }


    public void sendOnClick(View view) {
        String chat = ChatMessage.getText().toString();
        chatDbHelper = new ChatDbHelper(context);
        sqLiteDatabase = chatDbHelper.getWritableDatabase();
        chatDbHelper.addInformation(chat,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Message send",Toast.LENGTH_SHORT).show();
        chatDbHelper.close();
        makeTheList();
        ChatMessage.setText("");
    }


    public void makeTheList()
    {
        listView = (ListView)findViewById(R.id.listView);
        registerForContextMenu(listView);
        listDataAdapter = new ListChatAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);

        chatDbHelper = new ChatDbHelper(getApplicationContext());
        sqLiteDatabase = chatDbHelper.getReadableDatabase();
        cursor = chatDbHelper.getInformation(sqLiteDatabase);
        if(cursor.moveToFirst())//look at the first row
        {
            do {

                String chat;
                chat = cursor.getString(0);
                ChatProvider dataProvider = new ChatProvider(chat);
                listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext());//this will return true if it can move to the next row.
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Context context;
        switch (item.getItemId())
        {
            case R.id.delete_menu:
                delete_name =  listDataAdapter.getString(info.position);
                chatDbHelper = new ChatDbHelper(getApplicationContext());
                sqLiteDatabase = chatDbHelper.getReadableDatabase();
                chatDbHelper.deleteInformation(delete_name,sqLiteDatabase);//It will delete everything with the same string as that one. bad coding. to fix this you need to go into ChatDbHelper and change the coding in it.
                Toast.makeText(getBaseContext(),"Deleted",Toast.LENGTH_SHORT).show();
                makeTheList();
                return true;
            case R.id.edit_menu:
                ChatMessage = (EditText)findViewById(R.id.message_editText);
                edit_name= listDataAdapter.getString(info.position);
                ChatMessage.setText(edit_name);
                delete_name =  listDataAdapter.getString(info.position);
                chatDbHelper = new ChatDbHelper(getApplicationContext());
                sqLiteDatabase = chatDbHelper.getReadableDatabase();
                chatDbHelper.deleteInformation(delete_name,sqLiteDatabase);//It will delete everything with the same string as that one. bad coding. to fix this you need to go into ChatDbHelper and change the coding in it.
                makeTheList();
                return true;
            case R.id.back_menu:
                Toast.makeText(getBaseContext(),"Oops",Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.content_menu,menu);
    }
}
