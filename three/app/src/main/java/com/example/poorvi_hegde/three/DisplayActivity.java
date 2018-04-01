package com.example.poorvi_hegde.three;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Poorvi_Hegde on 01-04-2018.
 */

public class DisplayActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        Intent i = getIntent();
        int day = i.getIntExtra("day",0);
        int year = i.getIntExtra("year",0);
        int month = i.getIntExtra("year",0);
        int from = i.getIntExtra("from",0);
        int to = i.getIntExtra("to",0);
        String date = ""+day+"/"+month+"/"+year;
        String source=getResources().getStringArray(R.array.from)[from];
        String dest = getResources().getStringArray(R.array.from)[to];

        String disp = "From:"+source+"\nTo:"+dest+"\nDate:"+date;
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(disp);


    }
}
