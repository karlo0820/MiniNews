package com.jiale.mininews.mvp.listener;


/**
 * 数据下载监听接口
 * Created by Karlo on 2016/12/12.
 */
public interface onLoadTypeListener<T> {
    /**
     * 请求成功回调
     * @param type 请求类型
     * @param t 请求结果
     */
    void loadSuccess(int type, T t);

    /**
     *  请求失败回调
     * @param type  请求类型
     * @param msg 失败信息
     */
    void loadError(int type, String msg);
}
