package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 01.12.2017.
 */

public class StatusForSignUp{

    @SerializedName("Статус")
    @Expose
    private String status;
    @SerializedName("Подробности")
    @Expose
    private String more;


public StatusForSignUp() {
        }

/**
 *
 * @param more
 * @param status
 */
public StatusForSignUp(String status, String more) {
        super();
        this.status = status;
        this.more = more;
        }

public String getStatus() {
        return status;
        }

public void setStatus(String status) {
        this.status = status;
        }

public String getMore() {
        return more;
        }

public void setMore(String more) {
        this.more = more;
        }

        }