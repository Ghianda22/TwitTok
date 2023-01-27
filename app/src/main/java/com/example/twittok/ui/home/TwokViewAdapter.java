package com.example.twittok.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.network.config.ContextSupplier;
import com.example.twittok.repositories.TwokRepository;

import java.util.zip.Inflater;

public class TwokViewAdapter extends RecyclerView.Adapter<TwokViewHolder> {

    private String[] tempStringArray = null;
    private LayoutInflater inflater;

    public TwokViewAdapter(String[] tempString) {
        this.tempStringArray = tempString;
        this.inflater = LayoutInflater.from(ContextSupplier.getContext());
    }

    @NonNull
    @Override
    public TwokViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.twok_item, parent,false);
        return new TwokViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TwokViewHolder holder, int position) {
        holder.updateContent(tempStringArray[position]);
    }

    @Override
    public int getItemCount() {
        return tempStringArray.length;
    }
}
