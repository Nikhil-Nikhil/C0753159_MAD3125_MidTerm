package com.nikhil.c0753159_mad3125_midterm;

public class Rdata {
    String rocket_id;
    String rocket_name;
    String rocket_type;

    public Rdata() {
    }

    public Rdata(String rocket_id, String rocket_name, String rocket_type) {
        this.rocket_id = rocket_id;
        this.rocket_name = rocket_name;
        this.rocket_type = rocket_type;
    }

    public String getRocket_id() {
        return rocket_id;
    }

    public void setRocket_id(String rocket_id) {
        this.rocket_id = rocket_id;
    }

    public String getRocket_name() {
        return rocket_name;
    }

    public void setRocket_name(String rocket_name) {
        this.rocket_name = rocket_name;
    }

    public String getRocket_type() {
        return rocket_type;
    }

    public void setRocket_type(String rocket_type) {
        this.rocket_type = rocket_type;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "rocket_id='" + rocket_id + '\'' +
                ", rocket_name='" + rocket_name + '\'' +
                ", rocket_type='" + rocket_type + '\'' +
                '}';
    }
}

