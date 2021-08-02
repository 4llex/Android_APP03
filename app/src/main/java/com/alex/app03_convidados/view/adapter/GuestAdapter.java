package com.alex.app03_convidados.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex.app03_convidados.R;
import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.view.listener.OnListClick;
import com.alex.app03_convidados.view.viewholder.GuestViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GuestAdapter extends RecyclerView.Adapter<GuestViewHolder> {

    private List<GuestModel> mList = new ArrayList<>();
    private OnListClick mListener;

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_guest_row, parent, false);

        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        holder.bind(this.mList.get(position), this.mListener);
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }

    public void attachList(List<GuestModel> list){
        this.mList = list;
        notifyDataSetChanged();
    }

    public void attachListener(OnListClick listener){
        this.mListener = listener;
    }
}
