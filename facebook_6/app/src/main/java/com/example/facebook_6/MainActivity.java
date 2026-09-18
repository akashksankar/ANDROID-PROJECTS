package com.example.facebook_6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText user, password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.emailInput);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            String username = user.getText().toString();
            String pass = password.getText().toString();

            if (username.equals("user@gmail.com") && pass.equals("user123")) {
                Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Email or password is incorrect", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
