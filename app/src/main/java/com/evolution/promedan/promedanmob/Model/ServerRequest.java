package com.evolution.promedan.promedanmob.Model;

/**
 * Created by LUISM on 27/12/2016.
 */

public class ServerRequest {
    private String operation;
    private User user;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
