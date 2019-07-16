package com.example.app_aplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter  extends BaseAdapter {

    private Context CONTEXT;
    private ArrayList<ItemList> LIST;

    public MyAdapter(Context context, ArrayList<ItemList> list){
        this.CONTEXT = context;
        this.LIST = list;
    }

    @Override
    public int getCount() {
        return this.LIST.size();
    }

    @Override
    public Object getItem(int position) {
        return this.LIST.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflate = (LayoutInflater) this.CONTEXT.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflate.inflate(R.layout.item, null);
        }
        ;
        ImageView image = convertView.findViewById(R.id.image_inicio);
        TextView name = convertView.findViewById(R.id.name);
        TextView description = convertView.findViewById(R.id.description);
        TextView stock = convertView.findViewById(R.id.stock);
        TextView estado = convertView.findViewById(R.id.estado);
        TextView categoria = convertView.findViewById(R.id.categoria);
        final TextView precio = convertView.findViewById(R.id.precio);


        name.setText(this.LIST.get(position).getName());
        description.setText(this.LIST.get(position).getDescription());
        stock.setText(this.LIST.get(position).getStock());
        estado.setText(this.LIST.get(position).getEstado());
        categoria.setText(this.LIST.get(position).getCategoria());
        precio.setText(this.LIST.get(position).getPrecio());
       // image.setImageBitmap(this.LIST.get(position).getImage());


        /*image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int q = (MyAdapter.this.LIST.get(position).get());
                if (q < 10){
                    MyAdapter.this.LIST.get(position).setQuanty((q+1));
                    quanty.setText(String.valueOf(MyAdapter.this.list.get(position).getQuanty()));
                }
                else {
                    Toast.makeText(context, "La Cantidad Maxima es de 10", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        return convertView;
    }

}
