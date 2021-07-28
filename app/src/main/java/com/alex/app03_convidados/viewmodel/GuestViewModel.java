package com.alex.app03_convidados.viewmodel;

import android.app.Application;

import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.repository.GuestRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class GuestViewModel  extends AndroidViewModel {

    private GuestRepository mRepository;

    public GuestViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());
    }

    public void save(GuestModel guest){
        this.mRepository.insert(guest);
    }

}
