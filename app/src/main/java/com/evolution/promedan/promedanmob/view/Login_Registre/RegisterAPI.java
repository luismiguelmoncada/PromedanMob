package com.evolution.promedan.promedanmob.view.Login_Registre;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by LUISM on 27/12/2016.
 */

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/Retrofit-Prueba/insert.php")
    public void insertUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            Callback<Response> callback);
}
