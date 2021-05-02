package com.example.digitattdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class List extends AppCompatActivity {
  ListView l;
  ArrayList<String> s;
  ArrayList<Integer> n;
  public static int st=-1;
  dbhand d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        l=findViewById(R.id.l);
        s=new ArrayList<String>();
        n=new ArrayList<Integer>();
        d=new dbhand(this);
        Cursor c=d.show("Class");
        while(c.moveToNext()){
            s.add(c.getString(0));
            n.add(c.getInt(1));

        }

        ArrayAdapter<String> a=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,s);
        l.setAdapter(a);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.n=n.get(i);

                if(st==1)
                {record.tname=s.get(i);
                Intent ii=new Intent(List.this,record.class);
                startActivity(ii);
                finish();
                }
                else{
                    MainActivity.tname=s.get(i);
                    Intent ii=new Intent(List.this,MainActivity.class);
                    startActivity(ii);
                    finish();

                }
                //finish();
            }
        });

    }
}