package com.example.giaodienloginout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static  final String DBNAME="Login.db";
    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
    MyDB.execSQL("create table users(username TEXT primary key,email TEXT, password TEXT, confirmpassword TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table if exists users");
    }
    public  Boolean insertData(String username,String email,String password, String confirmpassword){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("confirmpassword",confirmpassword);
        long result=MyDB.insert("users",null,contentValues);
        if(result==-1) return false;
        else{
            return true;
        }
    }
    public Boolean checkUsername(String username){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery(" Select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0){
            return  true;
        }else {
            return false;
        }
    }


    public Boolean checkAccount(String username, String password) {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username= ? and password = ? ",new String[]{username,password});
        if (cursor.getCount()>0){
            return  true;
        }else {
            return false;
        }
    }
    public Boolean checkEmail(String email){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery(" Select * from users where email=?",new String[]{email});
        if(cursor.getCount()>0){
            return  true;
        }else {
            return false;
        }
    }
    public Boolean updatePassword(String email,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("password",password);
        long result=MyDB.update("users",contentValues,"email = ? ",new  String[]{email});
        if(result==-1){
            return  false;
        }else {
            return true;
        }
    }
}
