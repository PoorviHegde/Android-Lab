package com.example.student.guessgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {
    int num,num_entered;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num=RandomGenerate();
        tv = (TextView)findViewById(R.id.textView3);

        tv.setText("Actual:"+String.valueOf(num));

        btn = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText et = (EditText)findViewById(R.id.editText2);
                num_entered=Integer.parseInt(et.getText().toString()) ;

                if(num_entered==num)
                {
                    Toast.makeText(getApplicationContext(),"Right Guess!",Toast.LENGTH_SHORT).show();
                    num = RandomGenerate();
                    tv.setText("Actual:"+String.valueOf(num));
                }
                else if (num_entered>num)
                {
                    Toast.makeText(getApplicationContext(),"Guess a smaller number",Toast.LENGTH_SHORT).show();

                }
                else if(num_entered<num)
                {
                    Toast.makeText(getApplicationContext(),"Guess a bigger number",Toast.LENGTH_SHORT).show();

                }

            }
        });






    }

    public int RandomGenerate()
    {
        Random r = new Random();
        int Low = 0;
        int High = 20;
        int Result = r.nextInt(High-Low) + Low;
        return Result;
    }
}
