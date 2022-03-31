package com.example.tourist;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelp extends SQLiteOpenHelper {
    public DBhelp(Context context) {
        super(context,"Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails(uname TEXT primary key,fname TEXT,lname TEXT,mobile TEXT,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Userdetails");
    }

    public Boolean insertdata(String uname,String fname,String lname,String mobile,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("uname",uname);
        contentValues.put("fname",fname);
        contentValues.put("lname",lname);
        contentValues.put("mobile",mobile);
        contentValues.put("password",password);
        Long result=db.insert("Userdetails",null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    //    public Boolean loginval(String uname){
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor=db.rawQuery("select * from Userdetails where uname = ?",new String[] {uname});
//        if (cursor.getCount()>0)
//            return true;
//        else
//            return false;
//
//
//    }
    public Boolean checkuserpass(String uname,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from Userdetails where uname = ? and password = ?",new String[] {uname,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }



}
