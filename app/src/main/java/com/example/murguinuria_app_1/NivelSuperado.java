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

<<<<<<< HEAD
    int nivelActual, nivelActivo, nivelSiguiente= 0;
=======
    int nivelActivo, nivelActual, nivelSiguiente= 0;
>>>>>>> 4ad12f7
    int defaultValue = 0;
    TextView titNivel, textoNivel, tituloActivity;
    ImageView imagenNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_superado);

        tituloActivity = findViewById(R.id.tituloPantalla);
<<<<<<< HEAD
        tituloActivity.setText("HISTORIA DEL NIVELES");
=======
        tituloActivity.setText("HISTORIA DEL NIVEL");
>>>>>>> 4ad12f7

        titNivel = findViewById(R.id.level_superado);
        textoNivel = findViewById(R.id.infoNivel);
        imagenNivel = findViewById(R.id.imagen_nivel_superado);

        Intent i = getIntent();
        nivelActivo = i.getIntExtra("level", defaultValue);

<<<<<<< HEAD
        SharedPreferences prefs0 = PreferenceManager.getDefaultSharedPreferences(NivelSuperado.this);
        nivelActual = prefs0.getInt("level", 0);
        nivelSuperado();
        Toast.makeText(this, nivelActual, Toast.LENGTH_SHORT).show();
=======
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(NivelSuperado.this);
        nivelActual = prefs.getInt("level", 0);
        nivelSuperado();

>>>>>>> 4ad12f7
    }


    public void volverNiveles(View v){
        if(nivelActual>nivelActivo) nivelSiguiente = nivelActual;
        if(nivelActual == nivelActivo) nivelSiguiente = nivelActual+1;

        SQLiteDatabase database = new UsuariosSQLiteOpenHelper(NivelSuperado.this).getWritableDatabase();
        String user;
<<<<<<< HEAD
        SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(NivelSuperado.this);
        SharedPreferences.Editor editor = prefs1.edit();
=======
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(NivelSuperado.this);
        SharedPreferences.Editor editor = prefs.edit();

>>>>>>> 4ad12f7
        editor.putInt("level", nivelSiguiente);
        editor.apply();
        user = prefs1.getString("user", "");

        //Acceder al método update y actualizar la base de datos
        ContentValues values = new ContentValues();
        values.put("nivel", nivelSiguiente);
        database.update("usuarios_table", values, "usuario=?", new String[]{user});
        database.close();

        Intent intentVolverNiveles = new Intent(NivelSuperado.this, MainActivity.class);
        NivelSuperado.this.startActivity(intentVolverNiveles);
        Toast.makeText(this, nivelSiguiente, Toast.LENGTH_SHORT).show();
    }


    public void nivelSuperado(){
        switch (nivelActivo){
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
<<<<<<< HEAD
=======


    public void cerrarSesion(View v){
        Intent intentvolverLogin = new Intent(NivelSuperado.this, Login.class);
        this.startActivity(intentvolverLogin);
    }

    @Override
    protected void onDestroy() {
        SharedPreferences prefsLogout= PreferenceManager.getDefaultSharedPreferences(NivelSuperado.this);
        prefsLogout.edit().clear().commit();
        super.onDestroy();
    }

    @Override
    protected void onPostResume() {
        SharedPreferences prefsLogout = PreferenceManager.getDefaultSharedPreferences(NivelSuperado.this);
        prefsLogout.edit().clear().commit();
        super.onPostResume();
    }

>>>>>>> 4ad12f7
}
