package com.sanju.recyclerviewdiffutildemosk;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanju.recyclerviewdiffutildemosk.model.Animal;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    TextView animal_tv;
    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bindView(Animal animal){
        animal_tv.setText(animal.getName());
    }

}
