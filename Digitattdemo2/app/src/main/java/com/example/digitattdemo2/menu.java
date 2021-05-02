package com.example.digitattdemo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity implements View.OnClickListener {
Button t1,t3,t2;
   dbhand d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    t1=findViewById(R.id.tt1);
     t2=findViewById(R.id.tt2);
     t3=findViewById(R.id.tt3);
   t1.setOnClickListener(this);
   t2.setOnClickListener(this);
   t3.setOnClickListener(this);
   d=new dbhand(this);
       try {

       }catch (Exception e){
           Toast.makeText(this,"yeeee got it",Toast.LENGTH_LONG).show();
       }

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.tt1){
            //Intent i=new Intent(menu.this,MainActivity.class);
            //startActivity(i);
           //finish();
            List.st=2;
            Intent i=new Intent(this,List.class);
            startActivity(i);

        }
        if(view.getId()==R.id.tt2){
            List.st=1;
            Intent i=new Intent(this,List.class);
            startActivity(i);

        }
        if(view.getId()==R.id.tt3){

            Intent i=new Intent(this,CreateClass.class);
            startActivity(i);

        }



    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setTitle("Exit!").setMessage("Do you want to exit?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }
                ).setNegativeButton(android.R.string.no,null).setIcon(android.R.drawable.ic_dialog_alert).show();
    }
}