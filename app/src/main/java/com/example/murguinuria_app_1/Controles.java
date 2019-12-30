package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Controles extends AppCompatActivity {

    int nivelActivo;
    int defaultValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles);

        Intent i = getIntent();
        nivelActivo = i.getIntExtra("level", defaultValue);
    }

    public void nivelSuperado (View v){
        Intent intentNivelSuperado = new Intent(Controles.this, NivelSuperado.class);
        intentNivelSuperado.putExtra("level", nivelActivo);
        Controles.this.startActivity(intentNivelSuperado);
    }
}
