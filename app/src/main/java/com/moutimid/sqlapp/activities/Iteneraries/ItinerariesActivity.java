package com.moutimid.sqlapp.activities.Iteneraries;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fxn.stash.Stash;
import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.DashboardActivity;
import com.moutimid.sqlapp.activities.MyTripsActivity;
import com.moutimid.sqlapp.adapter.ItenerariesAdapter;

public class ItinerariesActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int BUTTON_DAY_1 = 1;
    private static final int BUTTON_DAY_2 = 2;
    private static final int BUTTON_DAY_3 = 3;
    private static final int BUTTON_DAY_4 = 4;
    private static final int BUTTON_DAY_5 = 5;
    private static int BUTTON_DAY = 1;


    TextView buttonDay1, buttonDay2, buttonDay3, buttonDay4, buttonDay5;
    View view1, view2, view3, view4, view5;
    TextView pressButtonDay1, pressButtonDay2, pressButtonDay3, pressButtonDay4, pressButtonDay5;
    View pressView1, pressView2, pressView3, pressView4, pressView5;

    private TextView subbuttonDay1, subbuttonDay2, subbuttonDay3, subbuttonDay4, subbuttonDay5;
    private View subview1, subview2, subview3, subview4, subview5;
    private TextView subpressbuttonDay1, subpressbuttonDay2, subpressbuttonDay3, subpressbuttonDay4, subpressbuttonDay5;
    private View subpressview1, subpressview2, subpressview3, subpressview4, subpressview5;
    RelativeLayout tab_layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itineraries);

        buttonDay1 = findViewById(R.id.buttonDay1);
        buttonDay2 = findViewById(R.id.buttonDay2);
        buttonDay3 = findViewById(R.id.buttonDay3);
        buttonDay4 = findViewById(R.id.buttonDay4);
        buttonDay5 = findViewById(R.id.buttonDay5);

        pressButtonDay1 = findViewById(R.id.pressbuttonDay1);
        pressButtonDay2 = findViewById(R.id.pressbuttonDay2);
        pressButtonDay3 = findViewById(R.id.pressbuttonDay3);
        pressButtonDay4 = findViewById(R.id.pressbuttonDay4);
        pressButtonDay5 = findViewById(R.id.pressbuttonDay5);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view5 = findViewById(R.id.view5);

        pressView1 = findViewById(R.id.pressview1);
        pressView2 = findViewById(R.id.pressview2);
        pressView3 = findViewById(R.id.pressview3);
        pressView4 = findViewById(R.id.pressview4);
        pressView5 = findViewById(R.id.pressview5);

        subbuttonDay1 = findViewById(R.id.subbuttonDay1);
        subbuttonDay2 = findViewById(R.id.subbuttonDay2);
        subbuttonDay3 = findViewById(R.id.subbuttonDay3);
        subbuttonDay4 = findViewById(R.id.subbuttonDay4);
        subbuttonDay5 = findViewById(R.id.subbuttonDay5);

        subview1 = findViewById(R.id.subview1);
        subview2 = findViewById(R.id.subview2);
        subview3 = findViewById(R.id.subview3);
        subview4 = findViewById(R.id.subview4);
        subview5 = findViewById(R.id.subview5);

        subpressbuttonDay1 = findViewById(R.id.subpressbuttonDay1);
        subpressbuttonDay2 = findViewById(R.id.subpressbuttonDay2);
        subpressbuttonDay3 = findViewById(R.id.subpressbuttonDay3);
        subpressbuttonDay4 = findViewById(R.id.subpressbuttonDay4);
        subpressbuttonDay5 = findViewById(R.id.subpressbuttonDay5);

        subpressview1 = findViewById(R.id.subpressview1);
        subpressview2 = findViewById(R.id.subpressview2);
        subpressview3 = findViewById(R.id.subpressview3);
        subpressview4 = findViewById(R.id.subpressview4);
        subpressview5 = findViewById(R.id.subpressview5);
        tab_layout2 = findViewById(R.id.tab_layout2);

        // Set click listeners for all buttons
        subbuttonDay1.setOnClickListener(this);
        subbuttonDay2.setOnClickListener(this);
        subbuttonDay3.setOnClickListener(this);
        subbuttonDay4.setOnClickListener(this);
        subbuttonDay5.setOnClickListener(this);

        subpressbuttonDay1.setOnClickListener(this);
        subpressbuttonDay2.setOnClickListener(this);
        subpressbuttonDay3.setOnClickListener(this);
        subpressbuttonDay4.setOnClickListener(this);
        subpressbuttonDay5.setOnClickListener(this);

        buttonDay1.setOnClickListener(this);
        buttonDay2.setOnClickListener(this);
        buttonDay3.setOnClickListener(this);
        buttonDay4.setOnClickListener(this);
        buttonDay5.setOnClickListener(this);

        pressButtonDay1.setOnClickListener(this);
        pressButtonDay2.setOnClickListener(this);
        pressButtonDay3.setOnClickListener(this);
        pressButtonDay4.setOnClickListener(this);
        pressButtonDay5.setOnClickListener(this);

        // Initialize views
        resetButtons();
        tab_layout2.setVisibility(View.GONE);
        buttonDay1.setVisibility(View.INVISIBLE);
        view1.setVisibility(View.INVISIBLE);
        pressButtonDay1.setVisibility(View.VISIBLE);
        pressView1.setVisibility(View.VISIBLE);
        // Initialize list view
        String[] itemTexts = {"Le Caudan Waterfront", "Aapravasi Ghat", "Port Louis Central Market", "Marie Reine de la Paix Chapel", "Fort Adelaide", "Le Morne Beach", "Le Morne Brabant", "Maconde Viewpoint", "Chamarel Seven Coloured Earth", "Chamarel Waterfalls", "Black River Gorges", "Grand Bassin", "Gris Gris Beach"};
        String[] itemName = {"Admission Free", "Admission Entrance Fee", "Admission Free", "Admission Free", "Admission Free", "Admission Free", "Admission Free", "Admission Free", "Admission Free", "Admission Entrance Fee", "Chamarel", "Admission Free", "Admission Free"};
        String[] itemName1 = {"South • 30 minutes - 1 hour", "North • 1 hour", "North • 1 hour", "North • 45 minutes", "North • 1 hour", "Southwest • 1 hour", "Southwest • 3 - 4 hours", "Southwest • 30 minutes", "Southwest • 1 hour 30 minutes", "Southwest • 1 hour 30 minutes", "Southwest • 1 hour 30 minutes", "South • 1 hour 30 minutes", "South • 30 minutes - 1 hour"};
        int[] itemImages = {R.drawable.port_louis_3, R.drawable.aapravasi_ghat_1, R.drawable.port_louis_4, R.drawable.marie_reine_de_la_paix_3, R.drawable.citadelle, R.drawable.le_morne_beach_2, R.drawable.le_morne_1, R.drawable.maconde_1, R.drawable.chamarel_2, R.drawable.chamarel_1, R.drawable.black_river_georges_2, R.drawable.grand_bassin_1, R.drawable.gris_gris_coastal_4};
        ListView listView = findViewById(R.id.listView);
        ItenerariesAdapter adapter = new ItenerariesAdapter(ItinerariesActivity.this, itemTexts, itemName, itemName1, itemImages);
        listView.setAdapter(adapter);
    }

    public void BackPress(View view) {
        onBackPressed();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Handle normal buttons and views
        if (id == R.id.buttonDay1 || id == R.id.buttonDay2 || id == R.id.buttonDay3 || id == R.id.buttonDay4 || id == R.id.buttonDay5) {
            resetButtons(); // Reset all normal buttons and views
            toggleButtonsVisibility(id); // Toggle visibility for the clicked button and view
        } else if (id == R.id.pressbuttonDay1 || id == R.id.pressbuttonDay2 || id == R.id.pressbuttonDay3 || id == R.id.pressbuttonDay4 || id == R.id.pressbuttonDay5) {
            toggleButtonsVisibility(id); // Toggle visibility for the clicked button and view
        }

        // Handle sub buttons and views
        if (id == R.id.subbuttonDay1 || id == R.id.subbuttonDay2 || id == R.id.subbuttonDay3 || id == R.id.subbuttonDay4 || id == R.id.subbuttonDay5) {
            subresetButtons(); // Reset all sub buttons and views
            toggleSubButtonsVisibility(id); // Toggle visibility for the clicked sub button and view
        } else if (id == R.id.subpressbuttonDay1 || id == R.id.subpressbuttonDay2 || id == R.id.subpressbuttonDay3 || id == R.id.subpressbuttonDay4 || id == R.id.subpressbuttonDay5) {
            toggleSubButtonsVisibility(id); // Toggle visibility for the clicked sub button and view
        }
    }

    // Toggle visibility for normal buttons and views
    private void toggleButtonsVisibility(int buttonId) {
        if (buttonId == R.id.buttonDay1) {
            buttonDay1.setVisibility(View.INVISIBLE);
            view1.setVisibility(View.INVISIBLE);
            pressButtonDay1.setVisibility(View.VISIBLE);
            pressView1.setVisibility(View.VISIBLE);
            showSubButtons(1);
            tab_layout2.setVisibility(View.GONE);
            handle_sub_visibility(0, 0);

        } else if (buttonId == R.id.buttonDay2) {
            buttonDay2.setVisibility(View.INVISIBLE);
            view2.setVisibility(View.INVISIBLE);
            pressButtonDay2.setVisibility(View.VISIBLE);
            pressView2.setVisibility(View.VISIBLE);
            showSubButtons(2);
            tab_layout2.setVisibility(View.VISIBLE);
            handle_sub_visibility(2, 1);



        } else if (buttonId == R.id.buttonDay3) {
            buttonDay3.setVisibility(View.INVISIBLE);
            view3.setVisibility(View.INVISIBLE);
            pressButtonDay3.setVisibility(View.VISIBLE);
            pressView3.setVisibility(View.VISIBLE);
            showSubButtons(3);
            tab_layout2.setVisibility(View.VISIBLE);
            handle_sub_visibility(3, 1);


        } else if (buttonId == R.id.buttonDay4) {
            buttonDay4.setVisibility(View.INVISIBLE);
            view4.setVisibility(View.INVISIBLE);
            pressButtonDay4.setVisibility(View.VISIBLE);
            pressView4.setVisibility(View.VISIBLE);
            showSubButtons(4);
            tab_layout2.setVisibility(View.VISIBLE);
            handle_sub_visibility(4, 1);


        } else if (buttonId == R.id.buttonDay5) {
            buttonDay5.setVisibility(View.INVISIBLE);
            view5.setVisibility(View.INVISIBLE);
            pressButtonDay5.setVisibility(View.VISIBLE);
            pressView5.setVisibility(View.VISIBLE);
            showSubButtons(5);
            tab_layout2.setVisibility(View.VISIBLE);
            handle_sub_visibility(5, 1);


        }
    }

    // Reset all normal buttons and views
    private void resetButtons() {
        buttonDay1.setVisibility(View.VISIBLE);
        view1.setVisibility(View.VISIBLE);
        pressButtonDay1.setVisibility(View.INVISIBLE);
        pressView1.setVisibility(View.INVISIBLE);

        buttonDay2.setVisibility(View.VISIBLE);
        view2.setVisibility(View.VISIBLE);
        pressButtonDay2.setVisibility(View.INVISIBLE);
        pressView2.setVisibility(View.INVISIBLE);

        buttonDay3.setVisibility(View.VISIBLE);
        view3.setVisibility(View.VISIBLE);
        pressButtonDay3.setVisibility(View.INVISIBLE);
        pressView3.setVisibility(View.INVISIBLE);

        buttonDay4.setVisibility(View.VISIBLE);
        view4.setVisibility(View.VISIBLE);
        pressButtonDay4.setVisibility(View.INVISIBLE);
        pressView4.setVisibility(View.INVISIBLE);

        buttonDay5.setVisibility(View.VISIBLE);
        view5.setVisibility(View.VISIBLE);
        pressButtonDay5.setVisibility(View.INVISIBLE);
        pressView5.setVisibility(View.INVISIBLE);
    }

    // Toggle visibility for sub buttons and views
    private void toggleSubButtonsVisibility(int id) {

        if (id == R.id.subbuttonDay1) {
            handle_sub_visibility(BUTTON_DAY, 1);

        } else if (id == R.id.subbuttonDay2) {
            handle_sub_visibility(BUTTON_DAY, 2);

        } else if (id == R.id.subbuttonDay3) {
            handle_sub_visibility(BUTTON_DAY, 3);

        } else if (id == R.id.subbuttonDay4) {

            handle_sub_visibility(BUTTON_DAY, 4);


        } else if (id == R.id.subbuttonDay5) {
            handle_sub_visibility(BUTTON_DAY, 5);

        }
    }

    // Reset all sub buttons and views
    private void subresetButtons() {
        subbuttonDay1.setVisibility(View.VISIBLE);
        subbuttonDay2.setVisibility(View.VISIBLE);
        subbuttonDay3.setVisibility(View.VISIBLE);
        subbuttonDay4.setVisibility(View.VISIBLE);
        subbuttonDay5.setVisibility(View.VISIBLE);

        subview1.setVisibility(View.VISIBLE);
        subview2.setVisibility(View.VISIBLE);
        subview3.setVisibility(View.VISIBLE);
        subview4.setVisibility(View.VISIBLE);
        subview5.setVisibility(View.VISIBLE);

        subpressbuttonDay1.setVisibility(View.INVISIBLE);
        subpressbuttonDay2.setVisibility(View.INVISIBLE);
        subpressbuttonDay3.setVisibility(View.INVISIBLE);
        subpressbuttonDay4.setVisibility(View.INVISIBLE);
        subpressbuttonDay5.setVisibility(View.INVISIBLE);

        subpressview1.setVisibility(View.INVISIBLE);
        subpressview2.setVisibility(View.INVISIBLE);
        subpressview3.setVisibility(View.INVISIBLE);
        subpressview4.setVisibility(View.INVISIBLE);
        subpressview5.setVisibility(View.INVISIBLE);
    }

    private void showSubButtons(int day) {
        // Show sub buttons based on the selected day
        switch (day) {
            case BUTTON_DAY_1:

            case BUTTON_DAY_2:
                BUTTON_DAY = 2;
                subbuttonDay1.setVisibility(View.INVISIBLE);
                subview1.setVisibility(View.INVISIBLE);
                subbuttonDay2.setVisibility(View.VISIBLE);
                subview2.setVisibility(View.VISIBLE);
                subbuttonDay3.setVisibility(View.GONE);
                subview3.setVisibility(View.GONE);
                subbuttonDay4.setVisibility(View.GONE);
                subview4.setVisibility(View.GONE);
                subbuttonDay5.setVisibility(View.GONE);
                subview5.setVisibility(View.GONE);

                subpressbuttonDay1.setVisibility(View.VISIBLE);
                subpressview1.setVisibility(View.VISIBLE);
                subpressbuttonDay2.setVisibility(View.INVISIBLE);
                subpressview2.setVisibility(View.INVISIBLE);
                subpressbuttonDay3.setVisibility(View.GONE);
                subpressview3.setVisibility(View.GONE);
                subpressbuttonDay4.setVisibility(View.GONE);
                subpressview4.setVisibility(View.GONE);
                subpressbuttonDay5.setVisibility(View.GONE);
                subpressview5.setVisibility(View.GONE);
                break;
            case BUTTON_DAY_3:
                BUTTON_DAY = 3;

                subbuttonDay1.setVisibility(View.INVISIBLE);
                subview1.setVisibility(View.INVISIBLE);
                subbuttonDay2.setVisibility(View.VISIBLE);
                subview2.setVisibility(View.VISIBLE);
                subbuttonDay3.setVisibility(View.VISIBLE);
                subview3.setVisibility(View.VISIBLE);
                subbuttonDay4.setVisibility(View.GONE);
                subview4.setVisibility(View.GONE);
                subbuttonDay5.setVisibility(View.GONE);
                subview5.setVisibility(View.GONE);

                subpressbuttonDay1.setVisibility(View.VISIBLE);
                subpressview1.setVisibility(View.VISIBLE);
                subpressbuttonDay2.setVisibility(View.INVISIBLE);
                subpressview2.setVisibility(View.INVISIBLE);
                subpressbuttonDay3.setVisibility(View.INVISIBLE);
                subpressview3.setVisibility(View.INVISIBLE);
                subpressbuttonDay4.setVisibility(View.GONE);
                subpressview4.setVisibility(View.GONE);
                subpressbuttonDay5.setVisibility(View.GONE);
                subpressview5.setVisibility(View.GONE);
                break;
            case BUTTON_DAY_4:
                BUTTON_DAY = 4;

                subbuttonDay1.setVisibility(View.INVISIBLE);
                subview1.setVisibility(View.INVISIBLE);
                subbuttonDay2.setVisibility(View.VISIBLE);
                subview2.setVisibility(View.VISIBLE);
                subbuttonDay3.setVisibility(View.VISIBLE);
                subview3.setVisibility(View.VISIBLE);
                subbuttonDay4.setVisibility(View.VISIBLE);
                subview4.setVisibility(View.VISIBLE);
                subbuttonDay5.setVisibility(View.GONE);
                subview5.setVisibility(View.GONE);

                subpressbuttonDay1.setVisibility(View.VISIBLE);
                subpressview1.setVisibility(View.VISIBLE);
                subpressbuttonDay2.setVisibility(View.INVISIBLE);
                subpressview2.setVisibility(View.INVISIBLE);
                subpressbuttonDay3.setVisibility(View.INVISIBLE);
                subpressview3.setVisibility(View.INVISIBLE);
                subpressbuttonDay4.setVisibility(View.INVISIBLE);
                subpressview4.setVisibility(View.INVISIBLE);
                subpressbuttonDay5.setVisibility(View.GONE);
                subpressview5.setVisibility(View.GONE);
                break;
            case BUTTON_DAY_5:
                BUTTON_DAY = 5;

                subbuttonDay1.setVisibility(View.INVISIBLE);
                subview1.setVisibility(View.INVISIBLE);
                subbuttonDay2.setVisibility(View.VISIBLE);
                subview2.setVisibility(View.VISIBLE);
                subbuttonDay3.setVisibility(View.VISIBLE);
                subview3.setVisibility(View.VISIBLE);
                subbuttonDay4.setVisibility(View.VISIBLE);
                subview4.setVisibility(View.VISIBLE);
                subbuttonDay5.setVisibility(View.VISIBLE);
                subview5.setVisibility(View.VISIBLE);

                subpressbuttonDay1.setVisibility(View.VISIBLE);
                subpressview1.setVisibility(View.VISIBLE);
                subpressbuttonDay2.setVisibility(View.INVISIBLE);
                subpressview2.setVisibility(View.INVISIBLE);
                subpressbuttonDay3.setVisibility(View.INVISIBLE);
                subpressview3.setVisibility(View.INVISIBLE);
                subpressbuttonDay4.setVisibility(View.INVISIBLE);
                subpressview4.setVisibility(View.INVISIBLE);
                subpressbuttonDay5.setVisibility(View.INVISIBLE);
                subpressview5.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void handle_sub_visibility(int main_day, int sub_day) {
        String[] itemTexts = new String[0];
        String[] itemName1 = new String[0];
        String[] itemName = new String[0];
        int[] itemImages = new int[0];
        if (main_day == 0 && sub_day == 0) {
            Stash.put("day", "day1");
            tab_layout2.setVisibility(View.GONE);
            itemTexts = new String[]{"Le Caudan Waterfront", "Aapravasi Ghat", "Port Louis Central Market", "Marie Reine de la Paix Chapel", "Fort Adelaide", "Le Morne Beach", "Le Morne Brabant", "Maconde Viewpoint", "Chamarel Seven Coloured Earth", "Chamarel Waterfalls", "Black River Gorges", "Grand Bassin", "Gris Gris Beach"};
            itemName = new String[]{"Admission Free", "Admission Entrance Fee", "Admission Free", "Admission Free", "Admission Free", "Admission Free", "Admission Free", "Admission Free", "Admission Free", "Admission Entrance Fee", "Chamarel", "Admission Free", "Admission Free"};
            itemName1 = new String[]{"South • 30 minutes - 1 hour", "North • 1 hour", "North • 1 hour", "North • 45 minutes", "North • 1 hour", "Southwest • 1 hour", "Southwest • 3 - 4 hours", "Southwest • 30 minutes", "Southwest • 1 hour 30 minutes", "Southwest • 1 hour 30 minutes", "Southwest • 1 hour 30 minutes", "South • 1 hour 30 minutes", "South • 30 minutes - 1 hour"};
            itemImages = new int[]{R.drawable.port_louis_3, R.drawable.aapravasi_ghat_1, R.drawable.port_louis_4, R.drawable.marie_reine_de_la_paix_3, R.drawable.citadelle, R.drawable.le_morne_beach_2, R.drawable.le_morne_1, R.drawable.maconde_1, R.drawable.chamarel_2, R.drawable.chamarel_1, R.drawable.black_river_georges_2, R.drawable.grand_bassin_1, R.drawable.gris_gris_1};

        }
        if (main_day == 2 && sub_day == 1) {
            Stash.put("day", "day21");

            tab_layout2.setVisibility(View.VISIBLE);
            subbuttonDay1.setVisibility(View.INVISIBLE);
            subview1.setVisibility(View.INVISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.GONE);
            subview3.setVisibility(View.GONE);
            subbuttonDay4.setVisibility(View.GONE);
            subview4.setVisibility(View.GONE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);

            subpressbuttonDay1.setVisibility(View.VISIBLE);
            subpressview1.setVisibility(View.VISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.GONE);
            subpressview3.setVisibility(View.GONE);
            subpressbuttonDay4.setVisibility(View.GONE);
            subpressview4.setVisibility(View.GONE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"SSR Botanical Garden", "L’Aventure du Sucre", "LeCaudan Waterfront", "Aapravasi Ghat", "Blue Penny Museum", "Black River Gorges", "Chamarel Seven Coloured Earth"};
            itemName = new String[]{"Admission Entrance Fee", "Admission Entrance Fee", "Admission Free", "Admission Entrance Fee", "Admission Entrance Fee", "Admission Free", "Admission Entrance Fee"};
            itemName1 = new String[]{"North • 2 hours", "North • 2 hours", "North • 2 hours", "North • 1 hours", "North • 1 hour", "Southwest • 30 minutes", "Southwest • 1 hour 30 minutes"};
            itemImages = new int[]{R.drawable.pamplemousse_garden, R.drawable.sugar_museum_pamplemousses, R.drawable.port_louis_3, R.drawable.aapravasi_ghat_1, R.drawable.blue_penny_museum_2, R.drawable.black_river_georges_2, R.drawable.chamarel_2};

        }
        if (main_day == 2 && sub_day == 2) {
            Stash.put("day", "day22");

            tab_layout2.setVisibility(View.VISIBLE);
            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.INVISIBLE);
            subview2.setVisibility(View.INVISIBLE);
            subbuttonDay3.setVisibility(View.GONE);
            subview3.setVisibility(View.GONE);
            subbuttonDay4.setVisibility(View.GONE);
            subview4.setVisibility(View.GONE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.VISIBLE);
            subpressview2.setVisibility(View.VISIBLE);
            subpressbuttonDay3.setVisibility(View.GONE);
            subpressview3.setVisibility(View.GONE);
            subpressbuttonDay4.setVisibility(View.GONE);
            subpressview4.setVisibility(View.GONE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"Trou aux Cerfs", "Grand Bassin", "Bois Cheri Tea Museum", "La Vanille Nature Park", "Gris Gris Beach"};
            itemName = new String[]{"Admission Fee", "Admission Fee", "Admission Entrance Free", "Admission Entrance Fee", "Admission Fee"};
            itemName1 = new String[]{"Center • 40 minutes", "Center • 1 hour", "South • 3 hours", "South • 4 hours", "South • 1 hour"};
            itemImages = new int[]{R.drawable.trou_aux_cerfs_4, R.drawable.grand_bassin_1, R.drawable.bois_cheri_1, R.drawable.la_vanilla_1, R.drawable.gris_gris_1};

        }
        if (main_day == 3 && sub_day == 1) {
            Stash.put("day", "day31");

            tab_layout2.setVisibility(View.VISIBLE);
            subbuttonDay1.setVisibility(View.INVISIBLE);
            subview1.setVisibility(View.INVISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.GONE);
            subview4.setVisibility(View.GONE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);
            subpressbuttonDay1.setVisibility(View.VISIBLE);
            subpressview1.setVisibility(View.VISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.GONE);
            subpressview4.setVisibility(View.GONE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"SSR Botanical Garden", "L’Aventure du Sucre", "Chateau de Labourdonnais", "Le Caudan Waterfront", "Aapravasi Ghat", "Blue Penny Museum"};
            itemName1 = new String[]{"North • 2 hours", "North • 2 hours", "North • 2 hours", "North • 2 hours", "North • 1 hour", "North • 1 hour"};
            itemImages = new int[]{R.drawable.pamplemousse_garden, R.drawable.sugar_museum_pamplemousses, R.drawable.chateau_de_labourdonnais, R.drawable.port_louis_3, R.drawable.aapravasi_ghat_1, R.drawable.blue_penny_museum_2};
            itemName = new String[]{"Admission Entrance Fee", "Admission Entrance Fee", "Admission Entrance Free", "Admission Fee", "Admission Entrance Fee", "Admission Entrance Free"};

        }
        if (main_day == 3 && sub_day == 2) {
            Stash.put("day", "day32");

            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.INVISIBLE);
            subview2.setVisibility(View.INVISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.GONE);
            subview4.setVisibility(View.GONE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.VISIBLE);
            subpressview2.setVisibility(View.VISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.GONE);
            subpressview4.setVisibility(View.GONE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"Bois Cheri Tea Museum", "La Vanille Nature Park ", "Gris Gris Beach"};
            itemName = new String[]{"Admission Entrance Fee", "Admission Entrance Fee", "Admission Free"};
            itemName1 = new String[]{"South • 3 hours", "South • 4 hour", "South • 1 hour"};
            itemImages = new int[]{R.drawable.bois_cheri_1, R.drawable.la_vanilla_1, R.drawable.gris_gris_1};
        }
        if (main_day == 3 && sub_day == 3) {
            Stash.put("day", "day33");

            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.INVISIBLE);
            subview3.setVisibility(View.INVISIBLE);
            subbuttonDay4.setVisibility(View.GONE);
            subview4.setVisibility(View.GONE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.VISIBLE);
            subpressview3.setVisibility(View.VISIBLE);
            subpressbuttonDay4.setVisibility(View.GONE);
            subpressview4.setVisibility(View.GONE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"Tamarin Bay", "Trou aux Cerfs", "Grand Bassin", "Black River Gorges", "Chamarel Seven Coloured Earth"};
            itemName = new String[]{"Admission Fee", "Admission Fee", "Admission Free", "Admission Fee", "Admission Entrance Fee"};
            itemName1 = new String[]{"West • 1 hour", "Center •1 hour 30 minutes", "South • 1 hour 30 minutes", "Southwest • 1 hour", "Southwest • 1 hour"};
            itemImages = new int[]{R.drawable.tamarin_3, R.drawable.trou_aux_cerfs_4, R.drawable.grand_bassin_1, R.drawable.black_river_georges_2, R.drawable.chamarel_2};
        }
        if (main_day == 4 && sub_day == 1) {
            Stash.put("day", "day41");

            subbuttonDay1.setVisibility(View.INVISIBLE);
            subview1.setVisibility(View.INVISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.VISIBLE);
            subview4.setVisibility(View.VISIBLE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);
            subpressbuttonDay1.setVisibility(View.VISIBLE);
            subpressview1.setVisibility(View.VISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.INVISIBLE);
            subpressview4.setVisibility(View.INVISIBLE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"SSR Botanical Garden", "L’Aventure du Sucre", "Chateau de Labourdonnais", "Le Caudan Waterfront", "Aapravasi Ghat", "Blue Penny Museum"};
            itemName = new String[]{"Admission Entrance Fee", "Admission Entrance Fee", "Admission Entrance Free", "Admission Fee", "Admission Entrance Fee", "Admission Entrance Fee"};
            itemName1 = new String[]{"North • 2 hours", "North • 2 hours", "North • 2 hours", "North • 2 hours", "North • 1 hours", "North • 1 hours"};
            itemImages = new int[]{R.drawable.pamplemousse_garden, R.drawable.sugar_museum_pamplemousses, R.drawable.chateau_de_labourdonnais, R.drawable.port_louis_3, R.drawable.aapravasi_ghat_1, R.drawable.blue_penny_museum_2};

        }
        if (main_day == 4 && sub_day == 2) {
            Stash.put("day", "day42");

            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.INVISIBLE);
            subview2.setVisibility(View.INVISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.VISIBLE);
            subview4.setVisibility(View.VISIBLE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.VISIBLE);
            subpressview2.setVisibility(View.VISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.INVISIBLE);
            subpressview4.setVisibility(View.INVISIBLE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"Ile aux Cerfs Beach"};
            itemName = new String[]{"Admission Catamaran Fee"};
            itemName1 = new String[]{"East • Full Day"};
            itemImages = new int[]{R.drawable.ile_aux_cerfs_mauritius_1};

        }
        if (main_day == 4 && sub_day == 3) {
            Stash.put("day", "day43");

            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.INVISIBLE);
            subview3.setVisibility(View.INVISIBLE);
            subbuttonDay4.setVisibility(View.VISIBLE);
            subview4.setVisibility(View.VISIBLE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.VISIBLE);
            subpressview3.setVisibility(View.VISIBLE);
            subpressbuttonDay4.setVisibility(View.INVISIBLE);
            subpressview4.setVisibility(View.INVISIBLE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"Casela Adventure Park", "Trou aux Cerfs", "Black River Gorges", "Chamarel Waterfalls", "Chamarel Seven Coloured Earth", "Tamarin Bay Beach"};
            itemName = new String[]{"Admission Entrance Fee", "Admission Fee", "Admission Free", "Admission Fee", "Admission Entrance Fee", "Admission Fee"};
            itemName1 = new String[]{"West • 2 hours 30 minutes", "Center • 40 minutes", "Southwest • 30 minutes", "Southwest • 35 minutes", "Southwest • 1 hour 30 minutes", "West • 1 hour"};
            itemImages = new int[]{R.drawable.casela, R.drawable.trou_aux_cerfs_4, R.drawable.black_river_georges_2, R.drawable.chamarel_1, R.drawable.chamarel_2, R.drawable.tamarin_3};
        }
        if (main_day == 4 && sub_day == 4) {
            Stash.put("day", "day44");
            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.INVISIBLE);
            subview4.setVisibility(View.INVISIBLE);
            subbuttonDay5.setVisibility(View.GONE);
            subview5.setVisibility(View.GONE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.VISIBLE);
            subpressview4.setVisibility(View.VISIBLE);
            subpressbuttonDay5.setVisibility(View.GONE);
            subpressview5.setVisibility(View.GONE);
            itemTexts = new String[]{"Eau Bleu Waterfall", "Pont Naturel Bridge", "Le Souffleur", "Gris Gris Beach", "La Roche Qui Pleure", "Rochester Falls", "Maconde Viewpoint", "La Prairie Beach"};
            itemName = new String[]{"Admission Fee", "Admission Fee", "Admission Free", "Admission Fee", "Admission Fee", "Admission Fee", "Admission Fee", "Admission Fee"};
            itemName1 = new String[]{"Southeast • 35 minutes", "South • 30 minutes", "South • 30 minutes", "South • 35 minutes", "South • 35 minutes", "South • 45 minutes", "Southwest • 30 minutes", "Southwest • 1 hour 30 minutes"};
            itemImages = new int[]{R.drawable.eau_bleu_1, R.drawable.pont_naturel_2, R.drawable.le_souffleur_1, R.drawable.gris_gris_1, R.drawable.la_roche_qui_pleure, R.drawable.rochester_falls_1, R.drawable.maconde_1, R.drawable.la_prairie_2};
        }
        if (main_day == 5 && sub_day == 1) {
            Stash.put("day", "day51");

            subbuttonDay1.setVisibility(View.INVISIBLE);
            subview1.setVisibility(View.INVISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.VISIBLE);
            subview4.setVisibility(View.VISIBLE);
            subbuttonDay5.setVisibility(View.VISIBLE);
            subview5.setVisibility(View.VISIBLE);
            subpressbuttonDay1.setVisibility(View.VISIBLE);
            subpressview1.setVisibility(View.VISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.INVISIBLE);
            subpressview4.setVisibility(View.INVISIBLE);
            subpressbuttonDay5.setVisibility(View.INVISIBLE);
            subpressview5.setVisibility(View.INVISIBLE);
            itemTexts = new String[]{"Le Caudan Waterfront", "Aapravasi Ghat", "Port Louis Central Market", "SSR Botanical Garden", "Grand Bay"};
            itemName = new String[]{"Admission Fee", "Admission Entrance Fee", "Admission Free", "Admission Entrance Fee", "Admission Entrance  Fee"};
            itemName1 = new String[]{"North • 2 hours", "North • 1 hours", "North • 1 hours", "North • 2 hours", "North • 1 hours"};
            itemImages = new int[]{R.drawable.port_louis_3, R.drawable.aapravasi_ghat_1, R.drawable.port_louis_4, R.drawable.pamplemousse_garden, R.drawable.grand_baie_1};

        }
        if (main_day == 5 && sub_day == 2) {
            Stash.put("day", "day52");

            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.INVISIBLE);
            subview2.setVisibility(View.INVISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.VISIBLE);
            subview4.setVisibility(View.VISIBLE);
            subbuttonDay5.setVisibility(View.VISIBLE);
            subview5.setVisibility(View.VISIBLE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.VISIBLE);
            subpressview2.setVisibility(View.VISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.INVISIBLE);
            subpressview4.setVisibility(View.INVISIBLE);
            subpressbuttonDay5.setVisibility(View.INVISIBLE);
            subpressview5.setVisibility(View.INVISIBLE);
            itemTexts = new String[]{"Chamarel Seven Coloured Earth", "Chamarel Waterfalls", "Black River Gorges", "Rhumerie de Chamarel", "Tamarin Bay Beach"};
            itemName = new String[]{"Admission Entrance Fee", "Admission Fee", "Admission Free", "Admission Entrance Fee", "Admission  Fee"};
            itemName1 = new String[]{"Southwest • 1 hour 30 minutes", "Southwest • 1 hour 30 minutes", "Southwest • 1 hour 30 minutes", "Southwest • 1 hour", "West • 1 hour"};
            itemImages = new int[]{R.drawable.chamarel_2, R.drawable.chamarel_1, R.drawable.black_river_georges_2, R.drawable.rhumerie_de_chamarel_1, R.drawable.tamarin_3};
        }
        if (main_day == 5 && sub_day == 3) {
            Stash.put("day", "day53");

            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.INVISIBLE);
            subview3.setVisibility(View.INVISIBLE);
            subbuttonDay4.setVisibility(View.VISIBLE);
            subview4.setVisibility(View.VISIBLE);
            subbuttonDay5.setVisibility(View.VISIBLE);
            subview5.setVisibility(View.VISIBLE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.VISIBLE);
            subpressview3.setVisibility(View.VISIBLE);
            subpressbuttonDay4.setVisibility(View.INVISIBLE);
            subpressview4.setVisibility(View.INVISIBLE);
            subpressbuttonDay5.setVisibility(View.INVISIBLE);
            subpressview5.setVisibility(View.INVISIBLE);
            itemTexts = new String[]{"Casela Adventure Park", "La Preneuse Beach", "Martello Tower", "Le Morne Brabant", "Flic en Flac Beach"};
            itemName = new String[]{"Admission Entrance Fee", "Admission Fee", "Admission Entrance Free", "Admission Fee", "Admission  Fee"};
            itemName1 = new String[]{"West • 2 hours 30 minutes", "West • 1 hour", "West • 50 minutes", "West • 1 – 3 hours", "West • 1 hour"};
            itemImages = new int[]{R.drawable.casela, R.drawable.la_preneuse_4, R.drawable.martello_tower_4, R.drawable.le_morne_1, R.drawable.flic_en_flac_3};
        }
        if (main_day == 5 && sub_day == 4) {
            Stash.put("day", "day54");

            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.INVISIBLE);
            subview4.setVisibility(View.INVISIBLE);
            subbuttonDay5.setVisibility(View.VISIBLE);
            subview5.setVisibility(View.VISIBLE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.VISIBLE);
            subpressview4.setVisibility(View.VISIBLE);
            subpressbuttonDay5.setVisibility(View.INVISIBLE);
            subpressview5.setVisibility(View.INVISIBLE);
            itemTexts = new String[]{"Mahebourg Waterfront", "Mahebourg Museum", "Blue Bay Beach", "Gris Gris Beach", "La Roche Qui Pleure", "Maconde Viewpoint", "La Prairie Beach"};
            itemName = new String[]{"Admission Fee", "Admission Fee", "Admission Free", "Admission Fee", "Admission  Fee", "Admission  Fee", "Admission  Fee"};
            itemName1 = new String[]{"Southeast • 1 – 2 hours", "Southeast • 1 – 2 hours", "Southeast • 1 – 1.5 hours", "South • 35 minutes", "South • 35 minutes", "Southwest • 30 minutes", "Southwest • 1 hour 30 minutes"};
            itemImages = new int[]{R.drawable.mahebourg, R.drawable.mahebourg_museum_2, R.drawable.blue_bay, R.drawable.gris_gris_coastal_4, R.drawable.la_roche_qui_pleure, R.drawable.maconde_1, R.drawable.la_prairie_2};
        }
        if (main_day == 5 && sub_day == 5) {
            Stash.put("day", "day55");

            subbuttonDay1.setVisibility(View.VISIBLE);
            subview1.setVisibility(View.VISIBLE);
            subbuttonDay2.setVisibility(View.VISIBLE);
            subview2.setVisibility(View.VISIBLE);
            subbuttonDay3.setVisibility(View.VISIBLE);
            subview3.setVisibility(View.VISIBLE);
            subbuttonDay4.setVisibility(View.VISIBLE);
            subview4.setVisibility(View.VISIBLE);
            subbuttonDay5.setVisibility(View.INVISIBLE);
            subview5.setVisibility(View.INVISIBLE);
            subpressbuttonDay1.setVisibility(View.INVISIBLE);
            subpressview1.setVisibility(View.INVISIBLE);
            subpressbuttonDay2.setVisibility(View.INVISIBLE);
            subpressview2.setVisibility(View.INVISIBLE);
            subpressbuttonDay3.setVisibility(View.INVISIBLE);
            subpressview3.setVisibility(View.INVISIBLE);
            subpressbuttonDay4.setVisibility(View.INVISIBLE);
            subpressview4.setVisibility(View.INVISIBLE);
            subpressbuttonDay5.setVisibility(View.VISIBLE);
            subpressview5.setVisibility(View.VISIBLE);
            itemTexts = new String[]{"Ile aux Cerfs Beach"};
            itemName = new String[]{"Admission Catamaran Fee"};
            itemName1 = new String[]{"East • Full Day"};
            itemImages = new int[]{R.drawable.ile_aux_cerfs_mauritius_1};
        }
        ListView listView = findViewById(R.id.listView);
        ItenerariesAdapter adapter = new ItenerariesAdapter(ItinerariesActivity.this, itemTexts, itemName, itemName1, itemImages);
        listView.setAdapter(adapter);
    }
    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1))
                {
                    startActivity(new Intent(ItinerariesActivity.this, DashboardActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });
        popupMenu.show();
    }

}
