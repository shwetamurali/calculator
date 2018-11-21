package com.example.shwet.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button add;
    Button sub;
    Button mult;
    Button div;
    Button clear;
    Button equals;
    TextView display;
    String op ="";
    ArrayList<String> tokens = new ArrayList<String>();
    ArrayList<Double> nums = new ArrayList<Double>();
    ArrayList<String> ops = new ArrayList<String>();
    ArrayList<Integer> other = new ArrayList<Integer>();
    Boolean answer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.button);
        two= findViewById(R.id.button2);
        three=findViewById(R.id.button3);
        four= findViewById(R.id.button6);
        five=findViewById(R.id.button11);
        six=findViewById(R.id.button14);
        seven= findViewById(R.id.button9);
        eight= findViewById(R.id.button12);
        nine= findViewById(R.id.button15);
        zero= findViewById(R.id.button13);
        display=findViewById(R.id.textView);
        add=findViewById(R.id.button5);
        sub=findViewById(R.id.button17);
        mult=findViewById(R.id.button18);
        div=findViewById(R.id.button19);
        equals=findViewById(R.id.button16);
        clear=findViewById(R.id.button10);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        add.setOnClickListener(this);
        mult.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                if (answer) {
                    op = "1";
                    answer = false;
                } else
                    op += "1";
                break;
            case R.id.button2:
                if (answer) {
                    op = "2";
                    answer = false;
                } else
                    op += "2";
                break;
            case R.id.button13:
                if (answer) {
                    op = "0";
                    answer = false;
                } else
                    op += "0";
                break;
            case R.id.button3:
                if (answer) {
                    op = "3";
                    answer = false;
                } else
                    op += "3";
                break;

            case R.id.button6:
                if (answer) {
                    op = "4";
                    answer = false;
                } else
                    op += "4";
                break;
            case R.id.button11:
                if (answer) {
                    op = "5";
                    answer = false;
                } else
                    op += "5";
                break;
            case R.id.button14:
                if (answer) {
                    op = "6";
                    answer = false;
                } else
                    op += "6";
                break;
            case R.id.button9:
                if (answer) {
                    op = "7";
                    answer = false;
                } else
                    op += "7";
                break;
            case R.id.button12:
                if (answer) {
                    op = "8";
                    answer = false;
                } else
                    op += "8";
                break;
            case R.id.button15:
                if (answer) {
                    op = "9";
                    answer = false;
                } else
                    op += "9";
                break;
            case R.id.button16:
                StringTokenizer st = new StringTokenizer(op, "+" + "-" + "*" + "/", true);
                while (st.hasMoreTokens()) {
                    String test = st.nextToken();
                    tokens.add(test);
                    if (test.equals("+") || test.equals("-") || test.equals("*") || test.equals("/")) {
                        if (  tokens.get(0).equals("*") || tokens.get(0).equals("-") ||tokens.get(0).equals("+") ||tokens.get(0).equals("/")) {
                            op = "Error";
                        } else if (tokens.get(tokens.size() - 2).equals("-") || tokens.get(tokens.size() - 2).equals("+") || tokens.get(tokens.size() - 2).equals("/") || tokens.get(tokens.size() - 2).equals("*") ) {
                            op = "Error";
                        } else ops.add(test);
                    } else {
                        nums.add(Double.parseDouble(test));
                    }
                }

                if ( (nums.size() == ops.size()) || op.equals("Error") ) {
                    display.setText("Error");
                } else {
                    for (int i = 0; i < ops.size(); i++) {
                        if (ops.get(i).equals("/")) {
                            double now = nums.get(i);
                            double answer = (now / nums.get(i + 1));
                            nums.set(i+1, answer);
                            other.add(i);
                        } else if (ops.get(i).equals("*")) {
                            double now = nums.get(i);
                            nums.set(i + 1, nums.get(i + 1) * now);
                            other.add(i);
                        }
                    }
                    for (int i = other.size() - 1; i >= 0; i--) {
                        int now = other.get(i);
                        nums.remove(now);
                        ops.remove(now);
                    }

                    for (int j = 0; j < ops.size(); j++) {
                        if (ops.get(j).equals("+")) {
                            double now = nums.get(j);
                            nums.set(j + 1, now + nums.get(j + 1));
                        } else if (ops.get(j).equals("-")) {
                            double now = nums.get(j);
                            nums.set(j + 1, now - nums.get(j + 1));
                        }
                    }

                    if (nums.get(nums.size() - 1) == Math.round(nums.get(nums.size() - 1))) {
                        int what = ((int) Math.round(nums.get(nums.size() - 1)));
                        op = Integer.toString(what);
                    } else op = nums.get(nums.size() - 1).toString();
                    answer = true;
                }
                tokens = new ArrayList<String>();
                nums = new ArrayList<Double>();
                ops = new ArrayList<String>();
                other = new ArrayList<Integer>();
                break;

            case R.id.button5:
                op += "+";
                answer = false;
                break;
            case R.id.button19:
                op += "/";
                answer = false;
                break;
            case R.id.button17:
                op += "-";
                answer = false;
                break;
            case R.id.button18:
                op += "*";
                answer = false;
                break;

            case R.id.button10:
                op = "0";
                answer = true;
                break;
        }
        if(op.equals("Error")) {
            display.setText("Error");
            op="";
        }
        else
            display.setText(op);


    }

}

