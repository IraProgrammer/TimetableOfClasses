package ru.startandroid.timetableofclasses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.startandroid.timetableofclasses.ForGSON.Lesson;
import ru.startandroid.timetableofclasses.ForGSON.Lessons;
import ru.startandroid.timetableofclasses.ForGSON.NameForLessons;
import ru.startandroid.timetableofclasses.ForGSON.TeachersList;

import static ru.startandroid.timetableofclasses.DateActivity.day;
import static ru.startandroid.timetableofclasses.GuestActivity.nameL;
import static ru.startandroid.timetableofclasses.MyCalendar.dayName;

public class LessonsActivity extends Activity {

    TextView timetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        timetable = (TextView) findViewById(R.id.textView21);
        timetable.setText(dayName);

        String key = nameL;
        Gson g = new Gson();
        NameForLessons name = new NameForLessons(key);
        String jKey = g.toJson(name);

        List<Lesson> lessonsList = App.getNetworkManager().getLessons(jKey);

        setTime(new Lesson(), lessonsList);

    }


    public void setTime(Lesson lesson, List<Lesson> lessons){
        String time = null;

        Map forTime = new HashMap<Integer, String>();
        forTime.put(1, "8:00\n9:30");
        forTime.put(2, "9:40\n11:10");
        forTime.put(3, "13:00\n14:30");
        forTime.put(4, "14:40\n16:10");
        forTime.put(5, "16:20\n17:50");
        forTime.put(6, "18:00\n19:30");
        forTime.put(7, "19:40\n21:10");

        for (int i = 0; i < lessons.size(); i++) {
            lesson = lessons.get(i);

            time = forTime.get(lesson.getNumber()).toString();

            if(lesson.getDay() == day) {
                addRow(time, lesson.getName() + "\n" + lesson.getType(), lesson.getClass_(), lesson.getGroups());
            }}
    }

    public void onClickChoose(View v){
        Intent intent = new Intent(this, DateActivity.class);
        startActivity(intent);
    }

    public void addRow(String time, String lesson, String aud, List<String> group) {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.table);

        int qGroup = group.size();
        String groups = "";
        for(int i = 0; i<qGroup; i++){
        groups += group.get(i) + "\n";
        }

        LayoutInflater inflater = LayoutInflater.from(this);

        TableRow tr = (TableRow) inflater.inflate(R.layout.row_for_lessons, null);

        TextView tv1 = (TextView) tr.findViewById(R.id.col1);

        tv1.setText(time);

        TextView tv2 = (TextView) tr.findViewById(R.id.col2);
        tv2.setText(lesson);

        TextView tv3 = (TextView) tr.findViewById(R.id.col3);
        tv3.setText(aud);

        TextView tv4 = (TextView) tr.findViewById(R.id.col4);
        tv4.setText(groups);

        tableLayout.addView(tr);

    }
}