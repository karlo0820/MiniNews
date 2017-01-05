package com.jiale.mininews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import com.jiale.mininews.apis.ApiConstans;
import com.jiale.mininews.bean.ChannelBean;
import com.jiale.mininews.mvp.ui.fragment.NewsListFragment;
import com.jiale.mininews.utils.Constant;
import com.jiale.mininews.utils.LogUtil;

import java.util.List;

/**
 * Created by Karlo on 2016/12/16.
 */

public class NewsAdapter extends FragmentPagerAdapter {
    private List<NewsListFragment> fragments;
    private List<ChannelBean> titles;
    public NewsAdapter(FragmentManager fm, List<NewsListFragment> fragments, List<ChannelBean> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position).getName();
    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        NewsListFragment newsListFragment = (NewsListFragment) super.instantiateItem(container, position);
//        newsListFragment.setId(titles.get(position).getChannelId());
//        LogUtil.i("ListAdapter id:",titles.get(position).getChannelId());
////        newsListFragment.request(ApiConstans.REFRESH);
//////        NewsListFragment newsListFragment = fragments.get(position);
//        return newsListFragment;
//    }

    @Override
    public long getItemId(int position) {
        return fragments.get(position).hashCode();
//        if(chidCount>0){
//            chidCount--;
//            return FragmentPagerAdapter.POSITION_NONE;
//        }
//        return super.getItemId(position);
    }

    @Override
    public void notifyDataSetChanged() {
//        chidCount = getCount();
        super.notifyDataSetChanged();
    }
}
