
package com.example.akmanwal.mydemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("no")
    @Expose
    private Integer no;
    @SerializedName("scharr")
    @Expose
    private String scharr;
    @SerializedName("schdep")
    @Expose
    private String schdep;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("halt")
    @Expose
    private Integer halt;
    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("station")
    @Expose
    private Station station;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getHalt() {
        return halt;
    }

    public void setHalt(Integer halt) {
        this.halt = halt;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

}
