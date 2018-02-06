package ru.startandroid.timetableofclasses;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static android.R.attr.key;
import static ru.startandroid.timetableofclasses.GuestActivity.nameL;
import static ru.startandroid.timetableofclasses.R.id.datePicker;

public class DateActivity extends Activity {

   public static int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
    }

    public void onClickDate(View v) {
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

        int yearForWeek = datePicker.getYear();
        int monthForWeek = datePicker.getMonth();
        int dayForWeek = datePicker.getDayOfMonth();

        MyCalendar calendar = new MyCalendar();

        day = calendar.getDay(yearForWeek, monthForWeek, dayForWeek);

        if (day == 6 || day == 13) {
            Toast.makeText(getBaseContext(), "В воскресенье нет пар. Выберите другой день.", Toast.LENGTH_SHORT).show();
        }

        else {
            Intent intent1 = new Intent(this, LessonsActivity.class);
            startActivity(intent1);
        }
        }
    }