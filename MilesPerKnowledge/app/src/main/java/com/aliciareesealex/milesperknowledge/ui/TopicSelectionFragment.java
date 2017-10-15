package com.aliciareesealex.milesperknowledge.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.R;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopicSelectionFragment extends Fragment implements Contract.MPKView.TopicSelectionFragmentView {
    static String TAG = TopicSelectionFragment.class.getCanonicalName();
	@BindView(R.id.recyclerView_topic_selection)
	RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topic_selection, container, false);
    }

}
