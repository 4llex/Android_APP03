package com.alex.app03_convidados.view.viewholder;

import android.view.View;
import android.widget.TextView;

import com.alex.app03_convidados.R;
import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.view.listener.OnListClick;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GuestViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;

    public GuestViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);
    }

    public void  bind(final GuestModel guest, final OnListClick listener){
        this.mTextName.setText(guest.getName());

        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(guest.getId());
            }
        });

    }

}
