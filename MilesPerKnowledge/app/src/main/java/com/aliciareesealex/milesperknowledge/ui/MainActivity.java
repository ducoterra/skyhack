/*
 * Author: Reese, Alex, Alicia
 * Date: 10/13/2017
 * The MainActivity sets up the fragment placeholder, and presenter for use
 */
package com.aliciareesealex.milesperknowledge.ui;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aliciareesealex.milesperknowledge.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

	//    ======================== VARIABLES ========================
//	Class Tag
	static String TAG = MainActivity.class.getCanonicalName();
	//	Permissions
	public final int READ_WRITE_EXTERNAL_STORAGE_PERMISSION = 72;
	//	Widgets
	@BindView(R.id.layout_root)
	View rootLayout; //Binds root layout xml to variable
	//  Firebase
	private FirebaseAnalytics firebaseAnalytics = null;


	//    ======================== INTERFACE OVERRIDE METHODS ========================

	/**
	 * @param savedInstanceState This is used if its being called form another activity and already has a bundle
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		Initialize Firebase analytics
		firebaseAnalytics = FirebaseAnalytics.getInstance(this);

//		Button root = findViewById(R.id.layout_root); // todo FORCES CRASH


	}


	/**
	 *
	 */
	@Override
	protected void onResume() {
		super.onResume();
		// TODO: 10/14/17 Maybe fix eventually
//		checkPermissions();
	}

	/**
	 * @param requestCode  The request code passed in requestPermissions
	 * @param permissions  The requested permissions. Never null.
	 * @param grantResults The grant results for the corresponding permissions which is either PERMISSION_GRANTED or PERMISSION_DENIED. Never null.
	 */
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		switch (requestCode) {
			case READ_WRITE_EXTERNAL_STORAGE_PERMISSION: {
				if (grantResults.length > 0) {
					/*if ( grantResults[0] == PackageManager.PERMISSION_GRANTED
							&& grantResults[1] == PackageManager.PERMISSION_GRANTED
							&& grantResults[2] == PackageManager.PERMISSION_GRANTED) {
						// TODO: 10/14/17 Do context related tasks here
						Toast.makeText(getApplicationContext(), "Permissions granted!", Toast.LENGTH_SHORT).show();
					}*/

					boolean readExt = grantResults[1] == PackageManager.PERMISSION_GRANTED;
					boolean writeExt = grantResults[0] == PackageManager.PERMISSION_GRANTED;
					boolean sms = grantResults[2] == PackageManager.PERMISSION_GRANTED;
				} else {
					Toast.makeText(getApplicationContext(), "Permissions Needed to use app", Toast.LENGTH_SHORT)
							.show();
					Log.i(TAG, "onRequestPermissionsResult: External Storage permission denied");
//					System.exit(0);
				}
			}
			break;

		}

	}

	//    ======================== USER METHODS ========================

	/**
	 * This method displays the request permissions popup
	 */
	private void checkPermissions() {

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			String[] permissions = {"Manifest.permission.WRITE_EXTERNAL_STORAGE",
					"Manifest.permission.READ_EXTERNAL_STORAGE", "Manifest.permission.ACCESS_FINE_LOCATION"};
			if (ContextCompat.checkSelfPermission(getApplicationContext(), permissions[0]) != PackageManager.PERMISSION_GRANTED &&
					ContextCompat.checkSelfPermission(getApplicationContext(), permissions[1]) != PackageManager.PERMISSION_GRANTED &&
					ContextCompat.checkSelfPermission(getApplicationContext(), permissions[2]) != PackageManager.PERMISSION_GRANTED
					) {
				ActivityCompat.requestPermissions(this, permissions, READ_WRITE_EXTERNAL_STORAGE_PERMISSION);
			}
		}
	}

	/**
	 * Switches to the Search By Airport fragment
	 */
	private void switchToSearchFragment() {
		SearchAirportFragment searchAirportFragment = new SearchAirportFragment();
		getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.fragment_search_airport, searchAirportFragment, SearchAirportFragment.TAG)
				.commit();
	}

}
