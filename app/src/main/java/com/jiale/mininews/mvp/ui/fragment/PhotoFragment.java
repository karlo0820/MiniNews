package com.jiale.mininews.mvp.ui.fragment;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jiale.mininews.R;
import com.jiale.mininews.adapter.AbsAdapter;
import com.jiale.mininews.adapter.PhotoAdapter;
import com.jiale.mininews.apis.ApiConstans;
import com.jiale.mininews.bean.PhotoBean;
import com.jiale.mininews.mvp.presenter.PhotoPresenterImpl;
import com.jiale.mininews.mvp.ui.activity.OnePhotoActivity;
import com.jiale.mininews.mvp.view.IPhotoView;
import com.jiale.mininews.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Karlo on 2016/12/17.
 */

public class PhotoFragment extends BaseFragment implements IPhotoView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.photo_content_recyclerview)
    RecyclerView photoContentRecyclerview;
    @BindView(R.id.photo_content_swiperefresh)
    SwipeRefreshLayout photoContentSwiperefresh;
    @BindView(R.id.photo_content_errortext)
    TextView photoContentErrortext;
    @BindView(R.id.photo_content_progressbar)
    ProgressBar photoContentProgressbar;
    private PhotoPresenterImpl photoPresenter;
    private PhotoAdapter adapter;
    private int requestType = ApiConstans.FIRST;
    private StaggeredGridLayoutManager staglayoutManager;
    private boolean isLoading = false;
    private List<PhotoBean> data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        request(ApiConstans.FIRST);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_photo;
    }

    @Override
    public void initData() {
        photoPresenter = new PhotoPresenterImpl(this);
        data = new ArrayList<>();
        adapter = new PhotoAdapter(getActivity(), data, false, R.layout.photo_item_layout);
        staglayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    }

    @Override
    public void initView() {
        photoContentRecyclerview.setAdapter(adapter);
        photoContentRecyclerview.setLayoutManager(staglayoutManager);
    }

    @Override
    public void initEvent() {
        adapter.setListener(new AbsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(AbsAdapter.CommonViewHolder holder) {
                Intent intent = new Intent(getActivity(), OnePhotoActivity.class);
                intent.putExtra(Constant.ONEPHOTO_URL, data.get(holder.getLayoutPosition()).getUrl());
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), holder.findView(R.id.photo_item_img), getResources().getString(R.string.transition));
                    startActivity(intent, options.toBundle());
                } else {
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), holder.findView(R.id.photo_item_img), getResources().getString(R.string.transition));
                    startActivity(intent, activityOptionsCompat.toBundle());
                }
            }
        });
        photoContentErrortext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request(ApiConstans.FIRST);
            }
        });
        photoContentSwiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                request(ApiConstans.REFRESH);
            }
        });

        photoContentRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int[] lastVisibleItemPositions = staglayoutManager.findLastVisibleItemPositions(null);
                int visibleCount = staglayoutManager.getChildCount();
                int totalCount = staglayoutManager.getItemCount();
                if (newState == RecyclerView.SCROLL_STATE_IDLE && visibleCount > 0 && (lastVisibleItemPositions[0] >= totalCount - 1) || lastVisibleItemPositions[1] >= totalCount - 1) {
                    request(ApiConstans.MORE);
                }
            }
        });
    }

    private void request(int type) {
        if (isLoading) {
            return;
        }
        if (photoPresenter != null) {
            requestType = type;
            photoPresenter.loadData(type);
            isLoading = true;
        }
    }

    @Override
    public void showProgress() {
        if (requestType == ApiConstans.FIRST) {
            photoContentProgressbar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        isLoading = false;
        if (requestType == ApiConstans.FIRST && photoContentProgressbar.getVisibility() == View.VISIBLE) {
            photoContentProgressbar.setVisibility(View.GONE);
        }
        if (photoContentSwiperefresh.isRefreshing()) {
            photoContentSwiperefresh.setRefreshing(false);
        }
    }

    @Override
    public void loadPhotoList(int type, List<PhotoBean> list) {
        switch (type) {
            case ApiConstans.FIRST: {
                if (photoContentErrortext.getVisibility() == View.VISIBLE) {
                    photoContentErrortext.setVisibility(View.GONE);
                }
                data.addAll(list);
                adapter.notifyDataSetChanged();
                break;
            }
            case ApiConstans.REFRESH: {
                data.clear();
                data.addAll(list);
                adapter.notifyItemRangeChanged(0, list.size());
                break;
            }
            case ApiConstans.MORE: {
                int size = data.size();
                adapter.addAllData(list);
                adapter.notifyItemRangeChanged(size - 1, list.size());
                break;
            }
        }
    }

    @Override
    public void loadFail(int type, String msg) {
        if (type == ApiConstans.FIRST) {
            photoContentErrortext.setVisibility(View.VISIBLE);
        }
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
