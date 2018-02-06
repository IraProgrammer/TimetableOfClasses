package ru.startandroid.timetableofclasses;

import java.util.GregorianCalendar;

import static ru.startandroid.timetableofclasses.R.id.datePicker;

/**
 * Created by Irishka on 18.11.2017.
 */

public class MyCalendar {

    public static String dayName;

    public int getDay(int yearForWeek, int monthForWeek, int dayForWeek){

        GregorianCalendar cal = new GregorianCalendar(yearForWeek, monthForWeek, dayForWeek);

        int weekNumber = cal.get(GregorianCalendar.WEEK_OF_YEAR);

        int dayInNumber = cal.get(GregorianCalendar.DAY_OF_WEEK);
        int day = 0;

        if (weekNumber%2 != 0){
            if (dayInNumber == 2) {
                day = 0;
                dayName = "Пн, нечётная неделя";
            } else if (dayInNumber == 3) {
                day = 1;
                dayName = "Вт, нечётная неделя";
            } else if (dayInNumber == 4) {
                day = 2;
                dayName = "Ср, нечётная неделя";
            } else if (dayInNumber == 5) {
                day = 3;
                dayName = "Чт, нечётная неделя";
            } else if (dayInNumber == 6) {
                day = 4;
                dayName = "Пт, нечётная неделя";
            } else if (dayInNumber == 7) {
                day = 5;
                dayName = "Сб, нечётная неделя";
            } else if (dayInNumber == 1) {
                day = 6;
            }
        }


       else if (weekNumber%2 == 0){
            if (dayInNumber == 2) {
                day = 7;
                dayName = "Пн, чётная неделя";
            } else if (dayInNumber == 3) {
                day = 8;
                dayName = "Вт, чётная неделя";
            } else if (dayInNumber == 4) {
                day = 9;
                dayName = "Ср, чётная неделя";
            } else if (dayInNumber == 5) {
                day = 10;
                dayName = "Чт, чётная неделя";
            } else if (dayInNumber == 6) {
                day = 11;
                dayName = "Пт, чётная неделя";
            } else if (dayInNumber == 7) {
                day = 12;
                dayName = "Сб, чётная неделя";
            } else if (dayInNumber == 1) {
                day = 13;
            }
        }

        return day;
    }
}
