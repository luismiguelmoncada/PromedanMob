package com.evolution.promedan.promedanmob.Model;

import android.widget.ImageView;

/**
 * Created by LUISM on 26/11/2016.
 */

public class Picture {

    private String usernameCard;
    private String firstWord;
    private String secondWord;
    private String imagen;

    public Picture(String usernameCard, String firstWord, String secondWord, String imagen) {
        this.usernameCard = usernameCard;
        this.firstWord = firstWord;
        this.secondWord = secondWord;
        this.imagen=imagen;
    }

    public String getUsernameCard() {
        return usernameCard;
    }

    public void setUsernameCard(String usernameCard) {
        this.usernameCard = usernameCard;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    //testjkh
}
