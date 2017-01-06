package com.desai.vatsal.mydynamiccalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HCL on 24-11-2016.
 */
public class GlobalMethods {

    public static String convertDate(String inputDate, SimpleDateFormat inputFormat, SimpleDateFormat outputFormat) {

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(inputDate);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

}
