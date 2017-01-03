package com.evolution.promedan.promedanmob.ApiREST;

import retrofit.http.GET;
import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by LUISM on 28/12/2016.
 */

public interface Service {

    @GET("usuario.json")
    Call<Response> getUsuariolist();

    @POST("/Retrofit-Prueba/insert.php")
    Call<Response> setUsuariolist();
}
