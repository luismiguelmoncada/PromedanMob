package com.evolution.promedan.promedanmob.TestRetrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LUISM on 30/12/2016.
 */

public class ApiClient {
    private static RestApi REST_CLIENT;
    //http://192.168.0.109:64432//api/retrofit_users
    private static final String API_URL = "http://webserverandroid.site88.net/";

    static {
        setupRestClient();
    }

    private ApiClient() {}

    public static RestApi get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        REST_CLIENT = retrofit.create(RestApi.class);
    }
}
