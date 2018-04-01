package com.example.poorvi_hegde.three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int from,to;
    String date;
    int year,day,month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner)findViewById(R.id.from);
        final Spinner spinner2 = (Spinner)findViewById(R.id.to);
        final DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        Button submit = (Button)findViewById(R.id.button);
        Button clear = (Button)findViewById(R.id.button2);

        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.from,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = datePicker.getYear();
                day = datePicker.getDayOfMonth();
                month = datePicker.getMonth();
                //date = ""+day+"/"+"month"+"year";
                from = spinner.getSelectedItemPosition();
                to = spinner2.getSelectedItemPosition();
                Intent i = new Intent(MainActivity.this,DisplayActivity.class);
                i.putExtra("year",year);
                i.putExtra("day",day);
                i.putExtra("month",month);
                i.putExtra("from",from);
                i.putExtra("to",to);
                startActivity(i);

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setSelection(0);
                spinner2.setSelection(0);
                
            }
        });


    }
}
