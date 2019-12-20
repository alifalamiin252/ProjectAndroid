package com.example.mymuslimapp.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mymuslimapp.R;
import com.example.mymuslimapp.activities.SuratActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Surat extends Fragment {


    public Surat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_surat,
                container, false);
        Button buttonSurah1 = view.findViewById(R.id.buttonSurah1);
        buttonSurah1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SuratActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
