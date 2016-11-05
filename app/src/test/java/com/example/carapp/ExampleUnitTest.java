package com.example.carapp;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void CheckCuirrentDate() throws Exception {
        com.example.carapp.CalendarClass cal = new CalendarClass();
        String test = cal.getCurrentDate();
        Calendar calobj = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        String currentDate = df.format(calobj.getTime());
        assert(test.equals(currentDate));
    }

    @Test
    public void CheckButtonClick() throws Exception {
        CalendarClass cal = new CalendarClass();
        String test = cal.getCurrentDate();
        Calendar calobj = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        String currentDate = df.format(calobj.getTime());
        assert(test.equals(currentDate));
    }
}