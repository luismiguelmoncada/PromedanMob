package com.evolution.promedan.promedanmob.view.Login_Registre;

import com.evolution.promedan.promedanmob.Model.ServerRequest;
import com.evolution.promedan.promedanmob.Model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by LUISM on 27/12/2016.
 */

public interface RequestInterface {
    @POST("Retrofit-Prueba/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
