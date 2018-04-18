package com.example.readfromdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.StringSearch;
import android.util.Log;

/**
 * Created by tom on 7/2/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME= "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE " + UserContract.NewUserInfo.TABLE_NAME
            + "(" + UserContract.NewUserInfo.USER_NAME + " TEXT," +
                    UserContract.NewUserInfo.USER_MOB + " TEXT," +
                    UserContract.NewUserInfo.USER_EMAIL +
            " TEXT);";//always make sure that there is a space after the key

    public UserDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created / opened ...");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Tabel Create...");
    }

    public void addInformatoins(String name, String mob, String email, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME, name);
        contentValues.put(UserContract.NewUserInfo.USER_MOB, mob);
        contentValues.put(UserContract.NewUserInfo.USER_EMAIL,email);
        db.insert(UserContract.NewUserInfo.TABLE_NAME,null,contentValues);//null, will not create a new row
        Log.e("DATABASE OPERATIONS", "One row inserted ...");
    }

    public Cursor getInformation(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {UserContract.NewUserInfo.USER_NAME, UserContract.NewUserInfo.USER_MOB,
        UserContract.NewUserInfo.USER_EMAIL};
        cursor = db.query(UserContract.NewUserInfo.TABLE_NAME, projections,null,null,null,null,null);
        return cursor;
    }

    public Cursor getContact(String user_name, SQLiteDatabase sqLiteDatabase)
    {
        String[] projections = {UserContract.NewUserInfo.USER_MOB, UserContract.NewUserInfo.USER_EMAIL};
        String selection = UserContract.NewUserInfo.USER_NAME + " LIKE ?";
        String[] selection_args = {user_name};
        Cursor cursor = sqLiteDatabase.query(UserContract.NewUserInfo.TABLE_NAME,projections,selection,selection_args,null,null,null);
        return cursor;
    }

    public void deleteInformation(String user_name, SQLiteDatabase sqLiteDatabase)
    {
        String selection = UserContract.NewUserInfo.USER_NAME + " LIKE ?";
        String[] selection_args = {user_name};
        sqLiteDatabase.delete(UserContract.NewUserInfo.TABLE_NAME,selection,selection_args);
    }

    public int updateInformation(String old_name,String new_name,String new_mobile,String new_email,SQLiteDatabase sqLiteDatabase){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME,new_name);
        contentValues.put(UserContract.NewUserInfo.USER_MOB,new_mobile);
        contentValues.put(UserContract.NewUserInfo.USER_EMAIL,new_email);
        String selection = UserContract.NewUserInfo.USER_NAME + " LIKE ?";
        String[] selection_args = {old_name};
        int count = sqLiteDatabase.update(UserContract.NewUserInfo.TABLE_NAME,contentValues,selection,selection_args);
        return count;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
