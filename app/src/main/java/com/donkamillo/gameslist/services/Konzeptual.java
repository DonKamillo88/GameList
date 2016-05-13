package com.donkamillo.gameslist.services;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public interface Konzeptual {

    @GET("/sb/gamesDetail.json")
    Call<KonzeptualResponse> getData();
}
