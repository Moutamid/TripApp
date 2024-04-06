package com.moutamid.sqlapp.activities.Calender.calenderapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.sqlapp.R;

import java.util.List;

public class LocalEventAdapter extends RecyclerView.Adapter<LocalEventAdapter.EventViewHolder> {
    private List<String> titles;

    public LocalEventAdapter(List<String> titles) {
        this.titles = titles;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_local_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        String title = titles.get(position);
        holder.textViewTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.event_name);
        }
    }
}
