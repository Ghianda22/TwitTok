package com.example.twittok.ui.twokscroll;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.repositories.TwokRepository;

public class TwokViewHolder extends RecyclerView.ViewHolder {

    //create here all views to be updated in twok_item

    public TwokViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void updateContent(TwokRepository twokToShow){
        //extract all twok properties
        //assign to views the twok properties
    }
}
