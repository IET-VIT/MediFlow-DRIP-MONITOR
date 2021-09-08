package com.undamped.medicare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FieldAdapter extends RecyclerView.Adapter<FieldAdapter.ViewHolder> {
    List<Feeds> feedsList;
    Context context;

    public FieldAdapter(List<Feeds> feeds) {
        feedsList = feeds;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Feeds feed = feedsList.get(position);

        holder.textDateTime.setText(feed.getCreated_at());

        if ((feed.getField1()) >= 800) {
            holder.bubble_value.setText("No Bubble");
        } else {
            holder.bubble_value.setText("Bubbles Formed");
        }

        switch (feed.getField2()) {
            case 12:
                holder.depth_value.setText("100%");
                break;
            case 11:
                holder.depth_value.setText("91.3%");
                break;
            case 10:
                holder.depth_value.setText("83%");
                break;
            case 9:
                holder.depth_value.setText("74.7%");
                break;
            case 8:
                holder.depth_value.setText("66.4%");
                break;
            case 7:
                holder.depth_value.setText("58.1%");
                break;
            case 6:
                holder.depth_value.setText("49.8%");
                break;
            case 5:
                holder.depth_value.setText("41.5%");
                break;
            case 4:
                holder.depth_value.setText("33.2%");
                break;
            case 3:
                holder.depth_value.setText("24.9%");
                break;
            case 2:
                holder.depth_value.setText("16.6%");
                break;
            case 1:
                holder.depth_value.setText("8.3%");
                break;
            case 0:
                holder.depth_value.setText("0%");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView depth_value, textDateTime, bubble_value;
        ImageView icon_image_view, icon_image_view_bubble;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bubble_value = itemView.findViewById(R.id.bubble_value);
            depth_value = itemView.findViewById(R.id.depth_value);
            textDateTime = itemView.findViewById(R.id.textDateTime);
        }
    }
}
