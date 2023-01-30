package com.example.twittok.ui.followed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.dto.FollowedUserWrapper;
import com.example.twittok.dto.TwokUserWrapper;

public class FollowedViewAdapter extends RecyclerView.Adapter<> {

    private final LayoutInflater inflater = LayoutInflater.from(ContextSupplier.getContext());

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new FollowedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowedViewHolder holder, int position) {
        FollowedUserWrapper userToShow = twokArrayList.get(position);
        holder.updateContent(userToShow);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
