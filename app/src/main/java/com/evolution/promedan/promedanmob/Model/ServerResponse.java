package com.evolution.promedan.promedanmob.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LUISM on 27/12/2016.
 */

public class ServerResponse {

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("mesaage")
    @Expose

    private String message;

    @SerializedName("user")
    @Expose
    private User user;


    public String getResult() {
        return result;
    }

    public String getMessage() {        return message;    }

    public User getUser() {
        return user;
    }
}
