package com.lanou.xuhaijia.enjoylife.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 国冰冰 on 16/9/13.
 */
public class NewsMainAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> freagments;
    ArrayList<String> arraylist = new ArrayList<>();

    public NewsMainAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFreagments(ArrayList<Fragment> freagments) {
        this.freagments = freagments;
        arraylist.add("精选");
        arraylist.add("体育");
        arraylist.add("娱乐");
        arraylist.add("美食");
    }
    @Override
    public int getCount() {
        return freagments == null ? 0 : freagments.size();
    }


    @Override
    public Fragment getItem(int position) {
        return freagments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arraylist.get(position);
    }
}