package com.donkamillo.gameslist.ui.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.donkamillo.gameslist.R;
import com.donkamillo.gameslist.ui.model.GameModel;

import java.util.List;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public class GamesCardsAdapter extends RecyclerView.Adapter<GamesCardsAdapter.GamesViewHolder> {

    public interface GameCardsInterface {
        void onItemClick(GameModel game);
    }

    private GameCardsInterface gameCardsInterface;
    private List<GameModel> games;
    private Context context;

    public GamesCardsAdapter(Context context, GameCardsInterface gameCardsInterface) {
        this.gameCardsInterface = gameCardsInterface;
        this.context = context;
    }

    public void swapItems(List<GameModel> games) {
        this.games = games;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (games == null) return 0;
        return games.size();
    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int i) {
        GameModel game = games.get(i);

        holder.title.setText(game.getCommercialName());
        holder.showGameImage(game.getImage());
        holder.setOnClickListener(game);

    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.games_list_item, viewGroup, false);

        return new GamesViewHolder(itemView);
    }


    public class GamesViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public GamesViewHolder(View v) {
            super(v);

            image = (ImageView) v.findViewById((R.id.image));
            title = (TextView) v.findViewById(R.id.title);

        }

        public void showGameImage(String imageUrl) {

            Glide.with(context)
                    .load(imageUrl)
                    .into(image);
        }

        private void setOnClickListener(final GameModel game) {
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gameCardsInterface.onItemClick(game);
                }
            });

        }

    }


}
