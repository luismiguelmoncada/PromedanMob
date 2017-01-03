package com.evolution.promedan.promedanmob.ApiREST;

import com.evolution.promedan.promedanmob.view.Login_Registre.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LUISM on 28/12/2016.
 */

public class Client {

    private Retrofit retrofit;
    private final static String SERVER_BASE_URL="http://webserverandroid.site88.net/";

    public Client(Retrofit retrofit){

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Response.class,new ResponseTypeAdapter())
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public Service getService(){
        return retrofit.create(Service.class);
    }
}
