package com.example.poorvi_hegde.imagemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView iv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView)findViewById(R.id.imageView);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,iv);
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                       // String it = ""+menuItem.getItemId();
                        switch(menuItem.getItemId()){
                            case R.id.one:
                                Toast.makeText(MainActivity.this, "" + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                LayoutInflater inflater = getLayoutInflater();
                                View view = inflater.inflate(R.layout.toastcat, null);
                                Toast toast = new Toast(MainActivity.this);
                                toast.setView(view);
                                toast.setDuration(Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                                toast.show();

                            case R.id.two:
                               LayoutInflater inflater2 = getLayoutInflater();
                                View view2 = inflater2.inflate(R.layout.toastdog, null);
                                Toast toast2 = new Toast(MainActivity.this);
                                toast2.setView(view2);
                                toast2.setDuration(Toast.LENGTH_SHORT);
                                toast2.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                                toast2.show();

                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });
    }
}
