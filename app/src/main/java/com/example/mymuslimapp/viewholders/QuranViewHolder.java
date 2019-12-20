package com.example.mymuslimapp.viewholders;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymuslimapp.R;
import com.example.mymuslimapp.models.Quran;

public class QuranViewHolder extends RecyclerView.ViewHolder {
    private AdapterView.OnItemClickListener listener;

    public TextView tvArab, tvIndo;

    public QuranViewHolder(@NonNull View itemView) {
        super(itemView);

        tvArab = itemView.findViewById(R.id.tv_arabic);
        tvIndo = itemView.findViewById(R.id.tv_indo);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void bindToQuran(Quran quran, View.OnClickListener onClickListener) {
        tvArab.setText(quran.arab);
        tvIndo.setText(quran.indo);
    }
}
