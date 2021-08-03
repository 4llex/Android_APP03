package com.alex.app03_convidados.viewmodel;

import android.app.Application;

import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.repository.GuestRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class GuestViewModel  extends AndroidViewModel {

    private GuestRepository mRepository;

    private MutableLiveData<GuestModel> mGuest = new MutableLiveData<>();
    public LiveData<GuestModel> gest = this.mGuest;

    private MutableLiveData<Boolean> mFeedback = new MutableLiveData<>();
    public LiveData<Boolean> feedback = this.mFeedback;

    public GuestViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());
    }

    public void save(GuestModel guest){
        if (guest.getId() == 0){
            this.mFeedback.setValue(this.mRepository.insert(guest));
        } else {
            this.mFeedback.setValue(this.mRepository.update(guest));
        }

    }

    public void load(int id){

        this.mGuest.setValue(this.mRepository.load(id));

    }
}
