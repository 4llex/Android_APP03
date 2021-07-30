package com.alex.app03_convidados.view.adapter;

import android.view.ViewGroup;

import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.view.viewholder.GuestViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GuestAdapter extends RecyclerView.Adapter<GuestViewHolder> {

    private List<GuestModel> mList = new ArrayList<>();


    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }

    public void attachList(List<GuestModel> list){
        this.mList = list;
        notifyDataSetChanged();
    }
}
