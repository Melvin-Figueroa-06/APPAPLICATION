package com.example.app_aplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.app_aplication.Utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class PublicacionDetalles extends AppCompatActivity implements View.OnClickListener{
    TextView textDescripcion,textStock,textCategoria,textPrecio,textNombreV,textNombre,textEstado, textEmailV,textLike,textDisLike;
    ImageView imageV,imageFoto;
    Button btnCita,btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicacion_detalles);

        loadComponents();
        Intent intentProduct = getIntent();
        if (intentProduct.getExtras() != null ){
            getProduct(intentProduct.getExtras().getString("id"));
        }else{
            Toast.makeText(this, "Error al recibir parametros", Toast.LENGTH_LONG).show();
            finish();
        }

    }

    private void loadComponents() {
        //producto
        textCategoria = findViewById(R.id.textCategoria);
        textStock = findViewById(R.id.textStock);
        textDescripcion = findViewById(R.id.textDescripcion);
        textPrecio = findViewById(R.id.textPrecio);
        textEstado = findViewById(R.id.textEstado);
        textNombre = findViewById(R.id.textnombre);
        imageFoto = findViewById(R.id.imageFoto);
        //vendedor
        textNombreV = findViewById(R.id.textNombreV);
        textEmailV = findViewById(R.id.textEmailV);
        textLike = findViewById(R.id.textLike);
        textDisLike = findViewById(R.id.textDisLike);
        imageV = findViewById(R.id.imageV);

        btnChat = findViewById(R.id.btnChat);
        btnCita = findViewById(R.id.btnCita);
        btnChat.setOnClickListener(this);
        btnCita.setOnClickListener(this);

    }

    private void getProduct(String id) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Data.URL_PRODUCT + id,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {

                    if (response.getString("_id") != null){
                        setData(response);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    Toast.makeText(PublicacionDetalles.this, errorResponse.getString("error"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    Toast.makeText(PublicacionDetalles.this, "Exception on Failure method", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });


    }

    private void setData(JSONObject obj) throws JSONException {
        textDescripcion.setText(textDescripcion.getText() + obj.getString("descripcion"));
        textStock.setText(textStock.getText() + obj.getString("stock"));
        textPrecio.setText(textPrecio.getText() + obj.getString("precio"));
        textCategoria.setText(textCategoria.getText() + obj.getString("categoria"));
        textNombre.setText(textNombre.getText() + obj.getString("nombre"));
        textEstado.setText(textEstado.getText() + obj.getString("estado"));
        Glide.with(this).load(Data.HOST + obj.getString("foto" )).into(imageFoto);

        /*JSONObject vendedor = obj.getJSONObject("vendedor");


        textNombreV.setText(textNombreV.getText() + vendedor.getString("name"));
        textEmailV.setText(textEmailV.getText() + vendedor.getString("email"));
        textLike.setText(textLike.getText() + vendedor.getString("like"));
        textDisLike.setText(textDisLike.getText() + vendedor.getString("dislike"));
        if (vendedor.getString("avatar" ) != null) {
            Glide.with(this).load(Data.HOST + vendedor.getString("avatar")).into(imageV);
        }*/
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnChat){
            intent = new Intent(this,Chat.class);
        }else{
            intent = new Intent(this,Citas.class);

        }
        startActivity(intent);
    }
}
