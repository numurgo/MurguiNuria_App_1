package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Controles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles);
    }

    public void nivelSuperado (View v){
        Intent intentNivelSuperado = new Intent(Controles.this, NivelSuperado.class);
        Controles.this.startActivity(intentNivelSuperado);
    }
}
