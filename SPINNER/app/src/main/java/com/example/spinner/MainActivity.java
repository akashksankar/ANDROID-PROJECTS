package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner animalspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        animalspinner = findViewById(R.id.animalspinner);
        String[] animals={"select an animal","Elephant","Gorilla","Lion","Tiger","Deer","Bear","Rhino","Hippo"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                animals
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animalspinner.setAdapter(adapter);
        animalspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position !=0){

                    String selectedAnimal=parent.getItemAtPosition(position).toString();
                    Toast.makeText(MainActivity.this, "Selected: " + selectedAnimal, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    Toast.makeText(MainActivity.this, "No selection made", Toast.LENGTH_SHORT).show();

            }
        });

    }
}