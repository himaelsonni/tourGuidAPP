package com.example.android.tourguidapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class fragmentPagerAdapter extends FragmentPagerAdapter {
    public fragmentPagerAdapter(FragmentManager fm){super(fm);}
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PublicPlacesFragment();
            case 1:
                return new RestaurantFragment();
            case 2:
                return new TopAttractionFragment();
            case 3:
                return new EventFragment();
            default:
                break;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "public Places";
            case 1:
                return "Restaurants";
            case 2:
                return "Top Attraction";
            case 3:
                return "Event";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

}
