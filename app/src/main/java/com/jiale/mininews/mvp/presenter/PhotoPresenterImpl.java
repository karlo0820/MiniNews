package com.jiale.mininews.mvp.presenter;

import com.jiale.mininews.apis.ApiConstans;
import com.jiale.mininews.bean.PhotoBean;
import com.jiale.mininews.mvp.listener.onLoadListener;
import com.jiale.mininews.mvp.listener.onLoadTypeListener;
import com.jiale.mininews.mvp.model.PhotoModelImpl;
import com.jiale.mininews.mvp.presenter.interfaces.PhotoPresenter;
import com.jiale.mininews.mvp.view.IPhotoView;

import java.util.List;

/**
 * Created by Karlo on 2016/12/17.
 */
public class PhotoPresenterImpl implements PhotoPresenter, onLoadTypeListener<List<PhotoBean>> {
    private IPhotoView iPhotoView;
    private PhotoModelImpl photoModel;
    private static final int count = 20;
    private int page = 1;

    public PhotoPresenterImpl(IPhotoView iPhotoView) {
        this.iPhotoView = iPhotoView;
        photoModel = new PhotoModelImpl();
    }

    @Override
    public void loadData(int type) {
        iPhotoView.showProgress();
        if (type == ApiConstans.MORE) {
            page++;
        }
        photoModel.loadPhotoList(type, count, page, this);
    }

    @Override
    public void loadSuccess(int type, List<PhotoBean> photoBeen) {
        iPhotoView.hideProgress();
        iPhotoView.loadPhotoList(type, photoBeen);
    }

    @Override
    public void loadError(int type, String msg) {
        if (type == ApiConstans.MORE) {
            page--;
        }
        iPhotoView.hideProgress();
        iPhotoView.loadFail(type, msg);
    }
}
