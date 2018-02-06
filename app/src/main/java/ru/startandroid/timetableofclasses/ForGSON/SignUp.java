package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 12.11.2017.
 */

public class SignUp {

    @SerializedName("Логин")
    @Expose
    private String login;
    @SerializedName("Пароль")
    @Expose
    private String password;
    @SerializedName("Заявка")
    @Expose
    private String message;
    @SerializedName("Имя")
    @Expose
    private String name;
    @SerializedName("Статус")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     *
     */
    public SignUp() {
    }

    /**
     *
     * @param message
     * @param status
     * @param name
     * @param login
     * @param password
     */
    public SignUp(String message, String status, String name, String login, String password) {
        super();
        this.login = login;
        this.password = password;
        this.message = message;
        this.name = name;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
