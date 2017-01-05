package com.jiale.mininews.mvp.presenter;

import com.jiale.mininews.apis.ApiConstans;
import com.jiale.mininews.bean.NewsBean;
import com.jiale.mininews.mvp.model.NewsListModelImpl;
import com.jiale.mininews.mvp.presenter.interfaces.NewsListPresenter;
import com.jiale.mininews.mvp.view.INewsListView;

import java.util.List;

/**
 * Created by Karlo on 2016/12/12.
 */

public class NewsListPresenterImpl implements NewsListPresenter<List<NewsBean>> {
    private INewsListView iNewsListView;
    private NewsListModelImpl newsMode;
    private static int page = 0;

    public NewsListPresenterImpl(INewsListView iNewsListView) {
        this.iNewsListView = iNewsListView;
        newsMode = new NewsListModelImpl(this);
    }

    @Override
    public void loadSuccess(int requestType, List<NewsBean> NewsBean) {
        iNewsListView.hideProgress();
        iNewsListView.loadSuccess(requestType, NewsBean);
    }

    @Override
    public void loadError(int requestType, String msg) {
        iNewsListView.hideProgress();
        iNewsListView.loadError(requestType, msg);
        page -= 20;
    }

    @Override
    public void loadData(int requestType, String id) {
        if (requestType == ApiConstans.MORE) {
            page += 20;
        } else {
            page = 0;
        }
        iNewsListView.showProgress();
        newsMode.loadData(requestType, id, page);
    }
}
