package com.example.myversionofsqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by tom on 7/5/2016.
 */
public class ChatDbHelper extends SQLiteOpenHelper{

    private static  final int DATABASE_VERSION =1;
    private static final String DATABASE_CHAT = "CHATINFO.DB";
    private static final String CREATE_QUERY =
            "CREATE TABLE " + ChatBox.NewChatInfo.TABLE_NAME + "(" + ChatBox.NewChatInfo.CHAT_BOX +
                    " TEXT);";

    public ChatDbHelper(Context context)
    {
        super(context,DATABASE_CHAT,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened ...");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table Create");
    }

    public void addInformation(String chat, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ChatBox.NewChatInfo.CHAT_BOX, chat);
        db.insert(ChatBox.NewChatInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","One row inserted ...");
    }

    public Cursor getInformation(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {ChatBox.NewChatInfo.CHAT_BOX};
        cursor = db.query(ChatBox.NewChatInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    public Cursor getChat(String chat_message, SQLiteDatabase sqLiteDatabase)
    {
//        String[] projections = {ChatBox.NewChatInfo.CHAT_BOX};
        String selection = ChatBox.NewChatInfo.CHAT_BOX + " LIKE ?";
        String[] selection_args= {chat_message};
        Cursor cursor = sqLiteDatabase.query

        (ChatBox.NewChatInfo.TABLE_NAME,null,selection,selection_args,null,null,null);
        return cursor;
    }

    public void deleteInformation (String chat_message, SQLiteDatabase sqLiteDatabase)
    {
        String selection = ChatBox.NewChatInfo.CHAT_BOX + " LIKE ?";
        String[] selection_args = {chat_message};
        sqLiteDatabase.delete(ChatBox.NewChatInfo.TABLE_NAME,selection,selection_args);
    }



    public int updateInformation(String old_message, String new_message, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ChatBox.NewChatInfo.CHAT_BOX,new_message);
        String selection = ChatBox.NewChatInfo.CHAT_BOX + " LIKE ?";
        String[] selection_args = {old_message};
        int count = sqLiteDatabase.update(ChatBox.NewChatInfo.TABLE_NAME,contentValues,selection,selection_args);
        return count;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }

}
