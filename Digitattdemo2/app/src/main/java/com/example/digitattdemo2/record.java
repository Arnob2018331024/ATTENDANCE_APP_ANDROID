package com.example.digitattdemo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class record extends AppCompatActivity implements View.OnClickListener {
dbhand db;
Cursor c;
public static String tname;
TextView t,tv,pt;
ImageView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        db=new dbhand(this);
        c=db.show(tname);
        t=findViewById(R.id.rect);
        StringBuffer sb=new StringBuffer();
        StringBuffer per=new StringBuffer();
        sb. append("Class||Records[Roll(A/P)] ");
        t3=findViewById(R.id.del);
        tv=findViewById(R.id.tvv);
        pt=findViewById(R.id.per);
        tv.setText(tname);
        t3.setOnClickListener(this);
        /*for(int i=1;i<12;i++){
            sb.append(""+i+" ");

        }*/
        sb.append("\n");
        int present[]=new int[MainActivity.n+1],clas=0;
        if(c.getCount()!=0)
        while(c.moveToNext()){
            clas++;
            for(int i=0;i<MainActivity.n;i++){
                if(i==0)
                sb.append("#"+c.getString(i)+"|| ");
                else 
                {sb.append(i+"("+c.getString(i)+")  ");if(c.getString(i).equals("P"))present[i]++;}
               // sb.append(c.getString(i)+" ");
            }
    sb.append("\n");
        }
        per.append("persantage(%) ");
        if(clas!=0)
        for(int j=1;j<=MainActivity.n;j++)present[j]=(present[j]*100)/clas;
        for(int j=1;j<MainActivity.n;j++)per.append(j+"("+present[j]+")  ");
        t.setText(sb.toString());
        pt.setText(per.toString());
        //Toast.makeText(this,"class "+clas,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.del){
            new AlertDialog.Builder(this).setTitle("DELETE!").setMessage("Delete this class?").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    new dbhand(record.this).del(tname,record.this);
                    List.st=1;
                    Intent ii=new Intent(record.this,List.class);
                    startActivity(ii);
                    finish();

                }
            }).setNegativeButton(android.R.string.no,null).setIcon(android.R.drawable.ic_dialog_alert).show();

           }
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,List.class);
        startActivity(i);
        finish();
        return;
    }
}