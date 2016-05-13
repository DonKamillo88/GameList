package com.donkamillo.gameslist.ui.utils;

import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

/**
 * Created by DonKamillo on 12.05.2016.
 */
public class Utils {

    public static boolean isTablet(AppCompatActivity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        float scaleFactor = metrics.density;
        float widthDp = widthPixels / scaleFactor;
        return widthDp >= 600;
    }
}
