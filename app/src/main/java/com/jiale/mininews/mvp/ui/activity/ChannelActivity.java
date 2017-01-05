package com.jiale.mininews.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jiale.mininews.R;
import com.jiale.mininews.adapter.AbsAdapter;
import com.jiale.mininews.adapter.ChannelAdapter;
import com.jiale.mininews.bean.ChannelBean;
import com.jiale.mininews.mvp.presenter.ChannelPresenterImpl;
import com.jiale.mininews.mvp.view.IChannelView;
import com.jiale.mininews.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Karlo on 2016/12/13.
 */

public class ChannelActivity extends BaseActivity implements IChannelView {
    private static final String TAG = "ChannelActivity";
    @BindView(R.id.channel_btn_ed)
    Button channelBtnEd;
    @BindView(R.id.channel_recyclerview_selected)
    RecyclerView channelRecyclerviewSelected;
    @BindView(R.id.channel_recyclerview_unselect)
    RecyclerView channelRecyclerviewUnselect;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ChannelPresenterImpl channelPresenter;
    private ChannelAdapter selectAdapter;
    private ChannelAdapter unSelectAdapter;
    private List<ChannelBean> selectData;
    private List<ChannelBean> unSelectData;

    @Override
    public int getLayoutId() {
        return R.layout.activity_channel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initEvent() {
        selectAdapter.setListener(new AbsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(AbsAdapter.CommonViewHolder holder) {
                if (selectAdapter.getMode() == ChannelAdapter.EDIT) {
                    int layoutPosition = holder.getLayoutPosition();
                    if (layoutPosition == 0) {
                        return;
                    }
                    ChannelBean channelBean = selectAdapter.removeItem(layoutPosition);
                    channelBean.setSelect(false);
                    channelPresenter.saveChannel(channelBean);
                    unSelectAdapter.addItem(channelBean);
                }
            }
        });
        unSelectAdapter.setListener(new AbsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(AbsAdapter.CommonViewHolder holder) {
                changeEdit(true);
                int layoutPosition = holder.getLayoutPosition();
                ChannelBean channelBean = unSelectAdapter.removeItem(layoutPosition);
                channelBean.setSelect(true);
                channelPresenter.saveChannel(channelBean);
                selectAdapter.addItem(channelBean);
                selectAdapter.setMode(ChannelAdapter.EDIT);
                selectAdapter.setChannelState(true);
            }
        });
        channelBtnEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectAdapter.getMode() == ChannelAdapter.EDIT) {
                    changeEdit(false);
                    selectAdapter.setChannelState(false);
                    selectAdapter.setMode(ChannelAdapter.NORMAL);
                } else {
                    changeEdit(true);
                    selectAdapter.setMode(ChannelAdapter.EDIT);
                    selectAdapter.setChannelState(true);
                }
            }
        });
    }

    @Override
    protected void initData() {
        LogUtil.i(TAG, "initData");
        selectData = new ArrayList<>();
        unSelectData = new ArrayList<>();
        selectAdapter = new ChannelAdapter(this, selectData, false, R.layout.activity_channel_recyclercview_item);
        unSelectAdapter = new ChannelAdapter(this, unSelectData, false, R.layout.activity_channel_recyclercview_item);
        channelPresenter = new ChannelPresenterImpl(this, this);
        channelPresenter.getChannel();
    }

    @Override
    protected void initViews() {
        LogUtil.i(TAG, "initViews");
        channelPresenter = new ChannelPresenterImpl(this, this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        channelRecyclerviewSelected.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        channelRecyclerviewUnselect.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        channelRecyclerviewUnselect.setAdapter(unSelectAdapter);
        channelRecyclerviewSelected.setAdapter(selectAdapter);
    }

    @Override
    public void showProgress() {
        LogUtil.i(TAG, "showProgress");
    }

    @Override
    public void hideProgress() {
        LogUtil.i(TAG, "hideProgress");
    }


    private void changeEdit(boolean flag) {
        if (flag) {
            channelBtnEd.setText("完成");
        } else {
            channelBtnEd.setText("编辑");
        }
    }

    @Override
    public void getChannelSuccess(int DataType, List<ChannelBean> list) {
        LogUtil.i(TAG, "loadSuccess");
        if (DataType == ChannelPresenterImpl.TYPE_SELECT) {
            selectData.addAll(list);
        } else if (DataType == ChannelPresenterImpl.TYPE_UNSELECT) {
            unSelectData.addAll(list);
        }
        selectAdapter.notifyDataSetChanged();
        unSelectAdapter.notifyDataSetChanged();
    }

    @Override
    public void getChannelError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        LogUtil.i(TAG, "loadError");
    }


    @Override
    public void finish() {
//        unSelectData.addAll(selectData);
        Intent intent = getIntent();
//        intent.putParcelableArrayListExtra("channel", (ArrayList<? extends Parcelable>) selectData);
        setResult(1, intent);
        super.finish();
    }
}
