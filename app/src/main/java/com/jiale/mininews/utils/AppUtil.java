package com.jiale.mininews.utils;

import com.jiale.mininews.App;

/**
 * Created by Karlo on 2016/12/15.
 */

public class AppUtil {

    public static int getWindowWidth() {
        return App.getInstance().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getWindowHeight() {
        return App.getInstance().getResources().getDisplayMetrics().heightPixels;
    }
}
