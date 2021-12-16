package com.example.drawermenuex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static  final String DBNAME="Login.db";
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
    MyDB.execSQL("create table users(fullname TEXT,username TEXT primary key,email TEXT, password TEXT, confirmpassword TEXT,birthday TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table if exists users");
    }
    public  Boolean insertData(String fullname,String username,String email,String password, String confirmpassword,String birthday){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("fullname",fullname);
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("confirmpassword",confirmpassword);
        contentValues.put("birthday",birthday);
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
    public Boolean checkEmailPassword(String email,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery(" Select * from users where email=? and password=? ",new String[]{email,password});
        if(cursor.getCount()>0){
            return  true;
        }else {
            return false;
        }
    }
    public Boolean editPassword(String email,String password){
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
    public Boolean checkProfile(String fullname,String username, String email,String password,String confirmpassword, String birthday){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery(" Select * from users where fullname=? and username=? and email=? and password=? and confirmpassword=? and birthday=?",new String[]{fullname,username,email,password,confirmpassword,birthday});
        if(cursor.getCount()>0){
            return  true;
        }else {
            return false;
        }
    }
    public Cursor getdata(String username) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from users where username = ?", new String[]{username});
        return cursor;

    }
    public Boolean updateuserdata( String fullName, String username, String email, String birthday) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", fullName);
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("birthday", birthday);
        Cursor cursor = DB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            long result = DB.update("users", contentValues, "username=?", new String[]{username});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
