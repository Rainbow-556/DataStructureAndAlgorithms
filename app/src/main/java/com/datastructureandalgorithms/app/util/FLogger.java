package com.datastructureandalgorithms.app.util;

import android.util.Log;

/**
 * Created by lixiang on 2018/5/30.
 */
public final class FLogger {
    public static void msg(Object msg) {
        Log.d("lxlogger", String.valueOf(msg));
    }
}
