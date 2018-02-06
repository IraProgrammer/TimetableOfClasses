package ru.startandroid.timetableofclasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 12.11.2017.
 */

public class AdminListItem {
    String id;
    String name;
    String request;
    Boolean box;

    public AdminListItem(String id, String name, String request, boolean box){
        this.id = id;
        this.name = name;
        this.request = request;
        this.box = box;
    }
}
