package com.universityapp.terminal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Monika on 11/12/2016.
 */
public class Conversion {
    public static Date convertStringIntoDate(String startDateString){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = new Date();
        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }
}
