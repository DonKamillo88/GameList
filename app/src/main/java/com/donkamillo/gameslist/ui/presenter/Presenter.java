package com.donkamillo.gameslist.ui.presenter;

import android.content.Context;

import com.donkamillo.gameslist.ui.activity.MainView;
import com.donkamillo.gameslist.ui.fragment.GamesListView;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public interface Presenter {

    void attachView(Context context, MainView mainView, GamesListView gamesListView);

    void onStop();

}
