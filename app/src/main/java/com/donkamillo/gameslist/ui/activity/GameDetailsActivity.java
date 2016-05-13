package com.donkamillo.gameslist.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.donkamillo.gameslist.R;
import com.donkamillo.gameslist.ui.fragment.GameDetailsFragment;
import com.donkamillo.gameslist.ui.model.GameModel;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public class GameDetailsActivity extends AppCompatActivity {
    private GameDetailsFragment fragmentItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_details_activity);
        GameModel item = (GameModel) getIntent().getSerializableExtra("item");
        if (savedInstanceState == null) {
            fragmentItemDetail = GameDetailsFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItemDetail);
            ft.commit();
        }
    }


}
