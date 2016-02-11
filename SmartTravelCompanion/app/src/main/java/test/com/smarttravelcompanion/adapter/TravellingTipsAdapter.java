package test.com.smarttravelcompanion.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import test.com.smarttravelcompanion.fragmentips.ArtifactsFragment;
import test.com.smarttravelcompanion.fragmentips.DresstipsFragment;
import test.com.smarttravelcompanion.fragmentips.SafetytipsFragment;

/**
 * Created by devu on 2/9/2016.
 */
public class TravellingTipsAdapter extends FragmentStatePagerAdapter {
    public TravellingTipsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment =new DresstipsFragment();
            break;
            case 1:
                fragment = new SafetytipsFragment();
                break;
            case 2:
                fragment = new ArtifactsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="1";
                break;
            case 1:
                title="2";
                break;
            case 2:
                title="3";
                break;
        }
        return title;
    }
}
