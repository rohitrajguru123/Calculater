package com.example.calculater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private float valueOne = Float.NaN;
    private float valueTwo;
    private char currentAction;

    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonClear;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char EQUALS = '0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();        // Initialize views
        initListeners();    // Set button click listeners
    }

    // Initialize all the buttons and EditText
    private void initViews() {
        editText = findViewById(R.id.editText);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonClear = findViewById(R.id.buttonClear);
    }

    // Set listeners for all buttons
    private void initListeners() {
        View.OnClickListener numberClickListener = v -> {
            Button b = (Button) v;
            editText.append(b.getText().toString());
        };

        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);

        buttonAdd.setOnClickListener(v -> {
            performOperation();
            currentAction = ADDITION;
            editText.setText(null);
        });

        buttonSubtract.setOnClickListener(v -> {
            performOperation();
            currentAction = SUBTRACTION;
            editText.setText(null);
        });

        buttonMultiply.setOnClickListener(v -> {
            performOperation();
            currentAction = MULTIPLICATION;
            editText.setText(null);
        });

        buttonDivide.setOnClickListener(v -> {
            performOperation();
            currentAction = DIVISION;
            editText.setText(null);
        });

        buttonEqual.setOnClickListener(v -> {
            performOperation();
            currentAction = EQUALS;
            editText.setText(String.valueOf(valueOne));
            valueOne = Float.NaN;
        });

        buttonClear.setOnClickListener(v -> {
            editText.setText("");
            valueOne = Float.NaN;
            valueTwo = Float.NaN;
        });
    }

    private void performOperation() {
        if (!Float.isNaN(valueOne)) {
            valueTwo = Float.parseFloat(editText.getText().toString());
            switch (currentAction) {
                case ADDITION:
                    valueOne = valueOne + valueTwo;
                    break;
                case SUBTRACTION:
                    valueOne = valueOne - valueTwo;
                    break;
                case MULTIPLICATION:
                    valueOne = valueOne * valueTwo;
                    break;
                case DIVISION:
                    valueOne = valueOne / valueTwo;
                    break;
            }
        } else {
            valueOne = Float.parseFloat(editText.getText().toString());
        }
    }
}
