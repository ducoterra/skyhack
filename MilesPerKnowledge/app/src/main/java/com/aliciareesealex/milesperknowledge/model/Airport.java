package com.aliciareesealex.milesperknowledge.model;

/*
 * Author: Reese, Alex, Alicia
 * Date: 10/13/2017
 * Store and retrieve data
 */

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.util.MySqlDB;

public class Airport extends MySqlDB implements Contract.MPKModel.AirportModel {
    private String airportCode;
    private String state;
    private String city;

	public Airport() {
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
