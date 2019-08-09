package com.nikhil.c0753159_mad3125_midterm;

public class FlightDetail {
    String flightimage;
    String flightName;
    String flightYear;

    public FlightDetail() {
    }

    public FlightDetail(String image, String flightName, String flightYear) {
        this.flightimage = image;
        this.flightName = flightName;
        this.flightYear = flightYear;
    }

    public String getFlightImage() {
        return flightimage;
    }

    public void setFlightImage(String image) {
        this.flightimage = image;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightYear() {
        return flightYear;
    }

    public void setFlightYear(String flightYear) {
        this.flightYear = flightYear;
    }
    @Override
    public String toString() {
        return "FlightRow{" +
                "image='" + flightimage + '\'' +
                ", flightName='" + flightName + '\'' +
                ", flightYear='" + flightYear + '\'' +
                '}';
    }
}

