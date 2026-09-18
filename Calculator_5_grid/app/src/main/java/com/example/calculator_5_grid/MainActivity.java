package com.example.calculator_5_grid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView display;
    Button add, subtract, multiply, divide, equals, reset;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        display = findViewById(R.id.display);

        add = findViewById(R.id.buttonAdd);
        subtract = findViewById(R.id.buttonSubtract);
        multiply = findViewById(R.id.buttonMultiply);
        divide = findViewById(R.id.buttonDivide);
        equals = findViewById(R.id.buttonEquals);
        reset = findViewById(R.id.buttonReset);

        add.setOnClickListener(v -> operator = "+");
        subtract.setOnClickListener(v -> operator = "-");
        multiply.setOnClickListener(v -> operator = "*");
        divide.setOnClickListener(v -> operator = "/");

        equals.setOnClickListener(v -> {
            double n1 = Double.parseDouble(num1.getText().toString());
            double n2 = Double.parseDouble(num2.getText().toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    result = n1 / n2;
                    break;
                default:
                    display.setText("Select operator");
                    return;
            }

            display.setText(String.valueOf(result));
        });

        reset.setOnClickListener(v -> {
            num1.setText("");
            num2.setText("");
            display.setText("0.0");
            operator = "";
        });
    }
}
