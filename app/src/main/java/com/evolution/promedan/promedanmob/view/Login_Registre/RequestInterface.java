package com.evolution.promedan.promedanmob.view.Login_Registre;

import com.evolution.promedan.promedanmob.Model.ServerRequest;
import com.evolution.promedan.promedanmob.Model.ServerResponse;
import com.evolution.promedan.promedanmob.Model.User;
import com.evolution.promedan.promedanmob.Model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by LUISM on 27/12/2016.
 */

public interface RequestInterface {
    @POST("/api/retrofit_users")
    Call<Usuario> CrearUsuario(@Body Usuario user);

}
