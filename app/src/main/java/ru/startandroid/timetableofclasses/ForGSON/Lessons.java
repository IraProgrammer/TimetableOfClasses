package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Irishka on 29.11.2017.
 */

public class Lessons {
    @SerializedName("Пары")
    @Expose
    private List<Lesson> lessons = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Lessons() {
    }

    /**
     *
     * @param lessons
     */
    public Lessons(List<Lesson> lessons) {
        super();
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

}
