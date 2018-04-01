package com.example.poorvi_hegde.two;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String array[]={"one","two","three","four","five","one","two","three","four","five","one","two","three","four","five"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_view,array);
        GridView gridView = (GridView)findViewById(R.id.gv);
        gridView.setAdapter(arrayAdapter);
    }
}
