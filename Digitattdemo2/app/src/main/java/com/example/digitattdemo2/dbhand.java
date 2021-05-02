package com.example.digitattdemo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbhand extends SQLiteOpenHelper {
    String dbnam="Stsheet.db";
    String tname="student";
    StringBuilder ss;
    Context c;
    int version =3;
    public dbhand(@Nullable Context context) {
        super(context, "ekk.db", null, 4);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        ss=new StringBuilder();
        //ss.append("_class INTEGER PRIMARY KEY");
        for(int i=1;i<MainActivity.n+1;i++){
            ss.append(", _"+i+" VARCHAR(3)");

        }
        try {
            sqLiteDatabase.execSQL("CREATE TABLE "+"Class"+"(name VARCHAR(2000) PRIMARY KEY,number INTEGER)");
            //sqLiteDatabase.execSQL("CREATE TABLE "+tname+"(Class INTEGER PRIMARY KEY AUTOINCREMENT"+ss.toString()+")");
            Toast.makeText(c,"CREATE TABLE "+tname+" ("+ss.toString()+ss.toString()+')',Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(c,e.toString(),Toast.LENGTH_SHORT).show();
    }

        }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void ins(int[] ar,String tname){
        ContentValues c=new ContentValues();

        for(int i=1;i<MainActivity.n;i++){
         if(ar[i]==1){
             c.put("_"+i,"P");
         }
            if(ar[i]==0){
                c.put("_"+i,"A");
            }

        }
        SQLiteDatabase dd=this.getWritableDatabase();
        dd.insert(tname,null,c);

    }
    public Cursor show(){
        Cursor c;
        SQLiteDatabase sq=this.getWritableDatabase();
        c=sq.rawQuery("SELECT * FROM "+tname,null);
      return c;
    }
    public Cursor show(String tname){
        Cursor c;
        SQLiteDatabase sq=this.getWritableDatabase();
        c=sq.rawQuery("SELECT * FROM "+tname,null);
        return c;
    }
    public void del(String tname,Context c){
        SQLiteDatabase sq=this.getWritableDatabase();
        sq.execSQL("DROP TABLE IF EXISTS "+tname);
       // Toast.makeText(c,"TABLE HAS BEEN DELETED",Toast.LENGTH_LONG).show();
      // addclass(tname,MainActivity.n);
        sq.delete("Class","name = ?",new String[]{tname});
        Toast.makeText(c,tname+" Deleted",Toast.LENGTH_SHORT).show();
    }
    public void addclass(String s,int n,Context co){
        ss=new StringBuilder();
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        Cursor cc=show("Class");
        int f=0;



        try {

            for (int i = 1; i < n + 1; i++) {
                ss.append(", _" + i + " VARCHAR(3)");

            }

                sq.execSQL("CREATE TABLE " + s + "(Class INTEGER PRIMARY KEY AUTOINCREMENT" + ss.toString() + ")");

            c.put("name", s);
            c.put("number", n);

                sq.insert("Class", null, c);
                Toast.makeText(co,"Class created",Toast.LENGTH_SHORT).show();

            //Toast.makeText(co,"Already has this class",Toast.LENGTH_SHORT).show();
             }
            catch (Exception e){
            Toast.makeText(co,"Name format is not right or already have this class",Toast.LENGTH_LONG).show();
            CreateClass.f=96;
        //System.out.println(e.toString());
        }
        }
    public void create(){
        ss=new StringBuilder();
        SQLiteDatabase sq=this.getWritableDatabase();
        //ss.append("_class INTEGER PRIMARY KEY");
        for(int i=1;i<MainActivity.n+1;i++){
            ss.append(", _"+i+" VARCHAR(3)");

        }
        try {
            sq.execSQL("CREATE TABLE "+tname+"(Class INTEGER PRIMARY KEY AUTOINCREMENT"+ss.toString()+")");


        }catch (Exception e){
            Toast.makeText(c,e.toString(),Toast.LENGTH_SHORT).show();
        }

    }
}
