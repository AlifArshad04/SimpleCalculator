package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero, one, two, three, four, five, six, seven, eight, nine, clear, dot, equal;
    private Button lParentheses, rParentheses, backspace, add, subtract, multiply, divide;
    private TextView equation, result;
    String infix, sol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infix = "";
        setupUIView();

        zero.setOnClickListener(v -> {
            infix += "0";
            equation.setText(infix);
        });

        one.setOnClickListener(v -> {
            infix += "1";
            equation.setText(infix);
        });

        two.setOnClickListener(v -> {
            infix += "2";
            equation.setText(infix);
        });

        three.setOnClickListener(v -> {
            infix += "3";
            equation.setText(infix);
        });

        four.setOnClickListener(v -> {
            infix += "4";
            equation.setText(infix);
        });

        five.setOnClickListener(v -> {
            infix += "5";
            equation.setText(infix);
        });

        six.setOnClickListener(v -> {
            infix += "6";
            equation.setText(infix);
        });

        seven.setOnClickListener(v -> {
            infix += "7";
            equation.setText(infix);
        });

        eight.setOnClickListener(v -> {
            infix += "8";
            equation.setText(infix);
        });

        nine.setOnClickListener(v -> {
            infix += "9";
            equation.setText(infix);
        });

        add.setOnClickListener(v -> {
            infix += "+";
            equation.setText(infix);
        });

        subtract.setOnClickListener(v -> {
            infix += "-";
            equation.setText(infix);
        });

        multiply.setOnClickListener(v -> {
            infix += "*";
            equation.setText(infix);
        });

        divide.setOnClickListener(v -> {
            infix += "/";
            equation.setText(infix);
        });

        lParentheses.setOnClickListener(v -> {
            infix += "(";
            equation.setText(infix);
        });

        rParentheses.setOnClickListener(v -> {
            infix += ")";
            equation.setText(infix);
        });

        clear.setOnClickListener(v -> {
            infix = "";
            equation.setText(infix);
        });

        backspace.setOnClickListener(v -> {
            if (infix.length() > 0) {
                infix = infix.substring(0, infix.length() - 1);
                equation.setText(infix);
            }
        });

        dot.setOnClickListener(v -> {
            infix += ".";
            equation.setText(infix);
        });

        equal.setOnClickListener(v -> {
            //to be added
            result.setText(sol);
        });


    }

    private void setupUIView() {
        zero = findViewById(R.id.butKey0);
        one = findViewById(R.id.butKey1);
        two = findViewById(R.id.butKey2);
        three = findViewById(R.id.butKey3);
        four = findViewById(R.id.butKey4);
        five = findViewById(R.id.butKey5);
        six = findViewById(R.id.butKey6);
        seven = findViewById(R.id.butKey7);
        eight = findViewById(R.id.butKey8);
        nine = findViewById(R.id.butKey9);
        clear = findViewById(R.id.butKeyAC);
        dot = findViewById(R.id.butKeyDot);
        equal = findViewById(R.id.butKeyEqual);
        lParentheses = findViewById(R.id.butKeyLParentheses);
        rParentheses = findViewById(R.id.butKeyRParentheses);
        backspace = findViewById(R.id.butKeyDel);
        add = findViewById(R.id.butKeyAdd);
        subtract = findViewById(R.id.butKeyMinus);
        multiply = findViewById(R.id.butKeyMultiply);
        divide = findViewById(R.id.butKeyDivide);
        equation = findViewById(R.id.txtEquation);
        result = findViewById(R.id.txtAnswer);

    }
}