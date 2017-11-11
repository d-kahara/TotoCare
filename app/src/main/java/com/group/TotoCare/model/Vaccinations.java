package com.group.TotoCare.model;

/**
 * Created by david on 11/1/17.
 */

public class Vaccinations {

    private String age;
    private String antigens;


    public Vaccinations(){
    }
    public Vaccinations(String age, String antigens){
        this.age=age;
        this.antigens=antigens;
    }
    public String getAge(){
        return age;
    }
    public String getAntigens(){
        return antigens;
    }
}