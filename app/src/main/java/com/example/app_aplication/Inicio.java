package com.example.app_aplication;

import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_aplication.Utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Inicio extends AppCompatActivity {

    private ArrayList<String> id_products;
    private View mFA;

    private ListView LIST;
    private ArrayList<ItemList> LISTINFO;
    private MyAdapter ADAPTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();            //avisara si esta consumiendo muchos recursos en el celular
        StrictMode.setThreadPolicy(policy);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //loadDAta();
        loadComponents();


        LISTINFO = new ArrayList<ItemList>();
    }

    private void loadDAta(String keystr) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Data.PUBLICADO_SERVICE + Data.ID_PUBLICACION, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray list = response.getJSONArray("search");
                    for (int i = 0; i < list.length(); i++){
                        JSONObject itemJson = list.getJSONObject(i);
                        String name = itemJson.getString("nombre");
                        String precio = itemJson.getString("precio");
                        String descripcion = itemJson.getString("descripcion");
                        String stock = itemJson.getString("stock");
                        String categoria = itemJson.getString("categoria");
                        String image = itemJson.getString("foto");
                        String estado = itemJson.getString("estado");

                        ItemList item  = new ItemList(categoria, image, name, descripcion, precio, stock, estado );
                    }
                    JSONObject obj = list.getJSONObject(0);
                    JSONArray idproduct = obj.getJSONArray("idpublicacion");
                    for (int i = 0; i< idproduct.length(); i++){
                        id_products.add(idproduct.getString(i));
                    }
                    loadComponents();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse){
                Toast.makeText(new Inicio(), "Error", Toast.LENGTH_SHORT).show();
                loadComponents();
                Toast.makeText(new Inicio(), id_products.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadComponents() {



        LIST = findViewById(R.id.listView);
        ADAPTER = new MyAdapter(this, LISTINFO);

        EditText search = (EditText)this.findViewById(R.id.search);
        //eventos
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                loadDAta(str);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        LIST .setAdapter(ADAPTER);

        ListView list = findViewById(R.id.listView);
        ArrayList<String> datoslist = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            datoslist.add("Item" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datoslist);
        list.setAdapter(adapter);
    }



}
