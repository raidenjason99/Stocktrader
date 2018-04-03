package com.example.user.stocktrader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class ListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Field[] fields = R.array.class.getFields();
        LinearLayout area = (LinearLayout) findViewById(R.id.area);

        for (int i = 0; i < fields.length; i++)
        //for (Field value : fields)
        {

            // for (Field value : fields)

            String name = fields[i].getName();
            String lower = name.toLowerCase();
            Character c = lower.charAt(0);
            if (c >= 'a' && c <= 'z')
            {
                TextView stack = new TextView(this);
                stack.setText(name);
                area.addView(stack);



            }


        }
    }





    public void Doneonclikc(View v)
     {
         this.finish();
     }
}
