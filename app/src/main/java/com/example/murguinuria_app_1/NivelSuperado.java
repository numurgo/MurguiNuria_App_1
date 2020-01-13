package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NivelSuperado extends AppCompatActivity {

    int nivelActual, nivelSiguiente= 0;
    TextView titNivel, textoNivel;
    ImageView imagenNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_superado);

        titNivel = findViewById(R.id.level_superado);
        textoNivel = findViewById(R.id.infoNivel);
        imagenNivel = findViewById(R.id.imagen_nivel_superado);


        SharedPreferences prefs0 = PreferenceManager.getDefaultSharedPreferences(this);
        nivelActual = prefs0.getInt("level", 0);
        nivelSuperado();
    }


    public void volverNiveles(View v){
        nivelSiguiente = nivelActual+1;

        SQLiteDatabase database = new UsuariosSQLiteOpenHelper(NivelSuperado.this).getWritableDatabase();
        String user;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("level", nivelSiguiente);
        editor.apply();
        user = prefs.getString("user", "");

        //Acceder al método update y actualizar la base de datos
        ContentValues values = new ContentValues();
        values.put("nivel", nivelSiguiente);
        database.update("usuarios_table", values, "usuario=?", new String[]{user});
        database.close();

        Intent intentVolverNiveles = new Intent(NivelSuperado.this, MainActivity.class);
        NivelSuperado.this.startActivity(intentVolverNiveles);
    }


    public void nivelSuperado(){
        switch (nivelActual){
            case 0:
                titNivel.setText(R.string.level_1);
                textoNivel.setText(R.string.text_level_1);
                imagenNivel.setImageDrawable(getResources().getDrawable(R.drawable.muebles));
                break;

            case 1:
                titNivel.setText(R.string.level_2);
                textoNivel.setText(R.string.text_level_2);
                imagenNivel.setImageDrawable(getResources().getDrawable(R.drawable.sierra));
                break;

            case 2:
                titNivel.setText(R.string.level_3);
                textoNivel.setText(R.string.text_level_3);
                imagenNivel.setImageDrawable(getResources().getDrawable(R.drawable.circuito2));
                break;

            case 3:
                titNivel.setText(R.string.level_4);
                textoNivel.setText(R.string.text_level_4);
                imagenNivel.setImageDrawable(getResources().getDrawable(R.drawable.aterrizaje2));
                break;

            case 4:
                titNivel.setText(R.string.level_5);
                textoNivel.setText(R.string.text_level_5);
                imagenNivel.setImageDrawable(getResources().getDrawable(R.drawable.transporte2));
                break;
        }
    }

}
