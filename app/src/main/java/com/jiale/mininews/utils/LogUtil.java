package com.jiale.mininews.utils;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Log工具类
 * Created by Karlo on 2016/12/12.
 */

public class LogUtil {
    private static final boolean DEBUG = true;

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.i("google.karlo", tag + ":" + msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.i("google.karlo", tag + ":" + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i("google.karlo", tag + ":" + msg);
        }
    }
}
