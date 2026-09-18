package com.example.validvalid; // Matches your project name 'validvalid'

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button submitButton = findViewById(R.id.submitButton);


        submitButton.setOnClickListener(v -> validateFields());
    }

    private void validateFields() {

        String name = editTextName.getText().toString().trim();
        if (name.isEmpty()) {
            editTextName.setError("Name cannot be empty");
            editTextName.requestFocus();
            return;
        }


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


        String password = editTextPassword.getText().toString().trim();
        int minLength = 8;
        if (password.length() < minLength) {
            editTextPassword.setError("Password must be at least " + minLength + " characters long");
            editTextPassword.requestFocus();
            return;
        }


        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
    }
}
