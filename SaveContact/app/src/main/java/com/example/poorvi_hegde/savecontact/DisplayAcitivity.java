package com.example.poorvi_hegde.savecontact;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Poorvi_Hegde on 11-03-2018.
 */

public class DisplayAcitivity extends AppCompatActivity {
    final SQLiteDatabase mydatabase = openOrCreateDatabase("Poorvi",MODE_PRIVATE,null);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        Cursor res = mydatabase.rawQuery("Select * from contact",null);
        res.moveToFirst();
        String dis = res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3);
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(dis);
        Toast.makeText(DisplayAcitivity.this,dis.toString(),Toast.LENGTH_SHORT).show();
    }
}
