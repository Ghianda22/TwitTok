package com.example.twittok.ui.home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twittok.R;
import com.example.twittok.datasource.network.config.ContextSupplier;

public class TwokViewHolder extends RecyclerView.ViewHolder {

    //TODO: convert string type to twok type and update tv to other type of views
    private TextView tv = null;
    public TwokViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.twokItem);
    }

    public void updateContent(String content){
        tv.setText(content);
    }
}
