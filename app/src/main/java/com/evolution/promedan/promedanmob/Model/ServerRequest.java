package com.evolution.promedan.promedanmob.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LUISM on 27/12/2016.
 */

public class ServerRequest {

    @SerializedName("operation")

    private String operation;

    @SerializedName("user")

    private Usuario user;
    public ServerRequest(){

    }

    public ServerRequest(String operation, Usuario user) {
        this.operation = operation;
        this.user = user;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
