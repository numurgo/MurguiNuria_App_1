package com.example.murguinuria_app_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Toolbar extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentvolverLogin = new Intent(this, Login.class);
        this.startActivity(intentvolverLogin);
    }

    @Override
    protected void onDestroy() {
        getSharedPreferences("YOUR_PREFS", 0).edit().clear().commit();
        super.onDestroy();
    }

    @Override
    protected void onPostResume() {
        getSharedPreferences("YOUR_PREFS", 0).edit().clear().commit();
        super.onPostResume();
    }
}
