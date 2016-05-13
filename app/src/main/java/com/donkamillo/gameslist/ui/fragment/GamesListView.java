package com.donkamillo.gameslist.ui.fragment;

import com.donkamillo.gameslist.ui.model.GameModel;

import java.util.List;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public interface GamesListView {

    void showGames(List<GameModel> gameModels);
}
