package com.moutimid.sqlapp.activities.Organizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.DashboardActivity;
import com.moutimid.sqlapp.activities.Organizer.Fragment.CalenderFragment;
import com.moutimid.sqlapp.activities.Organizer.Fragment.DocumentFragment;

public class MyDocsActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_docs);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        replaceFragment(new DocumentFragment());
        bottomNavigationView.setSelectedItemId(R.id.doc);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuItemId = item.getItemId();

                if (menuItemId == R.id.home) {
                    startActivity(new Intent(MyDocsActivity.this, DashboardActivity.class));
                    return true;
                } else if (menuItemId == R.id.doc) {
                    replaceFragment(new DocumentFragment());
                    return true;
                } else if (menuItemId == R.id.calender) {
                    replaceFragment(new CalenderFragment());
                    return true;
                }

                return true;
            }
        });
    }

    public void BackPress(View view) {
        onBackPressed();
    }

    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1)) {
                    startActivity(new Intent(MyDocsActivity.this, DashboardActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });

        popupMenu.show();

    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();


    }
}