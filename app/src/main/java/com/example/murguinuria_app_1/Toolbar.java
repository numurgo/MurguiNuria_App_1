package com.example.murguinuria_app_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Toolbar extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void cerrarSesion(View v){
        Intent intentvolverLogin = new Intent(this, Login.class);
        this.startActivity(intentvolverLogin);
    }


    @Override
    protected void onDestroy() {
        SharedPreferences prefsLogout= PreferenceManager.getDefaultSharedPreferences(this);
        prefsLogout.edit().clear().commit();
        super.onDestroy();
    }

    @Override
    protected void onPostResume() {
        SharedPreferences prefsLogout = PreferenceManager.getDefaultSharedPreferences(this);
        prefsLogout.edit().clear().commit();
        super.onPostResume();
    }
}
