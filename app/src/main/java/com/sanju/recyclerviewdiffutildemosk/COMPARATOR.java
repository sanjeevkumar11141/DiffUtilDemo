package com.sanju.recyclerviewdiffutildemosk;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.sanju.recyclerviewdiffutildemosk.model.Animal;
import com.sanju.recyclerviewdiffutildemosk.model.Model;
import com.sanju.recyclerviewdiffutildemosk.model.Person;

public class COMPARATOR extends DiffUtil.ItemCallback<Model> {
    @Override
    public boolean areItemsTheSame(@NonNull Model oldItem, @NonNull Model newItem) {
        if(oldItem instanceof Animal && newItem instanceof Person){
            return false;
        }else if(oldItem instanceof Animal && newItem instanceof Animal){
            return oldItem.equals(newItem);
        }else if(oldItem instanceof Person && newItem instanceof Person){
            return oldItem.equals(newItem);
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Model oldItem, @NonNull Model newItem) {
        return false;
    }
}
