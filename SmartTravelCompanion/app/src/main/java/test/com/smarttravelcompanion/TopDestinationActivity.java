package test.com.smarttravelcompanion;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import test.com.smarttravelcompanion.adapter.TopdestinationViewAdapter;

/**
 * Created by devu on 2/7/2016.
 */
public class TopDestinationActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topdestination_layout);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        tabLayout =(TabLayout)findViewById(R.id.tab_layout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        TopdestinationViewAdapter adapter = new TopdestinationViewAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);

    }
}
