package com.aliciareesealex.milesperknowledge.presenter;

import android.content.Context;
import android.os.Bundle;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.model.Airport;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: Alex Oladele
 * Unique-ID: OLADELAA
 * Date: 10/14/17
 * Project: MilesPerKnowledge
 */

public class SearchAirportPresenter implements Contract.MPKPresenter.SearchAirportFragmentPresenter {
	private Contract.MPKView.SearchAirportFragmentView searchAirportView;
	private Contract.MPKModel.AirportModel fromAirport = new Airport();
	private Contract.MPKModel.AirportModel toAirport = new Airport();
	List<String> resultsList = new ArrayList<>();


	public SearchAirportPresenter(Contract.MPKView.SearchAirportFragmentView searchAirportView) {
		this.searchAirportView = searchAirportView;
	}

	@Override
	public void validateLocation(List<String> results) {

		if (results.get(0) == null || results.get(1) == null) {
			searchAirportView.showError();
		} else {
			Bundle bundle = new Bundle();
			bundle.putString("code1",resultsList.get(0));
			bundle.putString("code2",resultsList.get(1));
			searchAirportView.goToNextScreen(bundle);
		}
	}

	@Override
	public List<String> checkInput(Context context, String startLoc, String endLoc) {
		String s = fromAirport.getAirportCode(context, cleanInput(startLoc));
		resultsList.add(s);

		s = fromAirport.getAirportCode(context, cleanInput(endLoc));
		resultsList.add(s);
		System.out.println("Pre-Ret");
//		AsyncTask.publis
		return resultsList;
	}

	@Override
	public String cleanInput(String input) {
		input = input.toUpperCase().trim();
		return input;
	}

	@Override
	public void connectToDB() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				fromAirport.connectToDB();
			}
		}).start();

//		fromAirport.connectToDB();

	}
}
