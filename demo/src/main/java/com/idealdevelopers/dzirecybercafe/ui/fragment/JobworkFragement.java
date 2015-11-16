package com.idealdevelopers.dzirecybercafe.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.idealdevelopers.dzirecybercafe.R;
import com.idealdevelopers.dzirecybercafe.ui.Parse.MainActivity;

/**
 * Created by Project I on 11/1/2015.
 */
public class JobworkFragement extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.jobwork, container, false);

        Button newPage = (Button) v.findViewById(R.id.button);
        newPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        Button newPage1 = (Button) v.findViewById(R.id.button2);
        newPage1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        Button newPage2 = (Button) v.findViewById(R.id.button4);
        newPage2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        Button newPage3 = (Button) v.findViewById(R.id.button);
        newPage3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }}
