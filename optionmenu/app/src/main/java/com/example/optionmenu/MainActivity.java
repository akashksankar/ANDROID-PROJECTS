package com.example.optionmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Inflate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_home) {
            // Handle Home menu item
            Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show();
            // Optional: Start a new activity
            startActivity(new Intent(this, MainActivity2.class));
            return true;
        } else if (id == R.id.menu_profile) {
            // Handle Profile menu item
            Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();
            // Optional: Start a new activity
            startActivity(new Intent(this, MainActivity3.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
