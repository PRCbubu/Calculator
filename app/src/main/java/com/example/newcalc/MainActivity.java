package com.example.newcalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    /*private double operation(TextView first, TextView second, Button operator)
    {

    }*/

    private void mainDisplayNum(String num)
    {
        TextView answer = (TextView) findViewById(R.id.answer);
        answer.setHorizontallyScrolling(true);
        answer.setText(num);

        if(num.contains("="))
        {

            secondaryDisplayNum(num);
            calculator(num);
        }
    }

    private void secondaryDisplayNum(String num2)
    {
        TextView calculations = (TextView) findViewById(R.id.calculations);
        calculations.setText(num2);
    }

    private void calculator(String num)
    {
        Double num1;
        Double num2;
        Double ans;
        if(num.contains("+"))
        {
            num1 = Double.parseDouble(num.substring(0,num.indexOf("+")));
            num2 = Double.parseDouble(num.substring(num.indexOf("+")+1, num.indexOf("=")));
            ans = num1+num2;
            //Log.i("tag", ""+ans);
            mainDisplayNum(String.valueOf(ans));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<TextView> Numpad = new ArrayList<>();
        ArrayList<AppCompatButton> operations = new ArrayList<>();

        operations.add((AppCompatButton) findViewById(R.id.AC));
        operations.add((AppCompatButton) findViewById(R.id.Erase));
        operations.add((AppCompatButton) findViewById(R.id.Percent));
        operations.add((AppCompatButton) findViewById(R.id.Divide));
        operations.add((AppCompatButton) findViewById(R.id.Multiply));
        operations.add((AppCompatButton) findViewById(R.id.Minus));
        operations.add((AppCompatButton) findViewById(R.id.Add));
        operations.add((AppCompatButton) findViewById(R.id.Equalto));

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
        Numpad.add((TextView) findViewById(R.id.point));
        Numpad.add((TextView) findViewById(R.id.Brackets));
        final String[] temp = {""};

        for(TextView pressedNum : Numpad)
        {
            pressedNum.setOnClickListener(new View.OnClickListener()
            {
                boolean bracketFlag = true;
                boolean pointFlag = true;

                @Override
                public void onClick(View view)
                {

                    if(Numpad.indexOf(pressedNum) == 11)
                    {
                        if(bracketFlag)
                        {
                            bracketFlag = false;
                            temp[0] += '(';
                            mainDisplayNum(temp[0]);
                        }
                        else
                        {
                            bracketFlag = true;
                            temp[0] += ')';
                            mainDisplayNum(temp[0]);
                        }
                    }
                    else
                    {
                        if(pressedNum.isPressed()&&pointFlag)
                            temp[0] += pressedNum.getText();
                        mainDisplayNum(temp[0]);
                    }

                    if(Numpad.indexOf(pressedNum) == 10)
                    {
                        pointFlag = false;
                    }
                    if(!temp[0].contains(".") || temp[0].contains("+") || temp[0].contains("-") || temp[0].contains("*") || temp[0].contains("/"))
                        pointFlag = true;
                }
            });
        }

        for(AppCompatButton button : operations)
        {
            button.setOnClickListener(new View.OnClickListener()
            {
                boolean operatorFlag = true;
                TextView answer = (TextView) findViewById(R.id.answer);
                @Override
                public void onClick(View view)
                {
                    if(button.getText().equals("AC"))
                    {
                        answer.setText("");
                        mainDisplayNum(temp[0]);
                    }


                    if (button.getText().equals("ERS"))
                    {
                        temp[0] = temp[0].substring(0, temp[0].length()-1);
                        mainDisplayNum(temp[0]);

                    }

                    if(button.getTag().equals("Add") && operatorFlag)
                    {
                        temp[0]+= "+";
                        mainDisplayNum(temp[0]);
                        operatorFlag = false;
                        //Toast.makeText(getApplicationContext(), "Pressed", Toast.LENGTH_SHORT).show();
                    }
                    if(button.getTag().equals("Minus") && operatorFlag)
                    {
                        temp[0]+= "-";
                        mainDisplayNum(temp[0]);
                        operatorFlag = false;
                        //Toast.makeText(getApplicationContext(), "Pressed", Toast.LENGTH_SHORT).show();
                    }
                    if(button.getTag().equals("Multiply") && operatorFlag)
                    {
                        temp[0]+= "*";
                        mainDisplayNum(temp[0]);
                        operatorFlag = false;
                        //Toast.makeText(getApplicationContext(), "Pressed", Toast.LENGTH_SHORT).show();
                    }
                    if(button.getTag().equals("Divide") && operatorFlag)
                    {
                        temp[0]+= "/";
                        mainDisplayNum(temp[0]);
                        operatorFlag = false;
                        //Toast.makeText(getApplicationContext(), "Pressed", Toast.LENGTH_SHORT).show();
                    }
                    if(button.getTag().equals("Equalto"))
                    {
                        temp[0]+= "=";
                        mainDisplayNum(temp[0]);
                        operatorFlag = true;
                        //Toast.makeText(getApplicationContext(), "Pressed", Toast.LENGTH_SHORT).show();
                        //temp[0] ="";
                    }
                }
            });
        }

    }
}