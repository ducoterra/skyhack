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


}
