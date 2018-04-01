package com.example.poorvi_hegde.savecontact;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener */{
    String myname,contact,email;
    Button button,button2;
    //final SQLiteDatabase mydatabase = openOrCreateDatabase("Poorvi",MODE_PRIVATE,null);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        final SQLiteDatabase mydatabase = openOrCreateDatabase("Poorvi",MODE_PRIVATE,null);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               EditText n = (EditText)findViewById(R.id.editText);
               myname = n.getText().toString();
               myname = "'"+myname+"'" ;
               EditText c = (EditText)findViewById(R.id.editText2);
               contact = c.getText().toString();
               contact = "'"+contact+"'";
               EditText e = (EditText)findViewById(R.id.editText3);
               email = e.getText().toString();
               email = "'"+email+"'";
              // Toast.makeText(MainActivity.this,name+contact+email,Toast.LENGTH_LONG).show();
              try {
                   mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Contact(Name VARCHAR,Phone VARCHAR,Email VARCHAR);");
               }catch (SQLException ex)
               {
                   Toast.makeText(MainActivity.this,ex.toString(),Toast.LENGTH_SHORT).show();
               }

                try {
                   //mydatabase.execSQL("INSERT INTO Contact VALUES('test','0987654321','test@gmil.com');");
                    mydatabase.execSQL("INSERT INTO Contact VALUES("+myname+","+contact+","+email+");");
                }catch (SQLException ex)
                {
                    Toast.makeText(MainActivity.this,ex.toString(),Toast.LENGTH_LONG).show();
                }





            }
        });

       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Cursor res = mydatabase.rawQuery("Select * from contact",null);
               int l= res.getCount();
               res.moveToFirst();
               String dis = res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3);
              // TextView tv = (TextView)findViewById(R.id.textView);
               //tv.setText(dis);
               Toast.makeText(MainActivity.this,dis.toString(),Toast.LENGTH_SHORT).show();
           }
       });

    }

    /*@Override
    public void onClick(View view) {
       //Intent i=new Intent(MainActivity.this, DisplayAcitivity.class);
       //startActivity(i);
        final SQLiteDatabase mydatabase = openOrCreateDatabase("Poorvi",MODE_PRIVATE,null);

        Cursor res = mydatabase.rawQuery("Select * from contact",null);
        int l= res.getCount();
        res.moveToFirst();
        String dis = res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3);
            TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(dis);
        Toast.makeText(MainActivity.this,dis.toString(),Toast.LENGTH_SHORT).show();
    }*/
}
