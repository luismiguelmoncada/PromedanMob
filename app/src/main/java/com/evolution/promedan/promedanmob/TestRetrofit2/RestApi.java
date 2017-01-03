package com.evolution.promedan.promedanmob.TestRetrofit2;

import com.evolution.promedan.promedanmob.Model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LUISM on 30/12/2016.
 */

public interface RestApi {

    @GET("/Retrofit-Prueba/getData.php")
    Call<List<UsuarioTest>> getUsers();
}
