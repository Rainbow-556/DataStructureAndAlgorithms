package com.datastructureandalgorithms.app.util;

import android.util.Log;

/**
 * Created by lixiang on 2018/5/30.
 */
public final class FLogger {
    private static final String TAG = "lxmsg";

    public static void msg(Object msg) {
        Log.d(TAG, String.valueOf(msg));
    }

    public static void w(Object msg) {
        Log.w(TAG, String.valueOf(msg));
    }

    public static void e(Object msg) {
        Log.e(TAG, String.valueOf(msg));
    }

    public static void i(Object msg) {
        Log.i(TAG, String.valueOf(msg));
    }
}
