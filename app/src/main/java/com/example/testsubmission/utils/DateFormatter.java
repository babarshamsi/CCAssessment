package com.example.testsubmission.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static String getFullDayName(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date myDate = null;
        try {
            myDate = dateFormat.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (myDate != null) {
            SimpleDateFormat sm = new SimpleDateFormat("EEEE");
            date = sm.format(myDate);
        }
        return date ;
    }

    public static String getShortDayName(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date myDate = null;
        try {
            myDate = dateFormat.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (myDate != null) {
            SimpleDateFormat sm = new SimpleDateFormat("EEE");
            date = sm.format(myDate);
        }
        return date ;
    }
}
