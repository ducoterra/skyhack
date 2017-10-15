package com.aliciareesealex.milesperknowledge.model;

/*
 * Author: Reese, Alex, Alicia
 * Date: 10/13/2017
 * Store and retrieve data
 */

import android.content.Context;
import android.util.Log;

import com.aliciareesealex.milesperknowledge.Contract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Airport implements Contract.MPKModel.AirportModel {
	private static final String TAG = Airport.class.getCanonicalName();
	private String airportCode;
	private String state;
	private String city;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public Airport() {
		super();
	}

	@Override
	public String getAirportCode(Context context, String location) {
		if (connect == null) {
			connectToDB();
			Log.d(TAG, "getAirportCode: ITS STILL NULL");
		}
		try {
			String query;
			if (location.length() == 3) {
//			Create query string
				query = "SELECT AirportCode FROM Airport WHERE AirportCode LIKE ?";
			} else {
				// TODO: 10/15/17 Figure out how to handle specificity
				query = "SELECT AirportCode FROM Airport WHERE AirportCode LIKE ?";
			}

			if (connect != null) {
				//			Prepares statement for use
				preparedStatement = connect.prepareStatement(query);

//			Sets the vals in the prepared statement
				preparedStatement.setString(1, location + "%");
				resultSet = preparedStatement.executeQuery();

				if (resultSet.first()) {
					airportCode = resultSet.getString("AirportCode");
				} else {
					airportCode = null;
				}
			} else {

				Log.d(TAG, "getAirportCode: CONNECT IS NULL!");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airportCode;
	}

	@Override
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	private void connectToDatabase() {
//		MySqlDB.closeConnectionToDatabase();
		try {
			String filePath = "/data/data/com.aliciareesealex.milesperknowledge/files/dbInfo";
//			Reads username and pass from storage
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String username = reader.readLine().trim();
			String password = reader.readLine().trim();
			Log.i(TAG, "connectToDatabase: " + "\nUsername: " + username + "\npass: " + password);
//			Loads SQL Driver
			Class.forName("com.mysql.jdbc.Driver");
//			Sets parameters for connection
			connect = DriverManager.getConnection("jdbc:mysql://18.216.33.2:3306/mpkdb", username, password);
			if (connect == null) {
				Log.d(TAG, "connectToDatabase: Connect still null");
//				connect = DriverManager.getConnection("jdbc:mysql://ec2-18-216-33-2.us-east-2.compute.amazonaws.com:3306/mpkdb", username, password);

			} else {
				Log.d(TAG, "connectToDatabase: Connect not null!!");
				setConnect(connect);

			}
		} catch (Exception e) {
			try {
				throw e;
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void connectToDB() {
		connectToDatabase();
	}
}
