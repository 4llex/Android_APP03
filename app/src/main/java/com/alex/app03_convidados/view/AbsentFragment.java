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
import com.alex.app03_convidados.viewmodel.AbsentViewModel;

public class AbsentFragment extends Fragment {

    private AbsentViewModel absentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //this.absentViewModel = ViewModelProviders.of(this).get(AbsentViewModel.class); **Depricated code
        this.absentViewModel = new ViewModelProvider(this).get(AbsentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        final TextView textView = root.findViewById(R.id.text_slideshow);

        return root;
    }
}