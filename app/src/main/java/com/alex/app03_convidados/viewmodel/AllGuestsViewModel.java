package com.alex.app03_convidados.viewmodel;

import android.app.Application;

import com.alex.app03_convidados.model.Feedback;
import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.repository.GuestRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllGuestsViewModel extends AndroidViewModel {

    private GuestRepository mRepository;

    private MutableLiveData<List<GuestModel>> mGuestList = new MutableLiveData<>();
    public LiveData<List<GuestModel>> guestList = this.mGuestList;

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;

    public AllGuestsViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());
    }

    public void getList(){
        this.mGuestList.setValue(this.mRepository.getList());
    }

    public void delete(int id){
        if (this.mRepository.delete(id)){
            this.mFeedback.setValue(new Feedback("Convidado removido com sucesso!"));
        } else {
            this.mFeedback.setValue(new Feedback("Erro inesperado!", false));
        }
    }

}