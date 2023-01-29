package com.example.twittok.ui.twokscroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.network.config.ContextSupplier;
import com.example.twittok.datasource.model.TwokModel;

import java.util.ArrayList;

public class TwokViewAdapter extends RecyclerView.Adapter<TwokViewHolder> {

    private LayoutInflater inflater = LayoutInflater.from(ContextSupplier.getContext());
    private ArrayList<TwokModel> twokArrayList;


    public TwokViewAdapter(ArrayList<TwokModel> twokArrayList) {
        this.twokArrayList = twokArrayList;
    }
    public void setTwokArrayList(ArrayList<TwokModel> twokArrayList) {
        this.twokArrayList = twokArrayList;
    }

    @NonNull
    @Override
    public TwokViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.twok_item, parent, false);
        return new TwokViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TwokViewHolder holder, int position) {
        TwokModel twokToShow = twokArrayList.get(position);
        holder.updateContent(twokToShow);
    }

    @Override
    public int getItemCount() {
        return twokArrayList.size();
    }
}
