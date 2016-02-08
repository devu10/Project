package test.com.smarttravelcompanion;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import test.com.smarttravelcompanion.adapter.TopdestinationViewAdapter;
import test.com.smarttravelcompanion.adapter.TravellingTipsAdapter;

/**
 * Created by devu on 2/9/2016.
 */
public class TravellingTipsActivity extends AppCompatActivity
{
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travellingtips_layout);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        tabLayout =(TabLayout)findViewById(R.id.tab_layout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        TravellingTipsAdapter adapter = new TravellingTipsAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);

    }
}
