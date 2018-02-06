package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.startandroid.timetableofclasses.ForGSON.Request;

/**
 * Created by Irishka on 01.12.2017.
 */

public class RequestsForAdmin {

    @SerializedName("Заявки")
    @Expose
    private List<Request> requests = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestsForAdmin() {
    }

    /**
     *
     * @param requests
     */
    public RequestsForAdmin(List<Request> requests) {
        super();
        this.requests = requests;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

}
