package com.moutimid.sqlapp.activities.Beaches;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fxn.stash.Stash;
import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.DashboardActivity;
import com.moutimid.sqlapp.adapter.BeachesAdapter;

public class BeachesTypeActivity extends AppCompatActivity {
    private String[] itemTexts;
    private String[] itemName;
    private String[] itemName1;
    private int[] itemImages;
    TextView title, heading, text_main, heading_main;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beaches_in_east);
        title = findViewById(R.id.title);
        heading = findViewById(R.id.heading);
        text_main = findViewById(R.id.text_main);
        image = findViewById(R.id.image);
        heading_main = findViewById(R.id.heading_main);

        Intent intent = getIntent();
        String itemHeader = intent.getStringExtra("itemHeader");
        String itemTitle = intent.getStringExtra("itemTitle");
        title.setText(itemHeader);
        heading.setText(itemTitle);
        Stash.put("type", itemTitle);
        itemTexts = intent.getStringArrayExtra("itemTexts");
        itemName = intent.getStringArrayExtra("itemName");
        itemName1 = intent.getStringArrayExtra("itemName1");
        itemImages = intent.getIntArrayExtra("itemImages");
        if (itemTitle.equals("East")) {
            text_main.setText("Discover some of the island's longest and finest beaches, along with clear-water lagoons. The eastern region is ideal for activities like swimming, snorkeling, and diving. Throughout most of the year, the east coast is exposed to cooling breezes, ideal for kitesurfing.");
            heading_main.setVisibility(View.GONE);
            image.setImageResource(R.drawable.ile_aux_cerfs_island_2);
        }
        else  if (itemTitle.equals("West")) {
            text_main.setText("The western coastline is ideal for indulging in sunset cocktails at stylish beach bars, engaging in activities like snorkeling and diving to discover treasures like the Crystal Rock. The Le Morne Brabant mountain graces the horizon, and the area is renowned as a premier kitesurfing hotspot. Moreover, there is an increased likelihood of encountering wild dolphin pods off the west coast.");
            heading_main.setVisibility(View.GONE);
            image.setImageResource(R.drawable.le_morne_brabant);
        } else  if (itemTitle.equals("South")) {
            text_main.setText("The southern region has a rugged shoreline characterized by steep cliffs, hidden coves, and roughsea. While the sandy areas are wide, swimmers should exercise caution when venturing into the sea because of the strong currents and presence of coral reefs.");
            heading_main.setVisibility(View.GONE);
            image.setImageResource(R.drawable.gris_gris_4);
        } else  if (itemTitle.equals("North")) {
            text_main.setText("The northern region is renowned for its lively atmosphere, great bars and restaurants, and beaches with scenic views of the northern islands. It's an ideal starting point for boat or catamaran trips to explore the islets like Ilot Gabriel. The area features flat, sandy beaches, abundant watersports, and calm waters, making it a perfect destination for relaxation and aquatic activities.");
            heading_main.setVisibility(View.GONE);
            image.setImageResource(R.drawable.coin_de_mire_10);
        }
        ListView listView = findViewById(R.id.listView);
        BeachesAdapter adapter = new BeachesAdapter(this, itemName, itemName1, itemTexts, itemImages);
        listView.setAdapter(adapter);
    }

    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        // Optional: Set a listener to respond to menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1)) {
                    startActivity(new Intent(BeachesTypeActivity.this, DashboardActivity.class));
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
        ListView listView = findViewById(R.id.listView);
        BeachesAdapter adapter = new BeachesAdapter(this, itemName, itemName1, itemTexts, itemImages);
        listView.setAdapter(adapter);
    }

    public void BackPress(View view) {
        onBackPressed();
    }


}