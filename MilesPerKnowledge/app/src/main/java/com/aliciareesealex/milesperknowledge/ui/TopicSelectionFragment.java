package com.aliciareesealex.milesperknowledge.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopicSelectionFragment extends Fragment implements Contract.MPKView.TopicSelectionFragmentView {
    static String TAG = TopicSelectionFragment.class.getCanonicalName();

    public TopicSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topic_selection, container, false);
    }

}
