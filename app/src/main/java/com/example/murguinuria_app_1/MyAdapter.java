package com.example.murguinuria_app_1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<ItemData> itemsData;
    Context mContext;

    public MyAdapter(ArrayList<ItemData> itemsData, Context mContext) {
        this.itemsData = itemsData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Crea un item con imagen y texto
        //Es un poco como el start activity y el putExtra(), que pasa los parámetros
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null);
        MyViewHolder viewHolder = new MyViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nivel.setText(itemsData.get(position).getNivel());
        holder.tituloNivel.setText(itemsData.get(position).getTituloNivel());
        holder.imagenNivel.setImageResource(itemsData.get(position).getImageUrl());
        holder.nivel.setClickable(itemsData.get(position).isActive());
        holder.niveles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Nivel.class);
                intent.putExtra("nivel", itemsData.get(position).getNivel());
                intent.putExtra("instrucciones", itemsData.get(position).getInstrucciones());
                intent.putExtra("imagen_url", itemsData.get(position).getImageUrl());
                //intent.putExtra("active", itemsData.get(position).isActive());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nivel, tituloNivel;
        ImageView imagenNivel;
        CardView niveles;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            niveles = itemView.findViewById(R.id.niveles);
            nivel = itemView.findViewById(R.id.level);
            tituloNivel = itemView.findViewById(R.id.tit_level);
            imagenNivel = itemView.findViewById(R.id.imagen_nivel);
    }
    }
}
