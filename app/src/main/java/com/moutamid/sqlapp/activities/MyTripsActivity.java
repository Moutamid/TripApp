package com.moutamid.sqlapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.adapter.MyAdapter;
import com.moutamid.sqlapp.model.BeacModel;
import com.moutamid.sqlapp.model.DatabaseHelper;
import com.moutamid.sqlapp.offlinemap.FullMapActivity;

import java.util.Collections;
import java.util.List;

public class MyTripsActivity extends AppCompatActivity implements MyAdapter.OnStartDragListener {
    private DatabaseHelper databaseHelper;
    private List<BeacModel> beacModels;
    private MyAdapter adapter;
    private ItemTouchHelper itemTouchHelper;
    public static TextView time, distance, total_stop;
    Button map_it_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trips);
        databaseHelper = new DatabaseHelper(MyTripsActivity.this);
        beacModels = databaseHelper.getAllBeacModels();
        updatePositions();
        RecyclerView recyclerView = findViewById(R.id.listView);
        time = findViewById(R.id.time);
        distance = findViewById(R.id.distance);
        total_stop = findViewById(R.id.total_stop);
        map_it_btn = findViewById(R.id.map_it_btn);
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

        map_it_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passLatLngListToNextActivity();
            }
        });
    }
    private void passLatLngListToNextActivity() {
        Intent intent = new Intent(MyTripsActivity.this, FullMapActivity.class); // Change NextActivity to your target activity

        double[] latitudes = new double[beacModels.size()];
        double[] longitudes = new double[beacModels.size()];

        for (int i = 0; i < beacModels.size(); i++) {
            latitudes[i] = beacModels.get(i).lat;
            longitudes[i] = beacModels.get(i).lng;
        }

        intent.putExtra("latitudes", latitudes);
        intent.putExtra("longitudes", longitudes);
        startActivity(intent);
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
