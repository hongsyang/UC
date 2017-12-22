package com.xzt.uc;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Created by 阿雷 on 2017/12/7.
 */

public class FavoriteAndHistoryAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;
    private List<String> list_title;
    public FavoriteAndHistoryAdapter(FragmentManager fm,List<Fragment> list_fragment,List<String> list_title){
        super(fm);
        this.list_fragment=list_fragment;
        this.list_title=list_title;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_title.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {

        return list_title.get(position % list_title.size());
    }
}
