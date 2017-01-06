package com.desai.vatsal.mydynamiccalendar;

import java.util.Date;

/**
 * Created by vatsaldesai on 23-09-2016.
 */
public class DateModel {

    private Date dates;
    private String flag;
//    private boolean isCurrentDate;
//    private boolean isEventDate;

//    private ArrayList<Boolean> eventDate;


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
}
