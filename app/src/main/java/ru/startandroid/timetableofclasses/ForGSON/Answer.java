package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 01.12.2017.
 */

public class Answer {

    @SerializedName("1")
    @Expose
    private String _1;
    @SerializedName("2")
    @Expose
    private String _2;

    /**
     * No args constructor for use in serialization
     *
     */
    public Answer() {
    }

    /**
     *
     * @param _1
     * @param _2
     */
    public Answer(String _1, String _2) {
        super();
        this._1 = _1;
        this._2 = _2;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

}