package com.example.onact;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {a
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("state", "onCreate");
        Toast.makeText(this,"app created",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("state", "onStart");
        Toast.makeText(this,"app started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("state", "onResume");
        Toast.makeText(this,"app resume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("state", "onPause");
        Toast.makeText(this,"app pause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("state", "onStop");
        Toast.makeText(this,"app stop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("state", "onDestroy");
        Toast.makeText(this,"app destroyed",Toast.LENGTH_SHORT).show();
    }
}
