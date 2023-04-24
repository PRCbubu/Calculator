package com.example.newcalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    /*private double operation(TextView first, TextView second, Button operator)
    {

    }*/

    private void displayNum(String num)
    {
        StringBuffer stringBuffer =
        TextView answer = (TextView) findViewById(R.id.answer);
        answer.setText(num);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<TextView> Numpad = new ArrayList<>();

        Numpad.add((TextView) findViewById(R.id.Zero));
        Numpad.add((TextView) findViewById(R.id.One));
        Numpad.add((TextView) findViewById(R.id.Two));
        Numpad.add((TextView) findViewById(R.id.Three));
        Numpad.add((TextView) findViewById(R.id.Four));
        Numpad.add((TextView) findViewById(R.id.Five));
        Numpad.add((TextView) findViewById(R.id.Six));
        Numpad.add((TextView) findViewById(R.id.Seven));
        Numpad.add((TextView) findViewById(R.id.Eight));
        Numpad.add((TextView) findViewById(R.id.Nine));

        for(TextView pressedNum : Numpad)
        {
            pressedNum.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {

                }
            });
        }

    }
}