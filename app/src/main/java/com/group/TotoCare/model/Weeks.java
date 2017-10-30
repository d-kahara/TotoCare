package com.group.TotoCare.model;

/**
 * Created by rahmak on 10/23/17
 */

public class Weeks {
    public String week_day;
    public String details_week;

    public Weeks() {
    }

    public Weeks(String week_day, String details_week) {
        this.week_day = week_day;
        this.details_week = details_week;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public String getDetails_week() {
        return details_week;
    }

    public void setDetails_week(String details_week) {
        this.details_week = details_week;
    }
}
