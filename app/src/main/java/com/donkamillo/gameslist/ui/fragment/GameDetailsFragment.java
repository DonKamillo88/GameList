package com.donkamillo.gameslist.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.donkamillo.gameslist.R;
import com.donkamillo.gameslist.ui.model.GameModel;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public class GameDetailsFragment extends Fragment {
    private static final String GAME_ARG = "game_arg";
    private GameModel game;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = (GameModel) getArguments().getSerializable(GAME_ARG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_details_fragment, parent, false);
        TextView tvName = (TextView) view.findViewById(R.id.name);
        TextView tvRating = (TextView) view.findViewById(R.id.rating);
        TextView tvDescription = (TextView) view.findViewById(R.id.description);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        tvName.setText(game.getCommercialName());
        tvRating.setText(game.getRating() + "");
        tvDescription.setText(game.getDescription());


        Glide.with(this)
                .load(game.getIcon())
                .into(icon);

        return view;
    }

    public static GameDetailsFragment newInstance(GameModel game) {
        GameDetailsFragment detailsFragment = new GameDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(GAME_ARG, game);
        detailsFragment.setArguments(args);
        return detailsFragment;
    }

}
