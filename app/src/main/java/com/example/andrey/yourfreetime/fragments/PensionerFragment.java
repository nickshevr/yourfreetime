package com.example.andrey.yourfreetime.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrey.yourfreetime.R;
import com.example.andrey.yourfreetime.activities.AddActivity;
import com.example.andrey.yourfreetime.activities.CentralActivity;
import com.example.andrey.yourfreetime.activities.MainActivity2;
import com.example.andrey.yourfreetime.classes.Parameters;

/**
 * A simple {@link Fragment} subclass.
 */
public class PensionerFragment extends Fragment implements View.OnClickListener {


    public PensionerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pensioner, container, false);
        rootView.findViewById(R.id.pensionerl).setOnClickListener(this);
        return rootView;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pensionerl:
                Intent intent = new Intent(this.getActivity(), CentralActivity.class);
                Parameters.setChoosen_type("pensioner");
                startActivity(intent);
                break;

        }
    }
}