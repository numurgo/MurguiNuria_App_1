package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class Controles extends AppCompatActivity {

   TextView tituloActivity;
    int nivelActivo;
    int defaultValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles);

        tituloActivity = findViewById(R.id.tituloPantalla);
        tituloActivity.setText("CONTROLES");
        Intent i = getIntent();
        nivelActivo = i.getIntExtra("level", defaultValue);

    }


    public void nivelSuperado (View v){
        Intent intentNivelSuperado = new Intent(Controles.this, NivelSuperado.class);
        intentNivelSuperado.putExtra("level", nivelActivo);
        Controles.this.startActivity(intentNivelSuperado);
    }


    public void cerrarSesion(View v){
        Intent intentvolverLogin = new Intent(Controles.this, Login.class);
        this.startActivity(intentvolverLogin);
    }

    @Override
    protected void onDestroy() {
        SharedPreferences prefsLogout= PreferenceManager.getDefaultSharedPreferences(Controles.this);
        prefsLogout.edit().clear().commit();
        super.onDestroy();
    }

    @Override
    protected void onPostResume() {
        SharedPreferences prefsLogout = PreferenceManager.getDefaultSharedPreferences(Controles.this);
        prefsLogout.edit().clear().commit();
        super.onPostResume();
    }
}
