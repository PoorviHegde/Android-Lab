package com.example.poorvi_hegde.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    ListView list_view;
    String contact;
    List<String> list = new ArrayList<String>();
    ArrayAdapter<String > adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view = findViewById(R.id.list_view);
        list.add("Appa");
        list.add("Amma");
        list.add("Bhargavi");
        list.add("Chaitra");
        list.add("Doddamma");
        list.add("Harshu");
        list.add("Lokesh");
        list.add("Meghakka");
        list.add("Nityoo");
        list.add("Poornima");
        list.add("Rushii");
        list.add("Sahu");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        list_view.setAdapter(adapter);
        registerForContextMenu(list_view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
        {
            case R.id.message:
            {
                contact = Long.toString(info.id);
                Intent send = new Intent(Intent.ACTION_VIEW);
                send.putExtra("address",contact);
                send.putExtra("sms_body","");
                send.setType("vnd.android-dir/mms-sms");
                startActivity(send);
            }
            case R.id.saveloc:
            {
                Toast.makeText(MainActivity.this,"Save in Phone is Selected", LENGTH_SHORT).show();
            }
            case R.id.call:
            {
                Toast.makeText(MainActivity.this,"Whatsapp found", LENGTH_SHORT).show();
            }

            case R.id.otherdet:
            {

            }
        }
        return super.onContextItemSelected(item);

    }
}
