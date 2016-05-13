package com.donkamillo.gameslist.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.donkamillo.gameslist.ui.model.GameModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class SharedPreferencesManager {

    private static final String HISTORY_DATA = "history_data";
    private static final String DOWNLOAD_DATA_DATE = "download_data_date";

    static public void saveHistoryData(List<GameModel> list, Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();

        String json = gson.toJson(list);

        editor.putString(HISTORY_DATA, json);
        editor.apply();
    }

    static public List<GameModel> loadHistoryData(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPrefs.getString(HISTORY_DATA, null);
        Type type = new TypeToken<ArrayList<GameModel>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    static public void saveDownloadDataDate(long date, Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putLong(DOWNLOAD_DATA_DATE, date);
        editor.apply();
    }

    static public Long loadDownloadDataDate(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPrefs.getLong(DOWNLOAD_DATA_DATE, 0);
    }
}
