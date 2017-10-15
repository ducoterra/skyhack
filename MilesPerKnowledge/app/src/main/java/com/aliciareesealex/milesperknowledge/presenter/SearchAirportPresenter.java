package com.aliciareesealex.milesperknowledge.presenter;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.model.Airport;

/**
 * Name: Alex Oladele
 * Unique-ID: OLADELAA
 * Date: 10/14/17
 * Project: MilesPerKnowledge
 */

public class SearchAirportPresenter implements Contract.MPKPresenter.SearchAirportFragmentPresenter {
	private Contract.MPKView.SearchAirportFragmentView searchAirportView;
	private Contract.MPKModel.AirportModel airport = new Airport();

	public SearchAirportPresenter(Contract.MPKView.SearchAirportFragmentView searchAirportView) {
		this.searchAirportView = searchAirportView;
	}

	@Override
	public void validateLocation(String startLoc, String endLoc) {

	}
}
