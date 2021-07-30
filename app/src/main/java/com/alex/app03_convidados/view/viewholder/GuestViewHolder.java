package com.alex.app03_convidados.view.viewholder;

import android.view.View;
import android.widget.TextView;

import com.alex.app03_convidados.R;
import com.alex.app03_convidados.model.GuestModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GuestViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;

    public GuestViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);
    }

    public void  bind(GuestModel guest){
        this.mTextName.setText(guest.getName());
    }

}
