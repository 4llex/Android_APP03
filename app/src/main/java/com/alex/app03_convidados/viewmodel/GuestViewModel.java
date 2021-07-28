package com.alex.app03_convidados.viewmodel;

import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.repository.GuestRepository;

import androidx.lifecycle.ViewModel;

public class GuestViewModel  extends ViewModel {

    public void save(GuestModel guest){
        new GuestRepository().insert(guest);
    }

}
