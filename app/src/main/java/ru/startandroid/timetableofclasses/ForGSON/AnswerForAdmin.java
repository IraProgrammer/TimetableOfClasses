package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 02.12.2017.
 */

public class AnswerForAdmin {

    @SerializedName("Результат")
    @Expose
    private String result;
    @SerializedName("Подробности")
    @Expose
    private String more;

    /**
     * No args constructor for use in serialization
     *
     */
    public AnswerForAdmin() {
    }

    /**
     *
     * @param result
     * @param more
     */
    public AnswerForAdmin(String result, String more) {
        super();
        this.more = more;
        this.result = result;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}

