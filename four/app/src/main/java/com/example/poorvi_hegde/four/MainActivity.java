package com.example.poorvi_hegde.four;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1: {
                Toast.makeText(this, "Item1", Toast.LENGTH_SHORT).show();

            }
            case R.id.item12:{
                Toast.makeText(this, "Item12", Toast.LENGTH_SHORT).show();
            }
            case R.id.item13:{
                Toast.makeText(this, "Item13", Toast.LENGTH_SHORT).show();
            }
            case R.id.item2:{
                Toast.makeText(this, "Item2", Toast.LENGTH_SHORT).show();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
