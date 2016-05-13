package com.donkamillo.gameslist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.donkamillo.gameslist.R;
import com.donkamillo.gameslist.ui.fragment.GameDetailsFragment;
import com.donkamillo.gameslist.ui.fragment.GamesListFragment;
import com.donkamillo.gameslist.ui.model.GameModel;
import com.donkamillo.gameslist.ui.presenter.GamesListPresenter;

public class MainActivity extends AppCompatActivity implements MainView, GamesListFragment.OnItemSelectedListener {
    private boolean isTwoPane = false;
    private GamesListPresenter gamesListPresenter;
    private GamesListFragment gamesListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        determinePaneLayout();
        initPresenter();

    }

    @Override
    protected void onResume() {
        super.onResume();
        gamesListPresenter.getGames();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gamesListPresenter.onStop();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(GameModel item) {
        if (isTwoPane) { // single activity with list and detail
            // Replace frame layout with correct detail fragment
            GameDetailsFragment fragmentItem = GameDetailsFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItem);
            ft.commit();
        } else { // separate activities
            // launch detail activity using intent
            Intent i = new Intent(this, GameDetailsActivity.class);
            i.putExtra("item", item);
            startActivity(i);
        }
    }

    private void initPresenter() {
        gamesListPresenter = new GamesListPresenter();
        gamesListPresenter.attachView(this, this, gamesListFragment);
    }

    private void determinePaneLayout() {
        FragmentManager fm = getSupportFragmentManager();
        gamesListFragment = (GamesListFragment) fm.findFragmentById(R.id.games_list);

        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.flDetailContainer);
        if (fragmentItemDetail != null) {
            isTwoPane = true;
        }
    }

}
