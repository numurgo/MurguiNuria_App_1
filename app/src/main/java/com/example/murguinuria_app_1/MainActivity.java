package com.example.murguinuria_app_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

    TextView tituloActivity;
    int nivel;
    ArrayList<ItemData> itemsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tituloActivity = findViewById(R.id.tituloPantalla);
        tituloActivity.setText("SELECTOR DE NIVELES");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //2. Definir el array
        itemsData = new ArrayList();
        itemsData.add(new ItemData("Nivel 1", "Armario", "Conduce el dron hasta la parte superior del armario y aterrízalo justo en el medio. ¡No lo aterrices bruscamente!", R.drawable.armario, 0, true, 1f));
        itemsData.add(new ItemData("Nivel 2", "Desnivel", "Hello", R.drawable.desnivel, 1,false, 0.5f));
        itemsData.add(new ItemData("Nivel 3", "Circuito", "Hello", R.drawable.circuito, 2, false, 0.5f));
        itemsData.add(new ItemData("Nivel 4", "Aterrizaje", "Hello", R.drawable.aterrizaje, 3, false, 0.5f));
        itemsData.add(new ItemData("Nivel 5", "Transporte", "Hello", R.drawable.transporte, 4, false, 0.5f));

        //3. Definir el LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //4. Crear un adapter
        MyAdapter mAdapter = new MyAdapter(itemsData, this);

        //5. Poner adapter
        recyclerView.setAdapter(mAdapter);

        //6. Poner animación por defecto
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Coger nivel del preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        nivel = prefs.getInt("level", 0);
        nivelOrigen();


    }

    public void nivelOrigen(){
        switch (nivel){
            case 0:
                itemsData.set(0, new ItemData("Nivel 1", "Armario", "Conduce el dron hasta la parte superior del armario y aterrízalo justo en el medio. ¡No lo aterrices bruscamente!", R.drawable.armario, 0, true, 1f));
                break;

            case 1:
                itemsData.set(0, new ItemData("Nivel 1", "Armario", "Conduce el dron hasta la parte superior del armario y aterrízalo justo en el medio. ¡No lo aterrices bruscamente!", R.drawable.armario, 0, true, 1f));
                itemsData.set(1, new ItemData("Nivel 2", "Desnivel", "Hello", R.drawable.desnivel, 1,true, 1f));
                break;

            case 2:
                itemsData.set(0, new ItemData("Nivel 1", "Armario", "Conduce el dron hasta la parte superior del armario y aterrízalo justo en el medio. ¡No lo aterrices bruscamente!", R.drawable.armario, 0, true, 1f));
                itemsData.set(1, new ItemData("Nivel 2", "Desnivel", "Hello", R.drawable.desnivel, 1,true, 1f));
                itemsData.set(2, new ItemData("Nivel 3", "Circuito", "Hello", R.drawable.circuito, 2, true, 1f));
                break;

            case 3:
                itemsData.set(0, new ItemData("Nivel 1", "Armario", "Conduce el dron hasta la parte superior del armario y aterrízalo justo en el medio. ¡No lo aterrices bruscamente!", R.drawable.armario, 0, true, 1f));
                itemsData.set(1, new ItemData("Nivel 2", "Desnivel", "Hello", R.drawable.desnivel, 1,true, 1f));
                itemsData.set(2, new ItemData("Nivel 3", "Circuito", "Hello", R.drawable.circuito, 2, true, 1f));
                itemsData.set(3, new ItemData("Nivel 4", "Aterrizaje", "Hello", R.drawable.aterrizaje, 3, true, 1f));
                break;
            case 4:
                itemsData.set(0, new ItemData("Nivel 1", "Armario", "Conduce el dron hasta la parte superior del armario y aterrízalo justo en el medio. ¡No lo aterrices bruscamente!", R.drawable.armario, 0, true, 1f));
                itemsData.set(1, new ItemData("Nivel 2", "Desnivel", "Hello", R.drawable.desnivel, 1,true, 1f));
                itemsData.set(2, new ItemData("Nivel 3", "Circuito", "Hello", R.drawable.circuito, 2, true, 1f));
                itemsData.set(3, new ItemData("Nivel 4", "Aterrizaje", "Hello", R.drawable.aterrizaje, 3, true, 1f));
                itemsData.set(4, new ItemData("Nivel 5", "Transporte", "Hello", R.drawable.transporte, 4, true, 1f));
                break;

        }
    }


}
