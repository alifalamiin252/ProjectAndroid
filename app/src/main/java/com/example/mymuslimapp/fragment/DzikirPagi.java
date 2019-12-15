package com.example.mymuslimapp.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymuslimapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DzikirPagi extends Fragment {
    public DzikirPagi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dzikir_pagi, container, false);
    }

}
