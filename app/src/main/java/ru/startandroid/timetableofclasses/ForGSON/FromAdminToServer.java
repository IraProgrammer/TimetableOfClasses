package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.startandroid.timetableofclasses.ForGSON.Answer;

/**
 * Created by Irishka on 01.12.2017.
 */

public class FromAdminToServer {

    @SerializedName("Токен")
    @Expose
    private String token;
    @SerializedName("Вердикт")
    @Expose
    private Answer answer;

    /**
     * No args constructor for use in serialization
     *
     */
    public FromAdminToServer() {
    }

    /**
     *
     * @param token
     * @param answer
     */
    public FromAdminToServer(String token, Answer answer) {
        super();
        this.token = token;
        this.answer = answer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

}