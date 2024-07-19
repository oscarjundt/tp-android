package com.example.myyoutubeapplication;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private List<YoutubeVideo> dataList;
    private Context context;
    public static final String KEY2 = "question";

    public Adapter(List<YoutubeVideo> dataList,Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        YoutubeVideo data = dataList.get(position);
        long id = data.getId();
        holder.textView.setText(data.getTitre());
        holder.button.setText("Voir");
        holder.Url.setText(data.getUrl());
        holder.Url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(data.getUrl()));
                try {
                    context.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                }
            }
        });
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(context,MainActivity3.class);
                intent2.putExtra(KEY2,id);
                context.startActivity(intent2);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
