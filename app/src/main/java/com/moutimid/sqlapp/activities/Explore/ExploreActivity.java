package com.moutimid.sqlapp.activities.Explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.Beaches.BeachesActivity;
import com.moutimid.sqlapp.activities.TourshipActivity;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
    }

    public void BackPress(View view) {
        onBackPressed();
    }

    public void beaches(View view) {
        startActivity(new Intent(ExploreActivity.this, BeachesActivity.class));
    }

    public void west(View view) {
        String[] itemName1 = {"Albion LightHouse", "Flic en Flac Public Beach", "Casela Adventure Park", "Tamarin Bay Beach", "La Preneuse Public Beach"
                , "Martello Tower", "Le Morne Brabant", "Maconde Viewpoint", "Seven Coloured Earths", "Chamarel Waterfalls"
                , "Black River Gorges", "Le Morne Public Beach", "Rhumerie de Chamarel", "Curious Corners"};
        int[] itemImages = {R.drawable.albion_lighthouse, R.drawable.flic_en_flac_3, R.drawable.casela, R.drawable.tamarin_3, R.drawable.la_preneuse_4, R.drawable.martello_tower_4, R.drawable.le_morne_1,
                R.drawable.maconde_1, R.drawable.chamarel_2, R.drawable.chamarel_1, R.drawable.black_river_georges_2, R.drawable.le_morne_beach_2, R.drawable.rhumerie_de_chamarel_1,
                R.drawable.curious_corner_2};
        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "West");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        startActivity(intent);

    }

    public void east(View view) {

        String[] itemName1 = {"La Vallee de Ferney", "Grand Port Heritage Site", "Belle Mare Beach",
                "Poste Lafayette Beach", "Roche Noire Beach", "Ile aux Cerfs Beach"};
        int[] itemImages = {R.drawable.ferney_1, R.drawable.frederik_hendrik_museum_1, R.drawable.belle_mare_1,
                R.drawable.poste_lafayette_1, R.drawable.roche_noire_2,
                R.drawable.ile_aux_cerfs_mauritius_1};
        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "East");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        startActivity(intent);
    }

    public void north(View view) {

        String[] itemName1 = {"Notre Dame Chapel", "SSR Botanical Garden", "L’Aventure du Sucre",
                "Baie de L’Arsenal Ruins", "Mauritius Aquarium", "Grand Bay"
                , "Caudan Waterfront", "Port Louis Market", "Government House", "Place D’Armes",
                "Blue Penny Museum", "St Louis Cathedral", "Natural History Museum", "Aapravasi Ghat",
                "Mauritius Postal Museum", "Forte Adelaide", "Photography Museum",
                "Marie Reine Chapel", "Jardin de la Compagnie", "Odysseo", "Chateau Labourdonnais"};
        int[] itemImages = {R.drawable.red_roof_church, R.drawable.pamplemousse_garden, R.drawable.sugar_museum_pamplemousses,
                R.drawable.baie_de_larsenal_2, R.drawable.mauritius_aquarium_1,
                R.drawable.grand_baie_1, R.drawable.port_louis_3,
                R.drawable.port_louis_4, R.drawable.port_louis_9,
                R.drawable.place_des_armes, R.drawable.blue_penny_museum_2,
                R.drawable.church_pl, R.drawable.natural_history_musuem,
                R.drawable.aapravasi_ghat_1, R.drawable.post_office,
                R.drawable.citadelle, R.drawable.port_louis_photography_museum,
                R.drawable.marie_reine_de_la_paix_3, R.drawable.jardin_de_la_compagnie_1,
                R.drawable.odysseo_1, R.drawable.chateau_de_labourdonnais};
        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "North");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        startActivity(intent);
    }

    public void south(View view) {

        String[] itemName1 = {"Gris Gris", "Rochester Falls", "Bel Ombre Nature Res",
                "La Vallee de Couleurs", "Blue Bay Beach", "Mahebourg Waterfront"
                , "Mahebourg Museum", "Ile aux Fouqets", "Ile aux Aigrettes"};

        int[] itemImages = {R.drawable.gris_gris_coastal_4, R.drawable.rochester_falls_1,
                R.drawable.bel_ombre_1,
                R.drawable.valle_des_couleurs, R.drawable.blue_bay,
                R.drawable.mahebourg, R.drawable.mahebourg_museum_2,
                R.drawable.ile_aux_fouquets, R.drawable.ile_aux_aigrettes_1};
        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "South");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        startActivity(intent);
    }

    public void central(View view) {

        String[] itemName1 = {"Bagatelle Mall", "Bois Cheri Tea Museum", "Eureka House",
                "Grand Bassin", "Gymkhana Golf Course", "Le Pouce Mountain"
                , "Pieter Both Mountain", "Tamarin Falls", "Trou aux Cerfs"};

        int[] itemImages = {R.drawable.bagatelle_mall_1, R.drawable.bois_cheri_1,
                R.drawable.eureka_house,
                R.drawable.grand_bassin_1, R.drawable.gymkhana_2,
                R.drawable.le_pouce_1, R.drawable.pieter_both_1,
                R.drawable.tamarin_falls_1, R.drawable.trou_aux_cerfs_4};
        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "Central");
        intent.putExtra("itemName1", itemName1);

        intent.putExtra("itemImages", itemImages);
        startActivity(intent);
    }
    public void tourship_map(View view) {

           Intent intent = new Intent(ExploreActivity.this, TourshipActivity.class);
        startActivity(intent);
    }
}