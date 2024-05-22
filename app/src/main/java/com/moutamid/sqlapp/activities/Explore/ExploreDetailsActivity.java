package com.moutamid.sqlapp.activities.Explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fxn.stash.Stash;
import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.activities.DashboardActivity;
import com.moutamid.sqlapp.adapter.ExploreAdapter;

public class ExploreDetailsActivity extends AppCompatActivity {
    private String[] itemName;
    private int[] itemImages;
    private double[] itemLatitudes;
    private double[] itemLongitudes;
    TextView title;
    ExploreAdapter exploreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore2);
        title = findViewById(R.id.title);

        Intent intent = getIntent();
        String itemHeader = intent.getStringExtra("itemHeader");
        itemName = intent.getStringArrayExtra("itemName1");
        itemImages = intent.getIntArrayExtra("itemImages");
        itemLatitudes = intent.getDoubleArrayExtra("itemLatitudes");
        itemLongitudes = intent.getDoubleArrayExtra("itemLongitudes");
        Stash.put("type", itemHeader);

        title.setText(itemHeader);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        exploreAdapter = new ExploreAdapter(this, itemName, itemImages, itemLatitudes, itemLongitudes, itemHeader);
        recyclerView.setAdapter(exploreAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        exploreAdapter.notifyDataSetChanged();
    }

    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        // Optional: Set a listener to respond to menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1)) {
                    startActivity(new Intent(ExploreDetailsActivity.this, DashboardActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });
        popupMenu.show();
    }

    public void BackPress(View view) {
        onBackPressed();
    }
}
