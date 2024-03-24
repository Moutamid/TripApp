package com.moutimid.sqlapp.activities.Calender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moutimid.sqlapp.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.moutimid.sqlapp.activities.Calender.Fragments.DayFragment;

public class CalenderActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        setupViewPager();
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
//        adapter.addFragment(new DayFragment(), "Week");
//        adapter.addFragment(new DayFragment(), "Month");
        adapter.addFragment(new DayFragment(), "Day");

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getTitle(position))
        ).attach();
    }
}
