package com.jiale.mininews.mvp.view;

import com.jiale.mininews.bean.PhotoBean;

import java.util.List;

import static android.R.id.list;

/**
 * Created by Karlo on 2016/12/17.
 */

public interface IPhotoView extends IBaseView {
    void loadPhotoList(int type, List<PhotoBean> list);
    void loadFail(int type, String msg);
}
