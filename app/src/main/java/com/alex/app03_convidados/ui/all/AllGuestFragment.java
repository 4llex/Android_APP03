package com.alex.app03_convidados.ui.all;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alex.app03_convidados.R;

public class AllGuestFragment extends Fragment {

    private AllGuestsViewModel allGuestsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        allGuestsViewModel = ViewModelProviders.of(this).get(AllGuestsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_all_guests, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        allGuestsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}