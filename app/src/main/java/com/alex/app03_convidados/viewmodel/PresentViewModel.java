package com.alex.app03_convidados.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PresentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PresentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Presentes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}