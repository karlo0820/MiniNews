package com.jiale.mininews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

import static android.R.attr.value;

/**
 * Created by Karlo on 2016/12/13.
 */

public class SharedUtil {
    private static final String SHARED_NAME = "MiniNews";
    private static SharedPreferences instance;

    private static void initShared(Context context) {
        if (instance == null) {
            instance = context.getSharedPreferences("name", Context.MODE_PRIVATE);
        }
    }

    public static void saveString(Context context, String key, String value) {
        initShared(context);
        instance.edit().putString(key, value).apply();
    }

    public static void savaInt(Context context, String key, int value) {
        initShared(context);
        instance.edit().putInt(key, value).apply();
    }

    public static String getString(Context context, String key) {
        initShared(context);
        return instance.getString(key, null);
    }

    public static int getInt(Context context, String key) {
        initShared(context);
        return instance.getInt(key, -1);
    }

    public static void saveBoolean(Context context, String key, Boolean value) {
        initShared(context);
        instance.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(Context context, String key) {
        initShared(context);
        return instance.getBoolean(key, true);
    }
}
