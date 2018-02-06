package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 01.12.2017.
 */

public class Status {

    @SerializedName("Имя")
    @Expose
    private String name;
    @SerializedName("Токен")
    @Expose
    private String token;
    @SerializedName("Статус")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     *
     */
    public Status() {
    }

    /**
     *
     * @param status
     * @param token
     */
    public Status(String name, String status, String token) {
        super();
        this.name = name;
        this.token = token;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}