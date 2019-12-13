package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText usuario, password;
    TextView bRegistro;
    Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bRegistro = findViewById(R.id.bRegister);
        bRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegistro = new Intent(Login.this, Register.class);
                Login.this.startActivity(intentRegistro);
            }
        });

        usuario = findViewById(R.id.usuarioLogin);
        password = findViewById(R.id.passwordLogin);
        bLogin = findViewById(R.id.bLogin);
    }


    public void entrar(View v){
        Intent entrar = new Intent(this, MainActivity.class);
        startActivity(entrar);
    }


}
