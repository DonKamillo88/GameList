package com.donkamillo.gameslist.ui.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donkamillo.gameslist.R;
import com.donkamillo.gameslist.ui.model.GameModel;
import com.donkamillo.gameslist.ui.utils.Utils;

import java.util.List;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public class GamesListFragment extends Fragment implements GamesListView {
    private OnItemSelectedListener listener;
    private GamesCardsAdapter adapter;

    public interface OnItemSelectedListener {
        void onItemSelected(GameModel i);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.games_list_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_view);


        if (Utils.isTablet((AppCompatActivity) getContext())) {
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(llm);
        } else {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                StaggeredGridLayoutManager gridLayoutManager =
                        new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

                recyclerView.setLayoutManager(gridLayoutManager);
            } else {
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager llm = new LinearLayoutManager(getContext());
                llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(llm);
            }
        }

        adapter = new GamesCardsAdapter(getContext(), new GamesCardsAdapter.GameCardsInterface() {
            @Override
            public void onItemClick(GameModel game) {
                listener.onItemSelected(game);
            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void showGames(List<GameModel> games) {
        adapter.swapItems(games);
    }

}