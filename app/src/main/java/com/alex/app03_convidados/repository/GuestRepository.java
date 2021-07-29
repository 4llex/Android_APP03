package com.alex.app03_convidados.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alex.app03_convidados.constants.DataBaseConstants;
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

    public GuestModel load(int id){
        try {
            SQLiteDatabase db = this.mHelper.getReadableDatabase();

            GuestModel guest = null;
            String table = DataBaseConstants.GUEST.TABLE_NAME;
            String[] columns = {DataBaseConstants.GUEST.COLUMNS.ID,
                                DataBaseConstants.GUEST.COLUMNS.NAME,
                                DataBaseConstants.GUEST.COLUMNS.PRESENCE};

            String selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};

            Cursor cursor = db.query(table, columns, selection, selectionArgs, null, null, null);
            if (cursor != null && cursor.getCount() > 0){
                cursor.moveToFirst();

                String name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME));
                int presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE));

                guest = new GuestModel(id, name, presence);
            }

            if (cursor != null){
                cursor.close();
            }
            return guest;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(GuestModel guest){
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.getName());
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.getConfirmation());

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(GuestModel guest){

        try{
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.getName());
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.getConfirmation());

            String where = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] args = {String.valueOf(guest.getId())};

            db.update(DataBaseConstants.GUEST.TABLE_NAME, values, where, args);
            db.close();
            return true;
        } catch (Exception e){
            return false;
        }

    }

    public boolean delete(int id){

        try{
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            String where = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] args = {String.valueOf(id)};

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, where, args);
            db.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
