package com.aliciareesealex.milesperknowledge.util;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Name: Alex Oladele
 * Unique-ID: OLADELAA
 * Date: 10/14/17
 * Project: MilesPerKnowledge
 */

public class MySqlDB extends AsyncTask<String, String, String> {
	private static String TAG = MySqlDB.class.getCanonicalName();
	static private Connection connect = null;
	static private Statement statement = null;
	static private PreparedStatement preparedStatement = null;
	static private ResultSet resultSet = null;

	protected void connectToDatabase(Context context) {
		writeDBInfoToFile(context);
		try {
//			Reads username and pass from storage
			BufferedReader reader = new BufferedReader(new FileReader(context.getFilesDir()+"/dbInfo"));
			String username = reader.readLine().trim();
			String password = reader.readLine().trim();
			Log.i(TAG, "connectToDatabase: " + "\nUsername: " + username + "\npass: " + password);
//			Loads SQL Driver
			Class.forName("com.mysql.jdbc.Driver");
//			Sets parameters for connection
			connect = DriverManager.getConnection("jdbc:mysql://18.216.33.2:3306/mpkdb", username, password);
			if (connect == null) {
				Log.d(TAG, "connectToDatabase: Connect still null");
			} else {
				Log.d(TAG, "connectToDatabase: Connect not null!!");
			}
		} catch (Exception e) {
			try {
				throw e;
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void writeDBInfoToFile(Context context) {
		String filename = "dbInfo";
		String writeLine = "skyhack\neacss".trim();
		FileOutputStream outputStream;
		try {
			outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
			outputStream.write(writeLine.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnectionToDatabase() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String doInBackground(String... strings) {
		return null;
	}
}
