package test.com.smarttravelcompanion.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import test.com.smarttravelcompanion.fragmentips.BasantapurFragment;
import test.com.smarttravelcompanion.fragmentips.BhaktapurFragment;
import test.com.smarttravelcompanion.fragmentips.BoudhanathFragment;
import test.com.smarttravelcompanion.fragmentips.PatanFragment;
import test.com.smarttravelcompanion.fragmentips.SwayambhunathFragment;

/**
 * Created by devu on 2/8/2016.
 */
public class TopdestinationViewAdapter extends FragmentStatePagerAdapter {
    public TopdestinationViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new BasantapurFragment();
                break;
            case 1:
                fragment = new PatanFragment();
                break;
            case 2:
                fragment = new BhaktapurFragment();
                break;
            case 3:
                fragment = new SwayambhunathFragment();
                break;
            case 4:
                fragment = new BoudhanathFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
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
            case 3:
                title="4";
                break;
            case 4:
                title="5";
                break;
        }
        return title;
    }
}
