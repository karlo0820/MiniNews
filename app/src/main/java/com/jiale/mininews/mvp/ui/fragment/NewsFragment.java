package com.jiale.mininews.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jiale.mininews.R;
import com.jiale.mininews.adapter.NewsAdapter;
import com.jiale.mininews.bean.ChannelBean;
import com.jiale.mininews.mvp.presenter.ChannelPresenterImpl;
import com.jiale.mininews.mvp.ui.activity.ChannelActivity;
import com.jiale.mininews.mvp.ui.activity.HomeActivity;
import com.jiale.mininews.mvp.view.IChannelView;
import com.jiale.mininews.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Karlo on 2016/12/12.
 */

public class NewsFragment extends Fragment implements IChannelView {
    private static final String TAG = "NewsFragment";
    @BindView(R.id.new_toolbar)
    Toolbar newsToolbar;
    @BindView(R.id.news_tablayout)
    TabLayout newsTablayout;
    @BindView(R.id.news_viewpager)
    ViewPager newsViewpager;
    @BindView(R.id.news_tab_add)
    ImageView newsTabAdd;
    @BindView(R.id.news_errortext)
    TextView newsErrortext;
    @BindView(R.id.news_progressbar)
    ProgressBar newsProgressbar;
    private List<NewsListFragment> fragments;
    private ChannelPresenterImpl channelPresenter;
    List<ChannelBean> titles;
    private NewsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(TAG,"onCreate");
        initData();
    }

    private void initData() {
        channelPresenter = new ChannelPresenterImpl(getContext(), this);
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.i(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        initViews();
        initEvents();
        return view;
    }

    private void initViews() {
        ((HomeActivity) getActivity()).setToggle(newsToolbar);
    }

    private void initEvents() {
        newsTabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChannelActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.i(TAG,"onViewCreated");
        channelPresenter.getChannel();
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.i(TAG,"onResume");
    }

    /*重置数据*/
    private void resetData(List<ChannelBean> list) {
        LogUtil.i(TAG,"resetData");
        titles.clear();
        fragments.clear();
        titles.addAll(list);
        for (int i = 0; i < list.size(); i++) {
            fragments.add(NewsListFragment.getInstance(list.get(i).getChannelId()));
        }
        if(fragments.size()>4){
            newsTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }else{
            newsTablayout.setTabMode(TabLayout.MODE_FIXED);
        }
        adapter = new NewsAdapter(getFragmentManager(),fragments,titles);
        newsViewpager.setAdapter(adapter);
        newsTablayout.setupWithViewPager(newsViewpager);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        newsProgressbar.setVisibility(View.VISIBLE);
        newsViewpager.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        newsProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void getChannelSuccess(int DataType, List<ChannelBean> list) {
        LogUtil.i(TAG,"getChannelSuccess");
        newsViewpager.setVisibility(View.VISIBLE);
        if (newsErrortext.getVisibility() == View.VISIBLE) {
            newsErrortext.setVisibility(View.INVISIBLE);
        }
        if (DataType == ChannelPresenterImpl.TYPE_SELECT) {
            LogUtil.i(TAG, "listSize="+ list.size());
            resetData(list);
        }
    }

    /*获取频道失败*/
    @Override
    public void getChannelError(String msg) {
        LogUtil.i(TAG,"getChannelError");
        newsErrortext.setVisibility(View.VISIBLE);
//        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == 1) {
            LogUtil.i(TAG,"onActivityResult");
            channelPresenter.getChannel();
//            if (data != null) {
//                LogUtil.i("onActivityResult", "结果");
//                List<ChannelBean> channellist = data.getParcelableArrayListExtra("channel");
//                if (channellist != null) {
//                    LogUtil.i("chanllistSize=", "" + channellist.size());
//                    List<String> tempTitles = new ArrayList<>(channellist.size());
//                    for (ChannelBean bean : channellist) {
//                        tempTitles.add(bean.getName());
//                    }
//                    if (titles.size() == tempTitles.size() && titles.containsAll(tempTitles)) {
//                        /*频道一致，不需要刷新*/
//                        LogUtil.i("channel", "一致");
//                        return;
//                    }
//                }
//            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
