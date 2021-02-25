package com.sanju.recyclerviewdiffutildemosk;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanju.recyclerviewdiffutildemosk.model.Person;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    TextView person_tv;
    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        person_tv = itemView.findViewById(R.id.person_tv);
    }

    public void bindView(Person person){
        person_tv.setText(person.getName());
    }
}
