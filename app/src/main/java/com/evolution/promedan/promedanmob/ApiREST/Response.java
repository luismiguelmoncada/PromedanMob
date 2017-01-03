package com.evolution.promedan.promedanmob.ApiREST;

import com.evolution.promedan.promedanmob.Model.Usuario;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by LUISM on 28/12/2016.
 */

public class Response {

    @SerializedName("usuariolist")
    @Expose
    private ArrayList<Usuario> usuariolist = new ArrayList<>();

    public void setUsuariolist(ArrayList<Usuario> usuariolist){
        this.usuariolist = usuariolist;
    }

    public ArrayList<Usuario> getUsuariolist() {
        return usuariolist;
    }
}

