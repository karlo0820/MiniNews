package com.jiale.mininews.mvp.view;

import com.jiale.mininews.bean.NewsPhotoBean;


/**
 * Created by Karlo on 2016/12/15.
 */

public interface INewsPhotoSetView extends IBaseView {
    void initPhotoSetSuccess(NewsPhotoBean newsPhotoBean);

    void initPhotoSetFail(String msg);
}
