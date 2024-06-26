package com.moutamid.sqlapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moutamid.sqlapp.MainActivity;
import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.helper.DatabaseHelper;

public class SavedDetailsActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    String name, address, details;
    int imageResource;
    ImageView add, delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        dbHelper = new DatabaseHelper(this);
        Intent intent = getIntent();
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);


        if (intent != null) {
            name = intent.getStringExtra("name");
            address = intent.getStringExtra("address");
            details = intent.getStringExtra("details");
            imageResource = intent.getIntExtra("image", 0);

            TextView textView = findViewById(R.id.text);
            TextView title = findViewById(R.id.title);
            ImageView imageView = findViewById(R.id.img);

            textView.setText(details);
            title.setText(name);
            imageView.setImageResource(imageResource);
        }
        if (!dbHelper.checkDataExists(name, address, details, imageResource)) {
            add.setVisibility(View.VISIBLE);
            delete.setVisibility(View.GONE);
        } else {
            add.setVisibility(View.GONE);
            delete.setVisibility(View.VISIBLE);
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add data to the database
                dbHelper.insertData(name, address, details, imageResource);
                add.setVisibility(View.GONE);
                delete.setVisibility(View.VISIBLE);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete data from the database
                dbHelper.deleteData(name, address, details, imageResource);
                add.setVisibility(View.VISIBLE);
                delete.setVisibility(View.GONE);
//                finish();
            }
        });
    }
    public void BackPress(View view) {
        onBackPressed();
    }

    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        // Optional: Set a listener to respond to menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1)) {
                    startActivity(new Intent(SavedDetailsActivity.this, MainActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });

        popupMenu.show();

    }

}