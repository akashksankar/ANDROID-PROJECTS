package com.example.caaalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvExpression;
    private TextView tvResult;
    private StringBuilder expression = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvExpression = findViewById(R.id.tvExpression);
        tvResult = findViewById(R.id.tvResult);

        int[] buttonIds = {
                R.id.b0, R.id.b1, R.id.b2, R.id.b3, R.id.b4,
                R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9,
                R.id.bAdd, R.id.bSub, R.id.bMul, R.id.bDiv
        };

        View.OnClickListener standardListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String text = b.getText().toString();

                if (expression.toString().equals("0") && !isOperator(text)) {
                    expression.setLength(0);
                }

                expression.append(text);
                tvExpression.setText(expression.toString());
            }
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(standardListener);
        }

        findViewById(R.id.bEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expStr = expression.toString();
                if (expStr.isEmpty()) return;

                try {
                    double result = evaluate(expStr);
                    if (result == (long) result) {
                        tvResult.setText("Result: " + String.format("%d", (long) result));
                    } else {
                        tvResult.setText("Result: " + String.format("%s", result));
                    }
                } catch (Exception e) {
                    tvResult.setText("Error");
                }
            }
        });
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private double evaluate(String exp) {
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder numBuffer = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch) || ch == '.') {
                numBuffer.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (numBuffer.length() > 0) {
                    numbers.add(Double.parseDouble(numBuffer.toString()));
                    numBuffer.setLength(0);
                }
                operators.add(ch);
            }
        }
        if (numBuffer.length() > 0) {
            numbers.add(Double.parseDouble(numBuffer.toString()));
        }

        if (numbers.isEmpty()) return 0;

        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            if (op == '*' || op == '/') {
                double left = numbers.get(i);
                double right = numbers.get(i + 1);
                double intermediate = op == '*' ? left * right : left / right;

                numbers.set(i, intermediate);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }

        double total = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            double nextNum = numbers.get(i + 1);
            if (op == '+') total += nextNum;
            if (op == '-') total -= nextNum;
        }

        return total;
    }
}
