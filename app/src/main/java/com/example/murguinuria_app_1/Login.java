package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends AppCompatActivity {

    EditText usuario;
    EditText password;
    TextView bRegistro;
    Button bLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        bRegistro = findViewById(R.id.bRegister);
        usuario = findViewById(R.id.usuarioLogin);
        password = findViewById(R.id.passwordLogin);
        bLogin = findViewById(R.id.bLogin);
    }

    @Override
    protected void onResume() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        super.onResume();
    }


    public void entrar(View v) {
        if (usuario.getText().toString().equals("") || password.getText().toString().equals("")) {
            Toast.makeText(Login.this, "Usuario o contraseña vacíos", Toast.LENGTH_LONG).show();
            return;
        } else {
            SQLiteDatabase db = new UsuariosSQLiteOpenHelper(Login.this).getReadableDatabase();
            String usuario = this.usuario.getText().toString();
            Cursor fila = db.rawQuery("SELECT password, nivel FROM usuarios_table WHERE usuario='" + usuario + "';", null);
            if (fila.moveToFirst() == true) {
                String pass = fila.getString(0);
                int nivel = fila.getInt(1);
                if (obtenerCifrado(password.getText().toString()).equals(pass)) {
                    this.usuario.setText("");
                    password.setText("");
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("user", usuario);
                    editor.putInt("level", nivel);
                    editor.apply();
                    Intent intentLogin = new Intent(Login.this, MainActivity.class);
                    Login.this.startActivity(intentLogin);
                } else {
                    Toast.makeText(Login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(Login.this, "El usuario no existe", Toast.LENGTH_LONG).show();
            }
            fila.close();
            db.close();
        }
    }

    public void Register(View v){
        Intent intentRegistro = new Intent(Login.this, Register.class);
        Login.this.startActivity(intentRegistro);
    }


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
