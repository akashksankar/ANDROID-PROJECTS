package com.example.calculator5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText number1,number2;
    Button btn1,btn2,btn3,btn4;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        number1=findViewById(R.id.num1);
        number2=findViewById(R.id.num2);
        btn1=findViewById(R.id.add);
        btn2=findViewById(R.id.sub);
        btn3=findViewById(R.id.mul);
        btn4=findViewById(R.id.div);
        result=findViewById(R.id.result);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a= Integer.parseInt(number1.getText().toString());
                int b = Integer.parseInt(number2.getText().toString());
                int res= a+b;
                result.setText(String.valueOf(res));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a= Integer.parseInt(number1.getText().toString());
                int b = Integer.parseInt(number2.getText().toString());
                int res= a-b;
                result.setText(String.valueOf(res));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a= Integer.parseInt(number1.getText().toString());
                int b = Integer.parseInt(number2.getText().toString());
                int res= a*b;
                result.setText(String.valueOf(res));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a= Integer.parseInt(number1.getText().toString());
                double b = Integer.parseInt(number2.getText().toString());
                if(b!=0){
                    double res= a/b;
                    result.setText(String.valueOf(res));
                }
                else {
                    Toast.makeText(MainActivity.this, "b not be zero", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}