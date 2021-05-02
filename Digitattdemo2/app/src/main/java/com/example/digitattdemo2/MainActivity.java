package com.example.digitattdemo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView t;
Button b1,b2;
int c,i,ar[];
public  static  int n=10;
public static String tname;
dbhand db;
List<String>l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=0;i=1;
      l=new ArrayList<String>();
    t=findViewById(R.id.r);
    b1=findViewById(R.id.p);
    b2=findViewById(R.id.a);
        t.setText(""+i);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        db=new dbhand(this);
        SQLiteDatabase sd=db.getWritableDatabase();
        ar=new int[n+1];
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.p){c++;l.add(t.getText().toString());ar[i]=1;}
        else ar[i]=0;
        i++;
        if(i==n) {
            StringBuilder ss=new StringBuilder();
             //for(int i=0;i<=n;i++)
            //ss.append(l.get(i)+", ");
           /*  Toast t=new Toast(MainActivity.this);
             t.setGravity(Gravity.CENTER,0,0);
             t.setText(ss);
             t.setDuration(Toast.LENGTH_LONG);
             t.show();*/
            //Toast.makeText(MainActivity.this,"presented students are:"+ss,Toast.LENGTH_SHORT).show();

        }
        if(i==n) {
            //Intent i=new Intent(MainActivity.this,menu.class);
            //startActivity(i);
            db.ins(ar,tname);
            finish();

        }
        else
        t.setText(""+i);
    }
    public void onBackPressed() {
        Intent i=new Intent(this, com.example.digitattdemo2.List.class);
        startActivity(i);
        finish();
        return;
    }

}