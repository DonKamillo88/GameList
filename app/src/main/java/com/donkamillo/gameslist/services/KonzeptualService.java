package com.donkamillo.gameslist.services;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by DonKamillo on 11.05.2016.
 */
public class KonzeptualService {

    private static final String API_URL = "http://www.konzeptual.es";

    public static Konzeptual getService() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Konzeptual.class);
    }
}
