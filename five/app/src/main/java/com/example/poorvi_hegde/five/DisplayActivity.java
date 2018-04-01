package com.example.poorvi_hegde.five;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.TextureView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.AccessibleObject;
import java.util.zip.Inflater;

/**
 * Created by Poorvi_Hegde on 01-04-2018.
 */

public class DisplayActivity extends Activity {

    private TextView getTextView(int id, String text){
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setId(id);
        return tv;
    }

    private TableRow.LayoutParams getTlParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(1,2,1,2);
        return params;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        SQLiteDatabase mydatabase = openOrCreateDatabase("student",MODE_PRIVATE,null);
        Cursor cursor = mydatabase.rawQuery("SELECT * FROM SDetail",null);


        TableLayout tableLayout =(TableLayout)findViewById(R.id.tl);
        TableRow tr = new TableRow(this);
        //tr.setLayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT);
        int i=1;
        if(cursor.moveToFirst()){
            do{
                tr.setLayoutParams(getTlParams());
                String name = cursor.getString(1);
                String reg = cursor.getString(2);
                String br = cursor.getString(3);
                tr.addView(getTextView(i,name));
                tr.addView(getTextView(i,reg));
                tr.addView(getTextView(i,br));
                i++;
            }while (cursor.moveToLast());

        }





    }
}
