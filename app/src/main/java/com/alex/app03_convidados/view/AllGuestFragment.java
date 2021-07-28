package com.alex.app03_convidados.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.alex.app03_convidados.R;
import com.alex.app03_convidados.viewmodel.AllGuestsViewModel;

public class AllGuestFragment extends Fragment {

    private AllGuestsViewModel allGuestsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //allGuestsViewModel = ViewModelProviders.of(this).get(AllGuestsViewModel.class); *Depricated
        this.allGuestsViewModel = new ViewModelProvider(this).get(AllGuestsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_all_guests, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        return root;
    }
}