package com.example.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    //Assign variables to each widgets
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button addition;
    private Button subtract;
    private Button multiply;
    private Button division;
    private Button equal;
    private Button decimal;
    private Button clear;
    private Button btn;
    private TextView result;
    private TextView selection;

    //
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char DIVISION = '/';
    private final char MULTIPLICATION = '*';
    private final char EQUAL = '0';

    private double value1 = Double.NaN;
    private double value2;

    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        setViews();

        /*
        set onClickListeners on each button
         */
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection.setText(selection.getText().toString() + "0");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selection.setText(selection.getText().toString() + ".");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeOperations();
                ACTION = ADDITION;
                result.setText(String.valueOf(value1) + " +");
                selection.setText(null);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeOperations();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(value1) + " -");
                selection.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeOperations();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(value1) + " *");
                selection.setText(null);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeOperations();
                ACTION = DIVISION;
                result.setText(String.valueOf(value1) + " /");
                selection.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeOperations();
                ACTION = EQUAL;
                result.setText(String.valueOf(value1));
                selection.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selection.getText().length() > 0) {
                    CharSequence name = selection.getText().toString();
                    selection.setText(name.subSequence(0, name.length() - 1));
                } else {
                    value1 = Double.NaN;
                    value2 = Double.NaN;
                    selection.setText(null);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(null);
                value1 = Double.NaN;
                value2 = Double.NaN;
            }
        });
    }

    /*
    Associate defined variables with their ids on the xml layout
     */
    private void setViews() {

        one = findViewById(R.id.btn_one);
        two = findViewById(R.id.btn_two);
        three = findViewById(R.id.btn_three);
        four = findViewById(R.id.btn_four);
        five = findViewById(R.id.btn_five);
        six = findViewById(R.id.btn_six);
        seven = findViewById(R.id.btn_seven);
        eight = findViewById(R.id.btn_eight);
        nine = findViewById(R.id.btn_nine);
        zero = findViewById(R.id.btn_zero);
        addition = findViewById(R.id.btn_addition);
        subtract = findViewById(R.id.btn_subtract);
        multiply = findViewById(R.id.btn_multiply);
        division = findViewById(R.id.btn_divide);
        equal = findViewById(R.id.btn_equal);
        decimal = findViewById(R.id.btn_decimal);
        clear = findViewById(R.id.btn_clear);
        btn = findViewById(R.id.btn);

        result = findViewById(R.id.result_display);
        selection = findViewById(R.id.number_display);
    }

    private void computeOperations() {

        if (!Double.isNaN(value1)) {
            value2 = Double.parseDouble(selection.getText().toString());

            switch (ACTION) {
                //addition function
                case ADDITION:
                    value1 = value1 + value2;
                    break;

                //subtraction function
                case SUBTRACTION:
                    value1 = value1 - value2;
                    break;

                //multiplication function
                case MULTIPLICATION:
                    value1 = value1 * value2;
                    break;

                //division function
                case DIVISION:
                    value1 = value1 / value2;
                    break;

                case EQUAL:
                    break;
            }
        } else {
            value1 = Double.parseDouble(selection.getText().toString());
        }
    }
}
