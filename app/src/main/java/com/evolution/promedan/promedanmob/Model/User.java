package com.evolution.promedan.promedanmob.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LUISM on 27/12/2016.
 */

public class User {
    @SerializedName("name")

    private String name;
    @SerializedName("email")

    private String email;
    @SerializedName("unique_id")

    private String unique_id;
    @SerializedName("password")

    private String password;
    @SerializedName("old_password")

    private String old_password;
    @SerializedName("new_password")

    private String new_password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
}
