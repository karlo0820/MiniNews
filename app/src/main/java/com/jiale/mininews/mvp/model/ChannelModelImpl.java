package com.jiale.mininews.mvp.model;

import android.content.Context;

import com.jiale.mininews.R;
import com.jiale.mininews.bean.ChannelBean;
import com.jiale.mininews.mvp.listener.onLoadChannelListener;
import com.jiale.mininews.utils.SharedUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karlo on 2016/12/13.
 */
public class ChannelModelImpl implements ChannelModel<ChannelBean> {

    @Override
    public void getChannelList(final Context context, final onLoadChannelListener<ChannelBean> listener) {
                    String[] arrNames = context.getResources().getStringArray(R.array.netease_tabs);
                    String[] arrIds = context.getResources().getStringArray(R.array.netease_tabs_id);
                    List<ChannelBean> selects = new ArrayList<>();
                    List<ChannelBean> unSelects = new ArrayList<>();
                    for (int i = 0; i < arrNames.length; i++) {
                        String name = arrNames[i];
                        ChannelBean bean = new ChannelBean();
                        bean.setName(name);
                        bean.setIndex(i);
                        bean.setChannelId(arrIds[i]);

                        boolean select = SharedUtil.getBoolean(context, name);
                        bean.setSelect(select);
                        if (select) {
                            selects.add(bean);
                        } else {
                            unSelects.add(bean);
                        }
                    }
                    if (listener != null) {
                        listener.loadSelectSuccess(selects);
                        listener.loadUnSelectSuccess(unSelects);
                    }
    }

    @Override
    public void saveChannel(final Context context, final ChannelBean bean) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                    SharedUtil.saveBoolean(context, bean.getName(), bean.getSelect());
            }
        }).start();
    }

}
