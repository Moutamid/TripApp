package com.moutamid.sqlapp.activities.Explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.moutamid.sqlapp.R;
import com.moutamid.sqlapp.activities.Beaches.BeachesActivity;
import com.moutamid.sqlapp.activities.TourshipActivity;

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

        double[] itemLatitudes = {-20.1912902, -20.2993385, -20.2911619, -20.3262782, -20.3547236,
                -20.3546962, -20.4499767, -20.4911178, -20.4401637, -20.4432469,
                -20.4267316, -20.4529630, -20.4279001, -20.4387179};
        double[] itemLongitudes = {57.4114837, 57.3636901, 57.4040171, 57.3778870, 57.3614249,
                57.3619205, 57.3165315, 57.3711084, 57.3733048, 57.3857878,
                57.4512266, 57.3125745, 57.3963121, 57.3902818};

        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "West");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        intent.putExtra("itemLatitudes", itemLatitudes);
        intent.putExtra("itemLongitudes", itemLongitudes);
        startActivity(intent);
    }

    public void east(View view) {
        String[] itemName1 = {"La Vallee de Ferney", "Grand Port Heritage Site", "Belle Mare Beach",
                "Poste Lafayette Beach", "Roche Noire Beach", "Ile aux Cerfs Beach"};
        int[] itemImages = {R.drawable.ferney_1, R.drawable.frederik_hendrik_museum_1, R.drawable.belle_mare_1,
                R.drawable.poste_lafayette_1, R.drawable.roche_noire_2,
                R.drawable.ile_aux_cerfs_mauritius_1};

        double[] itemLatitudes = {-20.3646662, -20.3748935, -20.1928215, -20.1272669, -20.1043210, -20.2668829};
        double[] itemLongitudes = {57.7045690, 57.7220704, 57.7750124, 57.7569250, 57.7257182, 57.8057047};

        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "East");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        intent.putExtra("itemLatitudes", itemLatitudes);
        intent.putExtra("itemLongitudes", itemLongitudes);
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

        double[] itemLatitudes = {-19.9867007, -20.1042691, -20.0978896, -20.0838732, -20.0566720,
                -20.0089233, -20.1608170, -20.1606798, -20.1632027, -20.1617266,
                -20.1609300, -20.1644918, -20.1632449, -20.1586888, -20.1600091,
                -20.1637132, -20.1641560, -20.1704784, -20.1637060, -20.1590542,
                -20.0736144};
        double[] itemLongitudes = {57.6222564, 57.5799724, 57.5743742, 57.5138079, 57.5224544,
                57.5812308, 57.4980775, 57.5029272, 57.5034466, 57.5020649,
                57.4974394, 57.5065137, 57.5024089, 57.5029467, 57.5017028,
                57.5103489, 57.5035763, 57.4962069, 57.5020793, 57.4948769,
                57.6176456};

        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "North");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        intent.putExtra("itemLatitudes", itemLatitudes);
        intent.putExtra("itemLongitudes", itemLongitudes);
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

        double[] itemLatitudes = {-20.5245931, -20.5050141, -20.5009853, -20.4577121, -20.4441615,
                -20.4050030, -20.4163129, -20.3954058, -20.4214025};
        double[] itemLongitudes = {57.5190262, 57.5158852, 57.3917858, 57.5504605, 57.7194806,
                57.7017696, 57.7064305, 57.7563514, 57.7319953};

        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "South");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        intent.putExtra("itemLatitudes", itemLatitudes);
        intent.putExtra("itemLongitudes", itemLongitudes);
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

        double[] itemLatitudes = {-20.2414892, -20.4293628, -20.2632341, -20.4052763, -20.2828076,
                -20.2197923, -20.2124374, -20.2606790, -20.3171534};
        double[] itemLongitudes = {57.4917458, 57.5419420, 57.4969327, 57.6065655, 57.4974385,
                57.5452105, 57.5642116, 57.4982393, 57.5014187};

        Intent intent = new Intent(ExploreActivity.this, ExploreDetailsActivity.class);
        intent.putExtra("itemHeader", "Central");
        intent.putExtra("itemName1", itemName1);
        intent.putExtra("itemImages", itemImages);
        intent.putExtra("itemLatitudes", itemLatitudes);
        intent.putExtra("itemLongitudes", itemLongitudes);
        startActivity(intent);
    }

    public void tourship_map(View view) {
        Intent intent = new Intent(ExploreActivity.this, TourshipActivity.class);
        startActivity(intent);
    }
}
