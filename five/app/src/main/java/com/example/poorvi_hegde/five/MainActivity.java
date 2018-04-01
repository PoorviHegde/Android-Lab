package com.example.poorvi_hegde.five;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String n,r,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("student",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS SDetail(name VARCHAR(20),regno VARCHAR(20),branch VARCHAR(20));");
        final EditText name = (EditText)findViewById(R.id.editText);
        final EditText reg = (EditText)findViewById(R.id.editText2);
        final EditText branch = (EditText)findViewById(R.id.editText3);
        Button submit = (Button)findViewById(R.id.button);
        Button show = (Button)findViewById(R.id.button2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = name.toString();
                r=reg.toString();
                b=branch.toString();
                int flag=0;
                try {
                    mydatabase.execSQL("INSERT INTO SDetail VALUES('"+n+"','"+r+"','"+b+"');");
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    flag=1;
                }
                if (flag == 0){
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
                startActivity(intent);

            }
        });
    }
}
