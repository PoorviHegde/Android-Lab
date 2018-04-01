package com.example.poorvi_hegde.foodorder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //String[] items={"milk","egg","chocolate","biscuit","wheat","rice","fruit"};
   // int[] price={25,10,50,50,70,80,100};
    String cost,Total;
    int amt;
    Button btn;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
   // int f1,f2,f3,f4,f5,f6,f7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1 = (CheckBox)findViewById(R.id.milk);
        cb2 = (CheckBox)findViewById(R.id.egg);
        cb3 = (CheckBox)findViewById(R.id.chocolate);
        cb4 = (CheckBox)findViewById(R.id.biscuit);
        cb5 = (CheckBox)findViewById(R.id.wheat);
        cb6 = (CheckBox)findViewById(R.id.rice);
        cb7 = (CheckBox)findViewById(R.id.fruit);
        amt=0;
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked()){
                    amt=amt+25;
                    cost=cost+"\nmilk:25";
                }
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb2.isChecked()){
                    amt=amt+10;
                    cost=cost+"\negg:10";
                }
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb3.isChecked()){
                    amt=amt+50;
                    cost=cost+"\nchocolate:50";
                }
            }
        });
        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb4.isChecked()){
                    amt=amt+50;
                    cost=cost+"\nbiscuit:50";
                }
            }
        });
        cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb5.isChecked()){
                    amt=amt+70;
                    cost=cost+"\nwheat:70";
                }
            }
        });
        cb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb6.isChecked()){
                    amt=amt+80;
                    cost=cost+"\nrice:80";
                }
            }
        });
        cb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb7.isChecked()){
                    amt=amt+100;
                    cost=cost+"\nfruit:100";
                }
            }
        });

        Total = "Total:"+Integer.toString(amt);
        cost = cost+Total;

        btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(MainActivity.this,cost,Toast.LENGTH_SHORT).show();
            }
        });

    }



}
