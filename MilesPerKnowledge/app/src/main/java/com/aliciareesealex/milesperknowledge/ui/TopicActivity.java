package com.aliciareesealex.milesperknowledge.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.R;
import com.aliciareesealex.milesperknowledge.util.MySqlDB;

public class TopicActivity extends AppCompatActivity implements Contract.MPKView.TopicActivityView {
    static String TAG = TopicActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }

	@Override
	protected void onStop() {
		super.onStop();
		MySqlDB sqlDB = new MySqlDB();
//		sqlDB.closeConnectionToDatabase();
	}
}
