package com.moutimid.sqlapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

import com.moutimid.sqlapp.MainActivity;
import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.adapter.CustomListAdapter;
import com.moutimid.sqlapp.helper.DataModel;
import com.moutimid.sqlapp.helper.DatabaseHelper;

import java.util.ArrayList;

public class SavedDataActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<DataModel> dataList;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_saved_data);
        dbHelper = new DatabaseHelper(this);
        dataList = dbHelper.getAllData();

        ListView listView = findViewById(R.id.listView);
        adapter = new CustomListAdapter(this, dataList);
        listView.setAdapter(adapter);
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
                    startActivity(new Intent(SavedDataActivity.this, MainActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });

        popupMenu.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        dbHelper = new DatabaseHelper(this);
        dataList = dbHelper.getAllData();

        ListView listView = findViewById(R.id.listView);
        adapter = new CustomListAdapter(this, dataList);
        listView.setAdapter(adapter);}
}
