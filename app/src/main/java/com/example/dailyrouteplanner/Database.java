package com.example.dailyrouteplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1="create table users(username text,email text,password text)";
        db.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void register(String username,String email,String password) {
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }

    public int login(String username,String password){
        int res=0;
        String s[]=new String[2];
        s[0]=username;
        s[1]=password;
        SQLiteDatabase db= getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where username=? and password=?" ,s);
        if (c.moveToFirst()){
            res=1;
        }
        return res;
    }
}
