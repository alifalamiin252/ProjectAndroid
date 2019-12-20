package com.example.mymuslimapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mymuslimapp.R;
import com.example.mymuslimapp.fragment.Surat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.mymuslimapp.fragment.DzikirPagi;
import com.example.mymuslimapp.fragment.DzikirSore;
import com.example.mymuslimapp.fragment.Quiz;



public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private EditText jawabanText;
    private Button guessButton;
    int jawaban = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new DzikirPagi());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.pagi:
                fragment = new DzikirPagi();
                break;
            case R.id.sore:
                fragment = new DzikirSore();
                break;
            case R.id.quiz:
                fragment = new Quiz();
                break;
            case R.id.surat:
                fragment = new Surat();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
