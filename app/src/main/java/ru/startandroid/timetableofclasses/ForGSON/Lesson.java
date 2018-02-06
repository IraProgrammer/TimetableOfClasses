package ru.startandroid.timetableofclasses.ForGSON;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lesson {

    @SerializedName("Аудитория")
    @Expose
    private String _class;
    @SerializedName("Группы")
    @Expose
    private List<String> groups = null;
    @SerializedName("День")
    @Expose
    private Integer day;
    @SerializedName("Заканчивается на")
    @Expose
    private Integer end;
    @SerializedName("Название")
    @Expose
    private String name;
    @SerializedName("Начинается с")
    @Expose
    private Object start;
    @SerializedName("Номер")
    @Expose
    private Integer number;
    @SerializedName("Тип")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public Lesson() {
    }

    /**
     *
     * @param _class
     * @param start
     * @param name
     * @param number
     * @param day
     * @param type
     * @param end
     * @param groups
     */
    public Lesson(String _class, List<String> groups, Integer day, Integer end, String name, Object start, Integer number, String type) {
        super();
        this._class = _class;
        this.groups = groups;
        this.day = day;
        this.end = end;
        this.name = name;
        this.start = start;
        this.number = number;
        this.type = type;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}