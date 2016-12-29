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


public class StudentFragment extends Fragment implements View.OnClickListener {
    public StudentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_student, container, false);
        rootView.findViewById(R.id.studentlayer).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.studentlayer:
                Intent intent = new Intent(this.getActivity(), CentralActivity.class);
                Parameters.setChoosen_type("student");
                startActivity(intent);
                break;
        }
    }
}
