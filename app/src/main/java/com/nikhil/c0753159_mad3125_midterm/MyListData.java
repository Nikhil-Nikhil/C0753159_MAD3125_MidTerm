package com.nikhil.c0753159_mad3125_midterm;

import java.util.ArrayList;

public class MyListData {
    static ArrayList<MyListData> DataList = new ArrayList<MyListData>();
    private String description;
    public MyListData(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

