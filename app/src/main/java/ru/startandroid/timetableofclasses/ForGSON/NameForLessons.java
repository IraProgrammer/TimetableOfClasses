package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Irishka on 29.11.2017.
 */

public class NameForLessons {
    @SerializedName("Имя")
   // @Expose
    public String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public NameForLessons() {
    }

    /**
     *
     * @param name
     */
    public NameForLessons(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


