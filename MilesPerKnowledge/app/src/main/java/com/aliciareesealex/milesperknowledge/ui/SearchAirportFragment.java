package com.aliciareesealex.milesperknowledge.ui;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.R;
import com.aliciareesealex.milesperknowledge.presenter.SearchAirportPresenter;
import com.aliciareesealex.milesperknowledge.util.MySqlDB;

import java.util.ArrayList;
import java.util.List;

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
	List<String> strings = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {

		// Assigns layout to variable to inflate for this fragment
		View v = inflater.inflate(R.layout.fragment_search_airport, container, false);

//		Binds all views quickly
		ButterKnife.bind(this, v);

//		Sets presenter for use
		presenter = new SearchAirportPresenter(this);
		MySqlDB sqlDB = new MySqlDB();
		AsyncTask.execute(() -> presenter.connectToDB());
//				presenter.connectToDB()


		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AsyncTask.execute(() -> {
					strings = presenter.checkInput(getContext(),fromDestination.getQuery().toString(),toDestination.getQuery().toString());
					presenter.validateLocation(strings);

				});

			}
		});


//	    Inflates view
		return v;
	}

	@Override
	public void showError() {
		Toast.makeText(getContext(), "Invalid Location entered", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void goToNextScreen() {
		TopicSelectionFragment topicSelectionFragment = new TopicSelectionFragment();
		switchFragment(topicSelectionFragment);
	}

	private void switchFragment(Fragment fragment) {
		getActivity().getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.layout_root, fragment)
				.commit();
	}

}
