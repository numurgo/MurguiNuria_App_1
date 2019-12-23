package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class NivelSuperado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_superado);
    }

    public void volverNiveles(View v){
        Intent intentVolverNiveles = new Intent(NivelSuperado.this, MainActivity.class);
        NivelSuperado.this.startActivity(intentVolverNiveles);
    }

    ArrayList<ItemData> itemsData = new ArrayList<>();
    MainActivity mainActivity = new MainActivity();
    itemsData = mainActivity.getItemsData()


    private ArrayList<ItemData> newArrayList = null;
    newArrayList = MainActivity.getArrayList();

   // public ArrayList<ItemData> newArray = MainActivity.getItemsData();
}
