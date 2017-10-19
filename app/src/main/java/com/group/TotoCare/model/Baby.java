package com.group.TotoCare.model;

import org.parceler.Parcel;

/**
 * Created by david on 10/18/17.
 */

@Parcel
public class Baby {
    String week;


    public Baby() {};

    public Baby(String week) {
        this.week = week;
    }

    public String getWeek() {
        return week;
    }

}


