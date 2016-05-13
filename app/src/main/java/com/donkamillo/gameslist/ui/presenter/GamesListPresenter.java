package com.donkamillo.gameslist.ui.presenter;

import android.content.Context;

import com.donkamillo.gameslist.services.Konzeptual;
import com.donkamillo.gameslist.services.KonzeptualResponse;
import com.donkamillo.gameslist.services.KonzeptualService;
import com.donkamillo.gameslist.storage.SharedPreferencesManager;
import com.donkamillo.gameslist.ui.activity.MainView;
import com.donkamillo.gameslist.ui.fragment.GamesListView;
import com.donkamillo.gameslist.ui.model.GameModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public class GamesListPresenter implements Presenter, Callback<KonzeptualResponse> {
    private static final long DAY = 86400000;

    private Call<KonzeptualResponse> call;
    private MainView mainView;
    private Konzeptual konzeptual;
    private GamesListView gamesListView;
    private Context context;

    @Override
    public void onResponse(Response<KonzeptualResponse> response, Retrofit retrofit) {
        List<GameModel> games = new ArrayList<>();
        for (KonzeptualResponse.Game game : response.body().getGames()) {
            games.add(new GameModel(game.getSbName(), game.getCommercialName(), game.getRating(), game.getImage(), game.getIcon(), game.getDescription()));
        }

        SharedPreferencesManager.saveDownloadDataDate(new Date().getTime(), context);
        SharedPreferencesManager.saveHistoryData(games, context);

        gamesListView.showGames(games);
    }

    @Override
    public void onFailure(Throwable t) {
        mainView.showError(t.getLocalizedMessage());
    }

    @Override
    public void attachView(Context context, MainView mainView, GamesListView gamesListView) {
        this.mainView = mainView;
        this.gamesListView = gamesListView;
        this.context = context;
    }

    @Override
    public void onStop() {
        if (call != null)
            call.cancel();
    }

    /**
     * if the data has been downloaded earlier than 24 hours pulls from a network, otherwise  pull  from memory
     */
    public void getGames() {
        long today = new Date().getTime();
        long downloadDataDate = SharedPreferencesManager.loadDownloadDataDate(context);
        if (today - downloadDataDate > DAY) {
            callForGames();
        } else {
            gamesListView.showGames(SharedPreferencesManager.loadHistoryData(context));
        }
    }

    private void callForGames() {
        call = getKonzeptual().getData();
        call.enqueue(this);
    }


    private Konzeptual getKonzeptual() {
        if (konzeptual == null)
            konzeptual = KonzeptualService.getService();
        return konzeptual;
    }
}
