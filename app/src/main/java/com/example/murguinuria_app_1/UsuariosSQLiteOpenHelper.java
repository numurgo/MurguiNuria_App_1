package com.example.murguinuria_app_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UsuariosSQLiteOpenHelper extends SQLiteOpenHelper {

    public UsuariosSQLiteOpenHelper(@Nullable Context context) {
        super(context, "usuarios_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contactos_table("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                "nombre TEXT NOT NULL, "+
                "usuario TEXT NOT NULL, "+
                "passowrd TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(String nombre, String usuario, String contraseña){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("usuario", usuario);
        values.put("password", contraseña);
        db.insert("usuarios_table", null, values);
        db.close();
    }

  /*  public List<Usuarios> getUsuario(){
        List<Usuarios> resultat = new ArrayList<>();
        Usuarios usuario;

        SQLiteDatabase db = getReadableDatabase();

        //Servix per a navegar per els elements de la base de daes
        Cursor cursor = db.query("usuarios_table", new String[]{"nombre", "usuario", "password"}, null, null, null, null, "Nombre", null);
        while (cursor.moveToNext()){
            usuario = new Usuarios(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2));
            resultat.add(usuario);
        }
        cursor.close();
        db.close();
        return resultat;
    }*/
}

