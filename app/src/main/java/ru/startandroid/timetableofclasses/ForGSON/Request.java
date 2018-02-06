package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 01.12.2017.
 */

public class Request {

    @SerializedName("Заявка")
    @Expose
    private String request;
    @SerializedName("Имя")
    @Expose
    private String name;
    @SerializedName("Идентификатор")
    @Expose
    private Integer id;
    @SerializedName("Логин")
    @Expose
    private String login;
    @SerializedName("Статус")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     *
     */
    public Request() {
    }

    /**
     *
     * @param id
     * @param status
     * @param name
     * @param request
     * @param login
     */
    public Request(String request, String name, Integer id, String login, String status) {
        super();
        this.request = request;
        this.name = name;
        this.id = id;
        this.login = login;
        this.status = status;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}