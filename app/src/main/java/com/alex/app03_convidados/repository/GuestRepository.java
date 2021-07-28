package com.alex.app03_convidados.repository;

import android.content.Context;

import com.alex.app03_convidados.model.GuestModel;

import java.util.ArrayList;
import java.util.List;

public class GuestRepository {

    // Padrao singleton - design pattern
    private static GuestRepository INSTANCE;
    public GuestDataBaseHelper mHelper;

    private GuestRepository(Context context){
        this.mHelper = new GuestDataBaseHelper(context);
    }

    public static GuestRepository getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new GuestRepository(context);
        }
        return INSTANCE;
    }






    // CRUD - create, read, update, delete
    public List<GuestModel> getList(){
        mHelper.getReadableDatabase();
        return new ArrayList<>();
    }

    public void insert(GuestModel guest){

    }

    public void update(GuestModel guest){

    }

    public void delete(GuestModel guest){

    }


}
