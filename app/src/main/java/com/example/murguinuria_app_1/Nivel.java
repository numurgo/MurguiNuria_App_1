package com.example.murguinuria_app_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Nivel extends AppCompatActivity {

    ImageView imagenNivel;
    TextView nivel, instrucciones, tituloActivity;

    String nivelRec, instruccionesRec;
    int imagenNivelRec;
    int levelRec;
    int defaultValue = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);

        imagenNivel = findViewById(R.id.imagen_nivel);
        nivel = findViewById(R.id.level);
        instrucciones = findViewById(R.id.instrucciones);
        tituloActivity = findViewById(R.id.tituloPantalla);
        tituloActivity.setText("NIVEL");

        Intent i = getIntent();
        nivelRec = i.getStringExtra("nivel");
        instruccionesRec = i.getStringExtra("instrucciones");
        imagenNivelRec = i.getIntExtra("imagen_url", defaultValue);
        levelRec = i.getIntExtra("level", defaultValue);

        imagenNivel.setImageResource(imagenNivelRec);
        nivel.setText(nivelRec);
        instrucciones.setText(instruccionesRec);

        SharedPreferences prefsNivel = PreferenceManager.getDefaultSharedPreferences(Nivel.this);
    }

    public void controles (View v){
        Intent intentNivel = new Intent(Nivel.this, Controles.class);
        intentNivel.putExtra("level", levelRec);
        Nivel.this.startActivity(intentNivel);
    }
}
