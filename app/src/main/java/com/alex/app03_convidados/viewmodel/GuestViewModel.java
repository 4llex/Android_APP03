package com.alex.app03_convidados.viewmodel;

import android.app.Application;

import com.alex.app03_convidados.model.Feedback;
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

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;

    public GuestViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());
    }

    public void save(GuestModel guest){

        if ("".equals(guest.getName())) {
            this.mFeedback.setValue(new Feedback("Nome obrigatorio!", false));
            return;
        }

        if (guest.getId() == 0){
            if (this.mRepository.insert(guest)) {
                this.mFeedback.setValue(new Feedback("Convidado inserido com sucesso!"));
            } else {
                this.mFeedback.setValue(new Feedback("Erro inesperado!", false));
            }
        } else {
            if (this.mRepository.update(guest)) {
                this.mFeedback.setValue(new Feedback("Convidado atualizado com sucesso!"));
            } else {
                this.mFeedback.setValue(new Feedback("Erro inesperado!", false));
            }
        }

    }

    public void load(int id){

        this.mGuest.setValue(this.mRepository.load(id));

    }
}
