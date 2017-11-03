package com.group.TotoCare.model;

/**
 * Created by david on 11/1/17.
 */

public class Tests {

    private String test;
    private String testDescription;
    private String testUrl;
    //create empty constructor
    public Tests(){

    }
    public Tests(String test, String testDescription, String testUrl){
        this.test=test;
        this.testDescription=testDescription;
        this.testUrl=testUrl;
    }


    public String getTest(){
        return test;
    }
    public String getTestDescription(){
        return testDescription;
    }
    public String getImageIrl(){
        return testUrl;
    }
}