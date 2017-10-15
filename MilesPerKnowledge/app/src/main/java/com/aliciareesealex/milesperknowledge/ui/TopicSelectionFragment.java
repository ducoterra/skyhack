package com.aliciareesealex.milesperknowledge.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import com.aliciareesealex.milesperknowledge.Contract;
import com.aliciareesealex.milesperknowledge.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicSelectionFragment extends Fragment implements Contract.MPKView.TopicSelectionFragmentView{
    static String TAG = TopicSelectionFragment.class.getCanonicalName();
	@BindView(R.id.textView3)
	TextureView mathSelect;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_topic_selection, container, false);
	    ButterKnife.bind(this, v);

	    mathSelect.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
				switchFragment();
		    }
	    });
	    return v;
    }

	private void switchFragment() {
		VideoFragment fragment = new VideoFragment();
		getActivity().getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.layout_root, fragment)
				.commit();
	}
}
