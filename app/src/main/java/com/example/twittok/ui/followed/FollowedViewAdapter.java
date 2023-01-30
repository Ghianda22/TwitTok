package com.example.twittok.ui.followed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.dto.FollowedUserWrapper;

import java.util.ArrayList;

public class FollowedViewAdapter extends RecyclerView.Adapter<FollowedViewHolder> {

    // --- ATTRIBUTES ------------------------------------------------------------------------------
    private final LayoutInflater inflater = LayoutInflater.from(ContextSupplier.getContext());
    private ArrayList<FollowedUserWrapper> followedArrayList;



    // --- CONSTRUCTORS ----------------------------------------------------------------------------
    public FollowedViewAdapter(ArrayList<FollowedUserWrapper> followedArrayList) {
        this.followedArrayList = followedArrayList;
    }
    public void setFollowedArrayList(ArrayList<FollowedUserWrapper> followedArrayList) {
        this.followedArrayList = followedArrayList;
    }




    // --- METHODS ---------------------------------------------------------------------------------
    @NonNull
    @Override
    public FollowedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.twok_item, parent, false);
        return new FollowedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowedViewHolder holder, int position) {
        FollowedUserWrapper userToShow = followedArrayList.get(position);
        holder.updateContent(userToShow);
    }

    @Override
    public int getItemCount() {
        return followedArrayList.size();
    }
}
