package com.aliciareesealex.milesperknowledge.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aliciareesealex.milesperknowledge.R;

public class CourseActivity extends AppCompatActivity {
    static String TAG = CourseActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }
}
