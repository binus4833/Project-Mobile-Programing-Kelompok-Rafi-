package com.example.compshop_myorder;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdpater extends FragmentPagerAdapter {

    private int numberOfTabs;

    public PagerAdpater(@NonNull FragmentManager fm, int behavior, int numberOfTabs) {
        super(fm, behavior);
        this.numberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Login();

            case 1:
                return new SignUp();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
