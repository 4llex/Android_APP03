package com.alex.app03_convidados.repository;

import com.alex.app03_convidados.model.GuestModel;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GuestDAO {

    @Insert
    long insert(GuestModel guest);

    @Update
    int update(GuestModel guest);

    @Delete
    int delete(GuestModel guest);

    @Query("SELECT * from guest WHERE id = :id")
    GuestModel load(int id);

    @Query("SELECT * from guest")
    List<GuestModel> getAll();

    @Query("SELECT * from guest WHERE confirmation = :confirmation")
    List<GuestModel> getListByPresence(int confirmation);


}
