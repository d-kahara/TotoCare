package com.group.TotoCare.model;

/**
 * Created by david on 11/1/17.
 */

public class Development{
    public String size;
    public String description;
    public String url;

    public Development(){

    }

    public Development(String size, String description, String url){
        this.description=description;
        this.size=size;
        this.url=url;
    }

    //getter methods

    public String getSize(){
        return size;
    }
    public String getDescription(){
        return description;
    }
    public String getUrl(){
        return url;
    }
}
