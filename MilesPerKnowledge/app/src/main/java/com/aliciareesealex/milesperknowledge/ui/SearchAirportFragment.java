package com.aliciareesealex.milesperknowledge.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.R;
import com.aliciareesealex.milesperknowledge.presenter.SearchAirportPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SearchAirportFragment extends Fragment implements Contract.MPKView.SearchAirportFragmentView {
	static String TAG = SearchAirportFragment.class.getCanonicalName();
	private Contract.MPKPresenter.SearchAirportFragmentPresenter presenter;

	@BindView(R.id.button_next)
	Button nextButton;
	@BindView(R.id.searchView_fromDestination)
	SearchView fromDestination;
	@BindView(R.id.searchView_toDestination)
	SearchView toDestination;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {

		// Assigns layout to variable to inflate for this fragment
		View v = inflater.inflate(R.layout.fragment_search_airport, container, false);

//		Binds all views quickly
		ButterKnife.bind(this, v);

//		Sets presenter for use
		presenter = new SearchAirportPresenter(this);

		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				presenter.validateLocation(fromDestination.getQuery().toString(), toDestination.getQuery().toString());
			}
		});


//	    Inflates view
		return v;
	}

}
