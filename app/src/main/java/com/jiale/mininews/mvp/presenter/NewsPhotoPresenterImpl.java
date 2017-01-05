package com.jiale.mininews.mvp.presenter;

import com.jiale.mininews.bean.NewsPhotoBean;
import com.jiale.mininews.mvp.listener.onLoadListener;
import com.jiale.mininews.mvp.model.NewsPhotoModelImpl;
import com.jiale.mininews.mvp.presenter.interfaces.NewsPhotoPresenter;
import com.jiale.mininews.mvp.view.INewsPhotoSetView;

/**
 * Created by Karlo on 2016/12/15.
 */
public class NewsPhotoPresenterImpl implements NewsPhotoPresenter, onLoadListener<NewsPhotoBean> {
    private INewsPhotoSetView newsPhotoSetView;
    private NewsPhotoModelImpl newsPhotoModel;

    public NewsPhotoPresenterImpl(INewsPhotoSetView newsPhotoSetView) {
        this.newsPhotoSetView = newsPhotoSetView;
        newsPhotoModel = new NewsPhotoModelImpl();
    }

    @Override
    public void getPhotoData(String skipId_1, String skipId_2) {
        newsPhotoSetView.showProgress();
        newsPhotoModel.getPhotoSet(skipId_1, skipId_2, this);
    }

    @Override
    public void loadSuccess(NewsPhotoBean newsPhotoBean) {
        newsPhotoSetView.hideProgress();
        newsPhotoSetView.initPhotoSetSuccess(newsPhotoBean);
    }

    @Override
    public void loadFail(String msg) {
        newsPhotoSetView.hideProgress();
        newsPhotoSetView.initPhotoSetFail(msg);

    }
}
