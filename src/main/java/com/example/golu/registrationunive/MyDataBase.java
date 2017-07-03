package com.example.golu.registrationunive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GOLU on 04-06-2017.
 */

public class MyDataBase {

    private MyHelper mh;
    private SQLiteDatabase sdb;



    public MyDataBase(Context context) {
        mh=new MyHelper(context,"techpalle",null,1);
        //searchFragment=new SearchFragment();
    }

    public void open() {
        sdb=mh.getWritableDatabase();
    }

    public void insertStudent(String sno, String sname, String smobile, String semail, String subject, String description, String sdate) {
        ContentValues cv=new ContentValues();
        cv.put("no",sno); //1st parameter is =column name,2nd =value
        cv.put("name",sname);
        cv.put("mobile",smobile);
        cv.put("email",semail);
        cv.put("subject",subject);
        cv.put("description",description);
        cv.put("date",sdate);
        sdb.insert("student",null,cv);


    }
    public void close(){
        sdb.close();   //This Avoic memory Leak Problem
    }

    public Cursor queryStudent() {

        Cursor c=null;

        //Below query will return all table from Student table
        //below command is same as = select * from student
        c=sdb.query("student",null,null,null,null,null,null);

        return c;
    }

   public Cursor searchStudent(String s1) {

        Cursor c=null;
        //Below query will return all table from Student table
        //below command is same as = select * from student
        String s=s1;

        c=sdb.query("student",null,"name=?",new String[]{s},null,null,null);
        if(c!=null && c.moveToFirst()==true){

                String sname=c.getString(2);
                String mobile=c.getString(3);
                String email=c.getString(4);
                String subject=c.getString(5);




        }
        return c;
    }

    public Cursor deleteStudent(String dname) {
        Cursor c2=null;
        String p=dname;

         sdb.delete("student","name=?",new String[]{p});

        return c2;
    }

    public Cursor searchStudentMobi(String cellText) {
        Cursor c3=null;
        //Below query will return all table from Student table
        //below command is same as = select * from student

        String m=cellText;
        c3=sdb.query("student",null,"mobile=?",new String[]{m},null,null,null);
        if(c3!=null && c3.moveToFirst()==true){

            String sname=c3.getString(2);
            String mobile=c3.getString(3);
            String email=c3.getString(4);
            String subject=c3.getString(5);




        }
        return c3;
    }


    public class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table student(_id integer primary key,no text,name text,mobile text,email text,subject text,description text,date text);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
