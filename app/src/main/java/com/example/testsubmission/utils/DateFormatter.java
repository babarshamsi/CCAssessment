package com.example.testsubmission.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static String getFullDayName(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date newDate = null;
        try {
            newDate = dateFormat.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (newDate != null) {
            SimpleDateFormat sm = new SimpleDateFormat("EEEE");
            date = sm.format(newDate);
        }
        return date ;
    }

    public static String getShortDayName(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date newDate = null;
        try {
            newDate = dateFormat.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (newDate != null) {
            SimpleDateFormat sm = new SimpleDateFormat("EEE");
            date = sm.format(newDate);
        }
        return date ;
    }
}
