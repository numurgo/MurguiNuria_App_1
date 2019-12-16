package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemData> itemsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //2. Definir el array
        itemsData = new ArrayList();
        itemsData.add(new ItemData("Nivel 1", "Armario", "Conduce el dron hasta la parte superior del armario y aterrízalo justo en el medio. ¡No lo aterrices bruscamente!", R.drawable.armario, true, 1));
        itemsData.add(new ItemData("Nivel 2", "Desnivel", "Hello", R.drawable.desnivel, false, 0.5f));
        itemsData.add(new ItemData("Nivel 3", "Circuito", "Hello", R.drawable.circuito, false, 0.5f));
        itemsData.add(new ItemData("Nivel 4", "Aterrizaje", "Hello", R.drawable.aterrizaje, false, 0.5f));
        itemsData.add(new ItemData("Nivel 5", "Transporte", "Hello", R.drawable.transporte, false, 0.5f));

        //3. Definir el LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //4. Crear un adapter
        MyAdapter mAdapter = new MyAdapter(itemsData, this);

        //5. Poner adapter
        recyclerView.setAdapter(mAdapter);

        //6. Poner animación por defecto
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
