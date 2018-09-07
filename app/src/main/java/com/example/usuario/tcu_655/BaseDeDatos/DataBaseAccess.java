package com.example.usuario.tcu_655.BaseDeDatos;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DataBaseAccess instance;

    private DataBaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DataBaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<Datos> getCuriosidades() {
        List<Datos> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM curiosos", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Curiosos(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

public List<Datos> getConceptos() {
        List<Datos> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM conceptos", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
        list.add(new Conceptos(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
        cursor.moveToNext();
        }
        cursor.close();
        return list;
        }
}
