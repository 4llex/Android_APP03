package com.alex.app03_convidados.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alex.app03_convidados.constants.DataBaseConstants;

import androidx.annotation.Nullable;

public class GuestDataBaseHelper  extends SQLiteOpenHelper {

    private static String NAME = "convidados.bd";
    private static int VERSION = 1;

    // Query SQL para gerar a tabela
    private static final String CREATE_TABLE_GUEST = "create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
            + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
            + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
            + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);";

    public GuestDataBaseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Banco é criado
        db.execSQL(CREATE_TABLE_GUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualiza o banco com a versao mais nova
        String str = " ";
    }
}
