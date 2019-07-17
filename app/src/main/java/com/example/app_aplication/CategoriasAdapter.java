package com.example.app_aplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_aplication.Utils.Data;

import java.util.ArrayList;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.ViewHolder> {

    ArrayList<ItemCategorias> listData;
    Context context;

    public CategoriasAdapter(Context context, ArrayList<ItemCategorias> listData) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categorias,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriasAdapter.ViewHolder holder, final int position) {
        holder.setData(listData.get(position),position);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PublicacionDetalles.class);
                intent.putExtra("id",listData.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return  listData == null ? 0:listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageFoto;
        TextView textDescripcion,textStock,textPrecio;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFoto = itemView.findViewById(R.id.imageFoto);
            textDescripcion = itemView.findViewById(R.id.textDescripcion);
            textStock = itemView.findViewById(R.id.textStock);
            textPrecio = itemView.findViewById(R.id.textPrecio);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }


        public void setData(ItemCategorias itemProduct, int position) {
            textDescripcion.setText(itemProduct.getDescripcion());
            textStock.setText(itemProduct.getStock().toString());
            textPrecio.setText(itemProduct.getPrecio().toString());
            Glide.with(context).load(Data.HOST + itemProduct.getFoto()).into(imageFoto);
        }
    }
}
