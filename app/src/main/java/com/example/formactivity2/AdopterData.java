package com.example.formactivity2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AdopterData extends RecyclerView.Adapter<AdopterData.HolderData> {
    List<String> listData;
    android.view.LayoutInflater layoutInflater;

    public AdopterData(Context context, List<String> listData) {
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.itemdata, parent, false);
        return new HolderData(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdopterData.HolderData holder, int position) {
        holder.txtData.setText(listData.get (position));
    }

    @Override
    public int getItemCount() { return listData.size(); }



    public class HolderData extends RecyclerView.ViewHolder {
        TextView txtData;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtData = itemView.findViewById(R.id.tvText);
        }
    }
}
