package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText nombre, usuario, password;

    UsuariosSQLiteOpenHelper dbusuarios = new UsuariosSQLiteOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = findViewById(R.id.nombreRegistro);
        usuario = findViewById(R.id.usuarioRegister);
        password = findViewById(R.id.passwordRegister);
    }

    public void addUser(View v){
        if (usuario.getText().toString().equals("")){
            Toast.makeText(this, "Usuario obligatorio,¡rellene este campo!", Toast.LENGTH_LONG).show();
        }else{
            String name = nombre.getText().toString();
            String user = usuario.getText().toString();
            String pass = password.getText().toString();
            String passCifrada = dbusuarios.obtenerCifrado(pass);
            int level = 0;
            dbusuarios.addContact(name, user, passCifrada, level);

            Intent intentRegister = new Intent(Register.this, Login.class);
            Register.this.startActivity(intentRegister);
        }

    }
}
