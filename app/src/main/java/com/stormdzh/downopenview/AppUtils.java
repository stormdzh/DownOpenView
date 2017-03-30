package com.stormdzh.downopenview;

import android.content.Context;

/**
 * Created by Administrator on 2017/3/30.
 */
public class AppUtils {
    /**
     * 把密度转换为像素
     */
    public static int dp2px(Context context, float px) {
        final float scale = getScreenDensity(context);
        return (int) (px * scale + 0.5);
    }

    /**
     * 得到设备的密度
     */
    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }
}
