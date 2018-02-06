package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 01.12.2017.
 */

public class Token {

    @SerializedName("Токен")
    @Expose
    private String token;

    /**
     * No args constructor for use in serialization
     *
     */
    public Token() {
    }

    /**
     *
     * @param token
     */
    public Token(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}