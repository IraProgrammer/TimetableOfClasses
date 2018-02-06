package ru.startandroid.timetableofclasses.ForGSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Irishka on 29.11.2017.
 */

public class TeachersList {
    @SerializedName("Преподаватели")
    @Expose
    private String[] teachers = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public TeachersList() {
    }

    /**
     *
     * @param teachers
     */
    public TeachersList(String[] teachers) {
        super();
        this.teachers = teachers;
    }

    public String[] getTeachers() {
        return teachers;
    }

    public void setTeachers(String[] teachers) {
        this.teachers = teachers;
    }
}
