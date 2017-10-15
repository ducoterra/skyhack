package com.aliciareesealex.milesperknowledge.model;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.util.MySqlDB;

/*
 * Author: Reese, Alex, Alicia
 * Date: 10/13/2017
 * Store and retrieve data
 */
public class Flight extends MySqlDB implements Contract.MPKModel.FlightModel {
    private int flightNumber;
    private String startCode;
    private String endCode;
    private int time;

    public Flight() {
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStartCode() {
        return startCode;
    }

    public void setStartCode(String startCode) {
        this.startCode = startCode;
    }

    public String getEndCode() {
        return endCode;
    }

    public void setEndCode(String endCode) {
        this.endCode = endCode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
