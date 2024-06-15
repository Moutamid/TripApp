package com.moutamid.sqlapp.activities.Explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fxn.stash.Stash;
import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.activities.AppInfo.AppInfoActivity;
import com.moutamid.sqlapp.activities.ContactUs.ContactUsActivity;
import com.moutamid.sqlapp.activities.DashboardActivity;
import com.moutamid.sqlapp.activities.Iteneraries.ItinerariesActivity;
import com.moutamid.sqlapp.activities.MyTripsActivity;
import com.moutamid.sqlapp.activities.Organizer.OrganizerActivity;
import com.moutamid.sqlapp.activities.TravelTipsActivity;
import com.moutamid.sqlapp.adapter.ExploreAdapter;

public class ExploreDetailsActivity extends AppCompatActivity {
    LinearLayout more_layout;
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
        more_layout = findViewById(R.id.more_layout);
        ImageView menu = findViewById(R.id.menu);
        ImageView close = findViewById(R.id.close);
        menu.setVisibility(View.GONE);
        more_layout.setVisibility(View.VISIBLE);
        close.setVisibility(View.VISIBLE);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.setVisibility(View.VISIBLE);
                more_layout.setVisibility(View.GONE);
                close.setVisibility(View.GONE);
            }
        });
    }

    public void BackPress(View view) {
        onBackPressed();
    }

    public void explore(View view) {
        startActivity(new Intent(ExploreDetailsActivity.this, ExploreActivity.class));
    }

    public void my_trips(View view) {
        startActivity(new Intent(ExploreDetailsActivity.this, MyTripsActivity.class));
    }

    public void iternties(View view) {
        startActivity(new Intent(ExploreDetailsActivity.this, ItinerariesActivity.class));

    }

    public void organier(View view) {
        startActivity(new Intent(ExploreDetailsActivity.this, OrganizerActivity.class));
    }

    public void contact_us(View view) {
        startActivity(new Intent(ExploreDetailsActivity.this, ContactUsActivity.class));
    }


    public void tips(View view) {
        startActivity(new Intent(ExploreDetailsActivity.this, TravelTipsActivity.class));

    }

    public void about(View view) {
        startActivity(new Intent(ExploreDetailsActivity.this, AppInfoActivity.class));

    }

    public void login(View view) {
        findViewById(R.id.login_layout).setVisibility(View.VISIBLE);
    }

    public void home(View view) {
        startActivity(new Intent(ExploreDetailsActivity.this, DashboardActivity.class));

    }
}
