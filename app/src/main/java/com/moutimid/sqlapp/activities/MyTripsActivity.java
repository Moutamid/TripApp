package com.moutimid.sqlapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.adapter.MyAdapter;
import com.moutimid.sqlapp.model.BeacModel;
import com.moutimid.sqlapp.model.DatabaseHelper;

import java.util.Collections;
import java.util.List;

public class MyTripsActivity extends AppCompatActivity implements MyAdapter.OnStartDragListener {
    private DatabaseHelper databaseHelper;
    private List<BeacModel> beacModels;
    private MyAdapter adapter;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trips);
        databaseHelper = new DatabaseHelper(MyTripsActivity.this);
        beacModels = databaseHelper.getAllBeacModels();
        updatePositions();
        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(beacModels, MyTripsActivity.this, this);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                return makeMovementFlags(dragFlags, 0);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                beacModels.get(fromPosition).id_copy = toPosition;
                beacModels.get(toPosition).id_copy = fromPosition;
                Collections.swap(beacModels, fromPosition, toPosition);
                adapter.notifyItemMoved(fromPosition, toPosition);
                adapter.notifyItemChanged(fromPosition);
                adapter.notifyItemChanged(toPosition);
                databaseHelper.updateBeacModel(beacModels.get(fromPosition)); // Implement this method in your DatabaseHelper class
                databaseHelper.updateBeacModel(beacModels.get(toPosition)); // Implement this method in your DatabaseHelper class
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }
        };

        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    private void updatePositions() {
        for (int i = 0; i < beacModels.size(); i++) {
            BeacModel model = beacModels.get(i);
            model.id_copy = i + 1;
            // Update the model in the database
            databaseHelper.updateBeacModel(model); // Assuming you have a method to update BeacModel in the database
        }
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
                if ((item.getItemId() == R.id.menu_item_1))
                {
                    startActivity(new Intent(MyTripsActivity.this, DashboardActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onStartDrag(MyAdapter.ViewHolder holder) {
        // Start dragging the item
        itemTouchHelper.startDrag(holder);
    }

    @Override
    protected void onResume() {
        super.onResume();
        databaseHelper = new DatabaseHelper(MyTripsActivity.this);
        beacModels = databaseHelper.getAllBeacModels();
        updatePositions();
        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(beacModels, MyTripsActivity.this, this);
        recyclerView.setAdapter(adapter);    }
}
