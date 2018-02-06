package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.SerializedName;

import static ru.startandroid.timetableofclasses.RegistrationActivity.token;

/**
 * Created by Irishka on 12.11.2017.
 */

public class SignIn {
    @SerializedName("Логин")
    String login;
    @SerializedName("Пароль")
    String password;

    public SignIn(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String token) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String status) {
        this.password = password;
    }

}
