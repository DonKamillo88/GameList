package com.donkamillo.gameslist.ui.model;

import java.io.Serializable;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public class GameModel implements Serializable {
    private static final long serialVersionUID = -6099312954099962806L;

    private String sbName;
    private String commercialName;
    private double rating;
    private String image;
    private String icon;
    private String description;

    public GameModel(String sbName, String commercialName, double rating, String image, String icon, String description) {
        this.sbName = sbName;
        this.commercialName = commercialName;
        this.rating = rating;
        this.image = image;
        this.icon = icon;
        this.description = description;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
