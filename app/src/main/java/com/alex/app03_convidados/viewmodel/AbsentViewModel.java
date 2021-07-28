package com.alex.app03_convidados.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AbsentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AbsentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ausentes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}