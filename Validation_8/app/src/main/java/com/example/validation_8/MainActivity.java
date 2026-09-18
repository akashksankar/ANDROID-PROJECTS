package com.example.validation_8;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText Name, Email, Mobile, Dob, Password, ConfirmPassword;
    RadioGroup Gender;
    Spinner spinnerState,spinnerDistrict;
    CheckBox Reading, Traveling, Gaming;
    Button btnSubmit;

    String[] states = {"Select State", "Maharashtra", "Gujarat", "Karnataka","kerala"};
    String[] district={"select district","malappuram","palakkad","alappuzha","kozhikode"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etName);
        Email = findViewById(R.id.etEmail);
        Mobile = findViewById(R.id.etMobile);
        Dob = findViewById(R.id.etDob);
        Password = findViewById(R.id.etPassword);
        ConfirmPassword = findViewById(R.id.etConfirmPassword);
        Gender = findViewById(R.id.rgGender);
        spinnerState = findViewById(R.id.spinnerState);
        spinnerDistrict = findViewById(R.id.districts);
        Reading = findViewById(R.id.cbReading);
        Traveling = findViewById(R.id.cbTraveling);
        Gaming = findViewById(R.id.cbGaming);
        btnSubmit = findViewById(R.id.btnSubmit);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,district);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistrict.setAdapter(adapter1);

        Dob.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DAY_OF_MONTH);

            new DatePickerDialog(MainActivity.this, (view1, year, month, dayOfMonth) -> {
                Dob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }, y, m, d).show();
        });

        btnSubmit.setOnClickListener(view -> validateForm());
    }

    private void validateForm() {
        String name = Name.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String mobile = Mobile.getText().toString().trim();
        String dob = Dob.getText().toString().trim();
        String password = Password.getText().toString();
        String confirmPassword = ConfirmPassword.getText().toString();

        if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
            Name.setError("Enter a valid name");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Enter a valid email");
            return;
        }

        if (Gender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Select gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mobile.length() != 10 || !TextUtils.isDigitsOnly(mobile)) {
            Mobile.setError("Enter valid 10-digit mobile number");
            return;
        }

        if (dob.isEmpty()) {
            Dob.setError("Select date of birth");
            return;
        }

        if (password.length() < 8) {
            Password.setError("Password must be at least 6 characters");
            return;
        }

        if (confirmPassword.isEmpty() || !password.equals(confirmPassword)) {
            ConfirmPassword.setError("Passwords do not match");
            return;
        }

        if (spinnerState.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "Select a state", Toast.LENGTH_SHORT).show();
            return;
        }
        if(spinnerDistrict.getSelectedItemPosition() == 0){
            Toast.makeText(this, "select a district", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Reading.isChecked() && !Traveling.isChecked() && !Gaming.isChecked()) {
            Toast.makeText(this, "Select at least one hobby", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Validation Successful!", Toast.LENGTH_LONG).show();
    }
}
