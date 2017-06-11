package com.testtask.dell.mytesttask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by DELL on 6/11/2017.
 */

class TabsPager extends FragmentStatePagerAdapter {

    int tabCount;
    public TabsPager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
        Log.i("tcount", String.valueOf(tabCount));
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Log.i("pos", String.valueOf(position));
                VideosListFragment videosListFragment = new VideosListFragment();
                return videosListFragment;
            case 1:
                ImagesListFragment imagesListFragment = new ImagesListFragment();
                return imagesListFragment;
            case 2:
                MilestoneFragment milestoneFragment = new MilestoneFragment();
                return milestoneFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
