package com.example.twittok.ui.twokscroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.dto.TwokUserWrapper;

import java.util.ArrayList;

public class TwokViewAdapter extends RecyclerView.Adapter<TwokViewHolder> {
    // --- ATTRIBUTES ------------------------------------------------------------------------------
    private final LayoutInflater inflater = LayoutInflater.from(ContextSupplier.getContext());
    private ArrayList<TwokUserWrapper> twokArrayList;



    // --- CONSTRUCTORS ----------------------------------------------------------------------------
    public TwokViewAdapter(ArrayList<TwokUserWrapper> twokArrayList) {
        this.twokArrayList = twokArrayList;
    }



    // --- GETTERS & SETTERS -----------------------------------------------------------------------
    public void setTwokArrayList(ArrayList<TwokUserWrapper> twokArrayList) {
        this.twokArrayList = twokArrayList;
    }


    // --- METHODS ---------------------------------------------------------------------------------
    @NonNull
    @Override
    public TwokViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.twok_item, parent, false);
        return new TwokViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TwokViewHolder holder, int position) {
        TwokUserWrapper twokToShow = twokArrayList.get(position);
        holder.updateContent(twokToShow);
    }

    @Override
    public int getItemCount() {
        return twokArrayList.size();
    }
}
