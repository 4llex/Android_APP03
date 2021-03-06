package com.alex.app03_convidados.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alex.app03_convidados.R;
import com.alex.app03_convidados.constants.DataBaseConstants;
import com.alex.app03_convidados.constants.GuestConstants;
import com.alex.app03_convidados.model.Feedback;
import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.view.adapter.GuestAdapter;
import com.alex.app03_convidados.view.listener.OnListClick;
import com.alex.app03_convidados.viewmodel.AllGuestsViewModel;

import java.util.List;

public class AllGuestFragment extends Fragment {

    private AllGuestsViewModel mViewModel;
    private ViewHolder mViewHolder = new ViewHolder();
    private GuestAdapter mAdapter = new GuestAdapter();
    private int mFilter = 0;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //allGuestsViewModel = ViewModelProviders.of(this).get(AllGuestsViewModel.class); *Depricated
        this.mViewModel = new ViewModelProvider(this).get(AllGuestsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_all_guests, container, false);

        this.mViewHolder.recyclerGuests = root.findViewById(R.id.recycler_list);
        this.mViewHolder.recyclerGuests.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mViewHolder.recyclerGuests.setAdapter(this.mAdapter);

        OnListClick listener = new OnListClick() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(GuestConstants.GUESTID, id);

                Intent intent = new Intent(getContext(), GuestActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void onDelete(int id) {
                mViewModel.delete(id);
                mViewModel.getList(mFilter);
            }
        };
        this.mAdapter.attachListener(listener);

        if (getArguments() != null){
            this.mFilter = getArguments().getInt(GuestConstants.FILTER);
        }

        this.observers();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mViewModel.getList(this.mFilter);
    }

    private void observers() {

        this.mViewModel.guestList.observe(getViewLifecycleOwner(), new Observer<List<GuestModel>>() {
            @Override
            public void onChanged(List<GuestModel> list) {
                mAdapter.attachList(list);
            }
        });

        this.mViewModel.feedback.observe(getViewLifecycleOwner(), new Observer<Feedback>() {
            @Override
            public void onChanged(Feedback feedback) {
                Toast.makeText(getContext(), feedback.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private static class ViewHolder {
        RecyclerView recyclerGuests;
    }

}