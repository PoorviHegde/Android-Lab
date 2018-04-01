package com.example.student.evalapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText rs = (EditText)findViewById(R.id.editText2);
                EditText dl = (EditText)findViewById(R.id.editText3);
                double rup = Double.parseDouble(String.valueOf(rs.getText()));
                Double dol = rup*0.016;
                String ans = "$"+dol.toString();
                dl.setText(ans);
            }
        });

    }
}
