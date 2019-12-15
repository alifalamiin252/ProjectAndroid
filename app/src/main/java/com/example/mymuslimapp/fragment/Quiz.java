package com.example.mymuslimapp.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mymuslimapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Quiz extends Fragment {



    public Quiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz,
                container, false);
        final Button guessButton = (Button) view.findViewById(R.id.guess_button);
        final Button resetButton = (Button) view.findViewById(R.id.reset_button);

        resetButton.setEnabled(false);

        guessButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText jawabanText;
                int jawaban = 1;

                jawabanText = getView().findViewById(R.id.number_input);

                if (jawabanText.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Isilah tebakan anda!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int guessNumber = Integer.parseInt(jawabanText.getText().toString());

                    if (guessNumber > jawaban)
                    {
                        Toast.makeText(getActivity(), "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
                    }
                    else if(guessNumber < jawaban)
                    {
                        Toast.makeText(getActivity(), "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
                    }
                    // jika jawaban benar
                    else
                    {
                        Toast.makeText(getActivity(), "Tebakan anda benar!", Toast.LENGTH_SHORT).show();

                        guessButton.setEnabled(false);
                        resetButton.setEnabled(true);
                        jawabanText.setEnabled(false);
                    }
                }

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText jawabanText;

                jawabanText = getView().findViewById(R.id.number_input);

                jawabanText.setText("");

                guessButton.setEnabled(true);
                resetButton.setEnabled(false);
                jawabanText.setEnabled(true);
            }
        });

        return view;
    }

}
