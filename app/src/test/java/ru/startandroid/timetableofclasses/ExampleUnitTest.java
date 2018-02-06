package ru.startandroid.timetableofclasses;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Date_isCorrect() throws Exception {

        MyCalendar calendar = new MyCalendar();
        int actual = calendar.getDay(4, 3, 6);
        int expected = 7;
        assertEquals(expected, actual);

    }
}