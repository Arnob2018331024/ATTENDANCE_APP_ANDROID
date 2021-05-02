package com.example.digitattdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateClass extends AppCompatActivity implements View.OnClickListener {
EditText e1,e2;
Button b1;
String s1,s2;
public static int f=0;
int n;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);
    e1=findViewById(R.id.ed1);
    e2=findViewById(R.id.ed2);
    b1=findViewById(R.id.bb1);


    b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        dbhand d=new dbhand(this);
        try {
            s1=e1.getText().toString();
            s2=e2.getText().toString();
            n=Integer.parseInt(s2);
            n++;
            f=69;
            d.addclass(s1,n,this);
            if(f==69)
            {//Toast.makeText(this,"Class created",Toast.LENGTH_SHORT).show();
            finish();}
        }catch (Exception e){
            Toast.makeText(this,"try again",Toast.LENGTH_SHORT).show();

        }

    }


}