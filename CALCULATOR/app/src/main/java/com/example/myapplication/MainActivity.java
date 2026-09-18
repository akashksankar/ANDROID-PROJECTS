package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    TextView result;
    Button btnadd,btnsub,btnmul,btndiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num1=findViewById(R.id.text1);
        num2=findViewById(R.id.text2);
        result=findViewById(R.id.Result);
        btnadd=findViewById(R.id.btn1);
        btnsub=findViewById(R.id.btn2);
        btnmul=findViewById(R.id.btn3);
        btndiv=findViewById(R.id.btn4);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());
                result.setText("Result : "+(a+b));
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());
                result.setText("Result : "+(a-b));
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());
                result.setText("Result : "+(a*b));
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());
                result.setText("Result : "+(a/b));
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}