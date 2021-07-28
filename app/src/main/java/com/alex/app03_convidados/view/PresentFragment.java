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
import com.alex.app03_convidados.viewmodel.PresentViewModel;

public class PresentFragment extends Fragment {

    private PresentViewModel presentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //presentViewModel =ViewModelProviders.of(this).get(PresentViewModel.class);
        this.presentViewModel = new ViewModelProvider(this).get(PresentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_present, container, false);

        final TextView textView = root.findViewById(R.id.text_gallery);
        return root;
    }
}