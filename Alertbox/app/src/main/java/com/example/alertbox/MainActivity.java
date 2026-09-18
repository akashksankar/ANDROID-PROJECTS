package com.example.alertbox;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.image1,
            R.drawable.image2
    };

    String[] imageNames = {
            "Image 1", "Image 2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter());

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            showAlert(imageNames[position]);
        });
    }

    private void showAlert(String imageName) {
        new AlertDialog.Builder(this)
                .setTitle("Image Selected")
                .setMessage("You selected: " + imageName)
                .setPositiveButton("OK", null)
                .show();
    }

    class ImageAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView == null) {
                imageView = (ImageView) getLayoutInflater().inflate(R.layout.grid_item, parent, false);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(images[position]);
            return imageView;
        }
    }
}
