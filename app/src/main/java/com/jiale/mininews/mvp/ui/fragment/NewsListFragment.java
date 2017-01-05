package com.jiale.mininews.mvp.ui.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jiale.mininews.R;
import com.jiale.mininews.adapter.AbsAdapter;
import com.jiale.mininews.adapter.NewsListAdapter;
import com.jiale.mininews.apis.ApiConstans;
import com.jiale.mininews.bean.NewsBean;
import com.jiale.mininews.mvp.presenter.NewsListPresenterImpl;
import com.jiale.mininews.mvp.ui.activity.NewsDetailActivity;
import com.jiale.mininews.mvp.ui.activity.NewsDetailPhotoActivity;
import com.jiale.mininews.mvp.view.INewsListView;
import com.jiale.mininews.utils.Constant;
import com.jiale.mininews.utils.IntentUtil;
import com.jiale.mininews.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Karlo on 2016/12/12.
 */

public class NewsListFragment extends Fragment implements INewsListView {
    private static final String TAG = "NewsListFragment";
    @BindView(R.id.newslist_recyclerview)
    RecyclerView newslistRecyclerview;
    @BindView(R.id.newslist_textview_error)
    TextView newslistTextviewError;
    @BindView(R.id.newslist_refreshLayout)
    SwipeRefreshLayout newslistRefreshLayout;
    @BindView(R.id.newslist_down_progressbar)
    ProgressBar newslistDownProgressbar;
    private NewsListPresenterImpl newsPresenter;
    private NewsListAdapter adapter;
    private List<NewsBean> data;
    private String id;
    private int requestState = -1;
    private boolean isLoading = false;

    public static NewsListFragment getInstance(String id) {
        NewsListFragment newsListFragment = new NewsListFragment();
        newsListFragment.setId(id);
//        Bundle bundle = new Bundle();
//        LogUtil.i(TAG, "channelId==" + id);
//        bundle.putString(ApiConstans.API_ID, id);
//        newsListFragment.setArguments(bundle);
        return newsListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        LogUtil.i(TAG, id + "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.i(TAG, id + "onCreateView");
        View view = inflater.inflate(R.layout.fragment_newslist, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.i(TAG, id + "onViewCreated");
        initViews();
        initEvents();
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.i(TAG, id + "onResume");
           /*第一次加载数据*/
        request(ApiConstans.FIRST);
    }

    public void setId(String id) {
        this.id = id;
    }

    private void initData() {
//        id = getArguments().getString(ApiConstans.API_ID);
        LogUtil.i(TAG, id + "initData");
        newsPresenter = new NewsListPresenterImpl(this);
        data = new ArrayList<>();
        adapter = getNewsListAdapter();
    }

    private void initViews() {
        LogUtil.i(TAG, id + "initViews");
        newslistRecyclerview.setAdapter(adapter);
        newslistRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        newslistRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                /*刷新数据*/
                request(ApiConstans.REFRESH);
            }
        });

    }

    private void initEvents() {
        newslistRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastPosition = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (adapter.getLoadState() == NewsListAdapter.LODING) {
                    return;
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPosition + 1 == adapter.getItemCount()) {
                    LogUtil.i(id + "newlistfragment", "加载更多");
                    if (newsPresenter != null) {
                        request(ApiConstans.MORE);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                lastPosition = layoutManager.findLastVisibleItemPosition();
            }
        });
        newslistTextviewError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                request(ApiConstans.FIRST);
            }
        });
        adapter.setListener(new AbsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(AbsAdapter.CommonViewHolder holder) {
                NewsBean newsBean = data.get(holder.getLayoutPosition());
                Toast.makeText(getActivity(), newsBean.getTitle(), Toast.LENGTH_SHORT).show();
                LogUtil.i("", newsBean.toString());
                if (newsBean.getType() == 0) {
                    View view = holder.findView(R.id.newslist_cover);
                    Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                    intent.putExtra(IntentUtil.NEWSDETAIL_POSTID, newsBean.getPostid());
                    intent.putExtra(IntentUtil.NEWSDETAIL_IMGSRC, newsBean.getImgsrc());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), view, getResources().getString(R.string.transition));
                        startActivity(intent, options.toBundle());
                    } else {
                        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), view, getResources().getString(R.string.transition));
                        startActivity(intent, optionsCompat.toBundle());
                    }
                } else {
                    Intent intent = null;
                    if (Constant.LIVE.equals(newsBean.getSkipType())) {

                    } else {
                        intent = new Intent(getActivity(), NewsDetailPhotoActivity.class);
                        String skipID = newsBean.getSkipID();
                        if (skipID != null) {
                            LogUtil.i(id + "skipid", skipID);
                            intent.putExtra("skipId", skipID);
                        }
                        startActivity(intent);
                    }
                }
            }
        });
    }

    @NonNull
    private NewsListAdapter getNewsListAdapter() {
        return new NewsListAdapter(getActivity(), data, true, R.layout.newslist_item_layout, R.layout.newslist_itemad_layout);
    }

    public void request(int type) {
        if (isLoading) {
            return;
        }
        if (newsPresenter == null) {
            newsPresenter = new NewsListPresenterImpl(this);
        }
        isLoading = true;
        switch (type) {
            case ApiConstans.FIRST: {
                LogUtil.i(TAG, id + "request-FIRST");
                requestState = ApiConstans.FIRST;
                newsPresenter.loadData(requestState, id);
            }
            break;
            case ApiConstans.REFRESH: {
                LogUtil.i(TAG, id + "request-REFRESH");
                requestState = ApiConstans.REFRESH;
                newsPresenter.loadData(requestState, id);
            }
            break;
            case ApiConstans.MORE: {
                LogUtil.i(TAG, id + "request-MORE");
                requestState = ApiConstans.MORE;
                newsPresenter.loadData(requestState, id);
            }
            break;
        }
    }

    @Override
    public void showProgress() {
        LogUtil.i(TAG, "显示进度条");
        if (requestState == ApiConstans.FIRST) {
            newslistDownProgressbar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        isLoading = false;
        LogUtil.i(TAG, "隐藏进度条");
        newslistDownProgressbar.setVisibility(View.GONE);
        if (newslistRefreshLayout.isRefreshing()) {
            newslistRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void loadSuccess(int requestType, List<NewsBean> newsBeanList) {
        if (newslistTextviewError.getVisibility() == View.VISIBLE) {
            newslistTextviewError.setVisibility(View.INVISIBLE);
        }
        if (requestType == ApiConstans.FIRST) {
            LogUtil.i(TAG, id + "loadSuccess-FIRST");
            data.clear();
            data.addAll(newsBeanList);
        } else if (requestType == ApiConstans.REFRESH) {
            LogUtil.i(TAG, id + "loadSuccess-REFRESH");
            if (data.containsAll(newsBeanList)) {
                Toast.makeText(getActivity(), "无新数据", Toast.LENGTH_SHORT).show();
                return;
            }
            data.clear();
            data.addAll(newsBeanList);
        } else if (requestType == ApiConstans.MORE) {
            LogUtil.i(TAG, id + "loadSuccess-MORE");
            adapter.setLoadState(NewsListAdapter.NORMAL);
            data.addAll(newsBeanList);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadError(int requestType, String msg) {
        switch (requestType) {
            case ApiConstans.REFRESH: {
                LogUtil.i(TAG, id + "-LoadError-REFRESH");
                Toast.makeText(getActivity(), "刷新失败" + msg, Toast.LENGTH_SHORT).show();
            }
            break;
            case ApiConstans.FIRST: {
                LogUtil.i(TAG, id + "-LoadError-FIRST");
                newslistTextviewError.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), "初始化数据失败" + msg, Toast.LENGTH_SHORT).show();
            }
            break;
            case ApiConstans.MORE: {
                LogUtil.i(TAG, id + "-LoadError-MORE");
                Toast.makeText(getActivity(), "加载更多数据失败" + msg, Toast.LENGTH_SHORT).show();
                adapter.setLoadState(NewsListAdapter.NORMAL);
                adapter.hideLoadMoreView();
            }
            break;
        }
    }
}
