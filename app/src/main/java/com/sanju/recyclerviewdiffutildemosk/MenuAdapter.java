package com.sanju.recyclerviewdiffutildemosk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.sanju.recyclerviewdiffutildemosk.model.Animal;
import com.sanju.recyclerviewdiffutildemosk.model.Model;
import com.sanju.recyclerviewdiffutildemosk.model.Person;

public class MenuAdapter extends ListAdapter<Model, RecyclerView.ViewHolder> {
    public MenuAdapter() {
        super(new COMPARATOR());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;
        if(viewType == 0){
            View view = layoutInflater.inflate(R.layout.item_person, parent, false);
           return viewHolder = new PersonViewHolder(view);
        }else {
            View view = layoutInflater.inflate(R.layout.item_animal, parent, false);
            return viewHolder = new AnimalViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof PersonViewHolder){
            ((PersonViewHolder)holder).bindView((Person)getItem(position));
        }else if(holder instanceof AnimalViewHolder){
            ((AnimalViewHolder)holder).bindView((Animal)getItem(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
       Model model =  getItem(position);
       if(model instanceof Person)
           return 0;
       else
           return 1;
        //return super.getItemViewType(position);
    }
}
