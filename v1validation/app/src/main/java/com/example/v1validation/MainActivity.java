package com.example.v1alidation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Best Practice: Define views globally so you don't keep calling findViewById repeatedly
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views once in onCreate
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });
    }

    private void validateFields() {
        // 1. Empty Field Validation
        String name = editTextName.getText().toString().trim();
        if (name.isEmpty()) {
            editTextName.setError("Name cannot be empty");
            editTextName.requestFocus(); // Moves cursor to the error field
            return;
        }

        // 2. Email Format Validation
        String email = editTextEmail.getText().toString().trim();
        if (email.isEmpty()) {
            editTextEmail.setError("Email cannot be empty");
            editTextEmail.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Invalid email format");
            editTextEmail.requestFocus();
            return;
        }

        // 3. Password Length Validation
        String password = editTextPassword.getText().toString().trim();
        int minLength = 6;
        if (password.length() < minLength) {
            // Fixed: Combined the broken string back onto a single line
            editTextPassword.setError("Password must be at least " + minLength + " characters long");
            editTextPassword.requestFocus();
            return;
        }

        // Success message
        Toast.makeText(this, "Valid inputs", Toast.LENGTH_SHORT).show();
    }
}
