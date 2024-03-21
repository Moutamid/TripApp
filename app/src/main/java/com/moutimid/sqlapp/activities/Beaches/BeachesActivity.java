package com.moutimid.sqlapp.activities.Beaches;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.model.BeachItem;

public class BeachesActivity extends AppCompatActivity {
    BeachItem[] beachItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beaches);
    }

    public void BackPress(View view) {
        onBackPressed();
    }

    public void beaches_in_east(View view) {
        String title_header = "Beaches in the East";
        String title = "East";
        String[] itemTexts = {"District of Flacq ", "District of Flacq", "District of Flacq", "District of Riviere du Rempart"};
        String[] itemName = {"Belle Mare Beach", "Ile aux Cerfs Beach", "Poste Lafayette Beach", "Roche Noire Beach"};
        String[] itemName1 = {"Belle Mare", "Ile aux Cerfs", "Poste Lafayette", "Roche Noire"};
        int[] itemImages = {R.drawable.belle_mare_1, R.drawable.ile_aux_cerfs_mauritius_1, R.drawable.poste_lafayette_1, R.drawable.roche_noire_2};
        Intent intent = new Intent(BeachesActivity.this, BeachesTypeActivity.class);
        intent.putExtra("itemHeader", title_header);
        intent.putExtra("itemTitle", title);
        intent.putExtra("itemTexts", itemTexts);
        intent.putExtra("itemName", itemName);
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        startActivity(intent);
    }

    public void beaches_in_west(View view) {
        String title_header = "Beaches in the West";
        String title = "West";
        String[] itemTexts = {"Flic en Flac", "La Preneuse", "Le Morne Brabant", "Tamarin"};
        String[] itemName = {"Flic en Flac Public Beach", "La Preneuse Public Beach", "Le Morne Public Beach", "Tamarin Bay Beach"};
        String[] itemName1 = {"District of Black River", "District of Black River", "District of Black River", "District of Black River"};
        int[] itemImages = {R.drawable.flic_en_flac_3, R.drawable.la_preneuse_4, R.drawable.le_morne_beach_2, R.drawable.tamarin_3};
        Intent intent = new Intent(BeachesActivity.this, BeachesTypeActivity.class);
        intent.putExtra("itemHeader", title_header);
        intent.putExtra("itemTitle", title);
        intent.putExtra("itemTexts", itemTexts);
        intent.putExtra("itemName", itemName);
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        startActivity(intent);

    }

    public void beaches_in_south(View view) {
        String title_header = "Beaches in the South";
        String title = "South";
        String[] itemName = {"Bel Ombre Beach", "Blue Bay Beach", "Gris Gris Beach", "La Cambuse Beach", "Riviere des Galets Beach", "St Felix Beach" };
        String[] itemName1 = {"St Martin", "Blue Bay", "Souillac", "La Cambuse", "Riviere des Galets", "St Felix"};
        String[] itemTexts = {"District of Savanne", "District of Grand Port","District of Savanne","District of Plaine Magnien","District of Savanne","District of Savanne"};
        int[] itemImages = {R.drawable.bel_ombre_17, R.drawable.blue_bay, R.drawable.gris_gris_1, R.drawable.la_cambuse_2, R.drawable.riviere_des_galets_1, R.drawable.st_felix_1};
        Intent intent = new Intent(BeachesActivity.this, BeachesTypeActivity.class);
        intent.putExtra("itemHeader", title_header);
        intent.putExtra("itemTitle", title);
        intent.putExtra("itemTexts", itemTexts);
        intent.putExtra("itemName", itemName);
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        startActivity(intent);

    }

    public void beaches_in_north(View view) {
        String title_header = "Beaches in the North";
        String title = "North";

        String[] itemTexts = {"Cap Malheureux", "Grand Gaube", "Mont Choisy", "Grand Baie", "Trou aux Biches"};
        String[] itemName = {"Cap Malheureux Public Beach", "Grand Gaube Public Beach", "Mont Choisy Public Beach", "Pereybere Public Beach", "Trou aux Biches Public Beach"};
        String[] itemName1 = {"District of Riviere du Rempart", "District of Riviere du Rempart", "District of Pamplemousses", "District of Riviere du Rempart", "District of Pamplemousses"};
        int[] itemImages = {R.drawable.cap_malheureux_6, R.drawable.grand_gaube_1, R.drawable.mont_choisy_2, R.drawable.pereybere_beach_1, R.drawable.trou_aux_biches_1};
        Intent intent = new Intent(BeachesActivity.this, BeachesTypeActivity.class);
        intent.putExtra("itemHeader", title_header);
        intent.putExtra("itemTitle", title);
        intent.putExtra("itemTexts", itemTexts);
        intent.putExtra("itemName", itemName);
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        startActivity(intent);

    }
}