package com.appseries.zainaftab.crazy3.Models;

public class DataModel {

    String name;
    String date;
    String score;

    public DataModel(String name, String date, String score) {
        this.name=name;
        this.date=date;
        this.score=score;

    }

    public String getName() {
        return name;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getscore() {
        return score;
    }
    

}
