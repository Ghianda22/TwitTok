package com.example.twittok.ui.twokscroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.repositories.TwokRepository;

import java.util.ArrayList;

public class TwokViewAdapter extends RecyclerView.Adapter<TwokViewHolder> {

    private LayoutInflater inflater = LayoutInflater.from(ContextSupplier.getContext());
    private ArrayList<TwokRepository> twokArrayList;


    public TwokViewAdapter(ArrayList<TwokRepository> twokArrayList) {
        this.twokArrayList = twokArrayList;
    }
    public void setTwokArrayList(ArrayList<TwokRepository> twokArrayList) {
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
        TwokRepository twokToShow = twokArrayList.get(position);
        holder.updateContent(twokToShow);
    }

    @Override
    public int getItemCount() {
        return twokArrayList.size();
    }
}
