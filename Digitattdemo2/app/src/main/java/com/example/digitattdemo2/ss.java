package com.example.digitattdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import static java.lang.Thread.*;

public class ss extends AppCompatActivity {

ProgressBar p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss);

        p=findViewById(R.id.pr);
        p.setProgress(0);
    Thread t= new Thread() {
        @Override
        public void run() {
           for(int i=0;i<=100;i+=10){
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               p.setProgress(i);
           }
            Intent i=new Intent(ss.this,menu.class);
           startActivity(i);
           finish();
        }
    };
    t.start();
    }
}