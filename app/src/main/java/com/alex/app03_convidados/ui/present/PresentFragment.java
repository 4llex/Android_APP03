package com.alex.app03_convidados.ui.present;

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

public class PresentFragment extends Fragment {

    private PresentViewModel presentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        presentViewModel =
                ViewModelProviders.of(this).get(PresentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_present, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        presentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}