package com.example.murguinuria_app_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Nivel extends AppCompatActivity {

    ImageView imagenNivel;
    TextView nivel, instrucciones;

    String nivelRec, instruccionesRec;
    int imagenNivelRec;
    int defaultValue = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);

        imagenNivel = findViewById(R.id.imagen_nivel);
        nivel = findViewById(R.id.level);
        instrucciones = findViewById(R.id.instrucciones);

        Intent i = getIntent();
        nivelRec = i.getStringExtra("nivel");
        instruccionesRec = i.getStringExtra("instrucciones");
        imagenNivelRec = i.getIntExtra("imagen_url", defaultValue);

        imagenNivel.setImageResource(imagenNivelRec);
        nivel.setText(nivelRec);
        instrucciones.setText(instruccionesRec);
    }

    public void controles (View v){
        Intent intentNivel = new Intent(Nivel.this, Controles.class);
        Nivel.this.startActivity(intentNivel);
    }
}
