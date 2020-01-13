package com.example.murguinuria_app_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class UsuariosSQLiteOpenHelper extends SQLiteOpenHelper {

    public UsuariosSQLiteOpenHelper(@Nullable Context context) {
        super(context, "usuarios_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String pass;

        db.execSQL("CREATE TABLE usuarios_table("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                "nombre TEXT NOT NULL, "+
                "usuario TEXT NOT NULL, "+
                "password TEXT NOT NULL, "+
                "nivel INT NOT NULL);");
        pass=obtenerCifrado("1111");
        db.execSQL("INSERT INTO usuarios_table(nombre,usuario,password, nivel) VALUES('Nuria', 'numurgo', '" + pass + "', '0');");
        pass=obtenerCifrado("2222");
        db.execSQL("INSERT INTO usuarios_table(nombre,usuario,password, nivel) VALUES('Alicia','almart', '" + pass + "', '0');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(String nombre, String usuario, String contraseña, int nivel){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("usuario", usuario);
        values.put("password", contraseña);
        values.put("nivel", nivel);
        db.insert("usuarios_table", null, values);
        db.close();
    }

    /*public void updateContact(String user, int nivelActualizado){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nivel", nivelActualizado);
        db.update("usuarios_table", values, "usuario=?", new String[]{user});
        db.close();
    }*/


    public static String obtenerCifrado(String cadena){
        byte[] cadenaEncriptada = null;
        byte[] cadenaSinEncriptar = cadena.getBytes();
        StringBuffer respuesta = new StringBuffer();

        try {
            MessageDigest procesa = MessageDigest.getInstance("SHA-512");
            procesa.reset();
            procesa.update(cadenaSinEncriptar);
            cadenaEncriptada = procesa.digest();
            for(int i=0; i< cadenaEncriptada.length; ++i){
                respuesta.append(Integer.toHexString(cadenaEncriptada[i] & 0XFF | 0x100).substring(1,3));
            }
            return respuesta.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }

}

