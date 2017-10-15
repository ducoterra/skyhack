package com.aliciareesealex.milesperknowledge;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

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
			void showError();

			void goToNextScreen(Bundle bundle);
		}

		interface TopicSelectionFragmentView extends MPKView {

		}

		interface VideoFragmentView extends MPKView {

		}
	}

	interface MPKPresenter {
		void connectToDB();

		interface TopicActivityPresenter extends MPKPresenter {

		}

		interface LoginActivityPresenter extends MPKPresenter {

		}

		interface MainActivityPresenter extends MPKPresenter {

		}

		interface SearchAirportFragmentPresenter extends MPKPresenter {
			//			void getStartAndEndDest();
			 void validateLocation(List<String> results);
			List<String> checkInput(Context context, String startLoc, String endLoc);

			String cleanInput(String input);

		}


		interface TopicSelectionFragmentPresenter extends MPKPresenter {

		}

		interface VideoFragmentPresenter extends MPKPresenter {

		}
	}

	interface MPKModel {
		void connectToDB();

		interface AchievementModel extends MPKModel {

		}

		interface AirportModel extends MPKModel {

			String getAirportCode(Context context, String location);

			void setAirportCode(String airportCode);

			String getState();

			void setState(String state);

			String getCity();

			void setCity(String city);
		}


		interface FlightModel extends MPKModel {

		}

		interface TopicModel extends MPKModel {

		}

		interface UserModel extends MPKModel {

		}
	}

}
