package com.donkamillo.gameslist.services;

import java.util.List;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public class KonzeptualResponse {

    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public class Game {
        private String sbName;
        private String commercialName;
        private float rating;
        private String image;
        private String icon;
        private String description;

        public String getSbName() {
            return sbName;
        }

        public String getCommercialName() {
            return commercialName;
        }

        public float getRating() {
            return rating;
        }

        public String getImage() {
            return image;
        }

        public String getIcon() {
            return icon;
        }

        public String getDescription() {
            return description;
        }
    }

}
