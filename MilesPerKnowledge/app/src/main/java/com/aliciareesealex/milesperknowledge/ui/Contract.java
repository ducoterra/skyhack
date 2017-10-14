package com.aliciareesealex.milesperknowledge.ui;

/**
 * Name: Alex Oladele
 * Unique-ID: OLADELAA
 * Date: 10/14/17
 * Project: MilesPerKnowledge
 */

public interface Contract {
	interface MPKView {
		//		void showToastMessage(String message);
		interface TopicActivityView extends MPKView {

		}

		interface LoginActivityView extends MPKView {

		}

		interface MainActivityView extends MPKView {

		}

		interface SearchAirportFragmentView extends MPKView {

		}

		interface SearchCityFragmentView extends MPKView {

		}

		interface TopicSelectionFragmentView extends MPKView {

		}

		interface VideoFragmentView extends MPKView {

		}
	}

	interface MPKPresenter {
		interface TopicActivityPresenter extends MPKPresenter {

		}

		interface LoginActivityPresenter extends MPKPresenter {

		}

		interface MainActivityPresenter extends MPKPresenter {

		}

		interface SearchAirportFragmentPresenter extends MPKPresenter {

		}

		interface SearchCityFragmentPresenter extends MPKPresenter {

		}

		interface TopicSelectionFragmentPresenter extends MPKPresenter {

		}

		interface VideoFragmentPresenter extends MPKPresenter {

		}
	}

	interface MPKModel {
		interface Achievement extends MPKModel {

		}

		interface Airport extends MPKModel {

		}

		interface Flight extends MPKModel {

		}

		interface Topic extends MPKModel {

		}

		interface User extends MPKModel {

		}
	}
}
