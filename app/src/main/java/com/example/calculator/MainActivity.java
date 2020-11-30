package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private Button zero, one, two, three, four, five, six, seven, eight, nine, clear, dot, equal;
    private Button lParentheses, rParentheses, backspace, add, subtract, multiply, divide;
    private TextView equation, result;
    String infix, sol;
    static Vector<Double> postfix = new Vector<>();


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
            sol = "";
            result.setText(sol);
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
            infixToPostfix();
            calculatePostfix();
            result.setText(sol);
            infix = "";
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

    private void calculatePostfix() {
        Stack<Double> operands = new Stack<>();
        int i, len;
        double n, op1, op2;
        len = postfix.size();
        for (i = 0; i < len; i++) {
            n = postfix.elementAt(i);
            if (n >= 0) {
                operands.push(n);
            } else {
                op2 = operands.pop();
                op1 = operands.pop();
                if (n == -1.0)
                    operands.push(op1 + op2);
                else if (n == -2.0)
                    operands.push(op1 - op2);
                else if (n == -3.0)
                    operands.push(op1 * op2);
                else if (n == -4.0)
                    operands.push(op1 / op2);
            }
        }
        sol = operands.peek().toString();
    }

    private void infixToPostfix() {
        int i, len;
        char ch;
        double number;
        Stack<Character> buffer = new Stack<>();

        len = infix.length();

        for (i = 0; i < len; i++) {
            ch = infix.charAt(i);

            //adds operands in int form to postfix
            if (Character.isDigit(ch)) {
                number = ch - '0';
                i++;
                while (i < len) {
                    ch = infix.charAt(i);
                    if (!Character.isDigit(ch)) {
                        break;
                    }
                    number = number * 10 + (ch - '0');
                    i++;
                }
                postfix.add(number);
            }

            //adds operators in int form to postfix
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!buffer.empty() && buffer.peek() != '(' && !higherPresident(ch, buffer.peek())) {
                    postfix.add(operatorToNegativeInt(buffer.pop()));
                }
                buffer.push(ch);
            }

            //handles parenthesis
            else if (ch == '(')
                buffer.push(ch);
            else if (ch == ')') {
                while (!buffer.empty() && buffer.peek() != '(') {
                    postfix.add(operatorToNegativeInt(buffer.pop()));
                }
                buffer.pop();
            }
        }

        //empties buffer
        while (!buffer.empty()) {
            postfix.add(operatorToNegativeInt(buffer.pop()));
        }
    }

    private boolean higherPresident(char c1, char c2) {
        if (c1 == '*' || c1 == '/') {
            return true;
        } else {
            return false;
        }
    }

    private double operatorToNegativeInt(char ch) {
        if (ch == '+')
            return -1.0;
        else if (ch == '-')
            return -2.0;
        else if (ch == '*')
            return -3.0;
        else if (ch == '/')
            return -4.0;
        else
            return -99.9;

    }
}