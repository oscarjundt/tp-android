package com.example.myyoutubeapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    TextView Url;
    Button button;

    public ViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        button = itemView.findViewById(R.id.button4);
        Url = itemView.findViewById(R.id.url);
    }
}
