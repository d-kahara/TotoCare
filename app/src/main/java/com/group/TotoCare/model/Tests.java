package com.group.TotoCare.model;

/**
 * Created by david on 11/1/17.
 */

public class Tests {

    private String test;
    private String description;
    private String url;
    //create empty constructor
    public Tests(){

    }
    public Tests(String test, String description, String url){
        this.test=test;
        this.description = description;
        this.url =url;
    }


    public String getTest(){
        return test;
    }
    public String getDescription(){
        return description;
    }
    public String getUrl(){
        return url;
    }
}