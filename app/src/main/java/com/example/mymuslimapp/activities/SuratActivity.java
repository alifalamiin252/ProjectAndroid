package com.example.mymuslimapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymuslimapp.R;
import com.example.mymuslimapp.models.Quran;
import com.example.mymuslimapp.viewholders.QuranViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SuratActivity extends AppCompatActivity {

    // [START define_database_reference]
    private DatabaseReference mDatabase;
    // [END define_database_reference]

    private FirebaseRecyclerAdapter<Quran, QuranViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat);

        // jika hp offline, maka data tetap ada
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.keepSynced(true);

        mRecycler = findViewById(R.id.list_surat);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mManager);

        // Set up FirebaseRecyclerAdapter with the Query
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Quran>()
                .setQuery(query, Quran.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Quran, QuranViewHolder>(options) {
            @Override
            public QuranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new QuranViewHolder(inflater.inflate(R.layout.item_quran, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull QuranViewHolder holder, int position, @NonNull final Quran model) {

                holder.bindToQuran(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
        };

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase) {
        Query query = mDatabase.child("quran").child("surah").child("surah-1");
        return query;
    }
}
