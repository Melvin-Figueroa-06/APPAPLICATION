package com.example.app_aplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.app_aplication.Utils.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Registrandose extends AppCompatActivity{

    ArrayList<String> tipo;

    EditText nameEdit, emailEdit, passwordEdit, addressEdit;
    Button Buttonregister;
    Spinner tipoSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrandose);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            setSpinner();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Registrando espere por favor", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                sendData();
               // loadComponents();
                //register();
            }


        });
    }


    private void sendData() {

        TextView correo  = findViewById(R.id.email);
        TextView password  = findViewById(R.id.password);
        if (correo.getText().toString().equals(" ")  || password.getText().toString().equals("")){
            Toast.makeText(this,"Es necesario llenar los  campos",Toast.LENGTH_SHORT).show();
            return;

        }



        EditText names = findViewById(R.id.name);
        EditText emails = findViewById(R.id.email);
        EditText passwords = findViewById(R.id.password);
        EditText address = findViewById(R.id.calle);
        Spinner tipos = findViewById(R.id.tipo);


        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("name", names.getText().toString());
        params.add("email", emails.getText().toString());
        params.add("password", passwords.getText().toString());
        params.add("address", address.getText().toString());
        params.add("tipo", tipo.get(tipos.getSelectedItemPosition()));

        client.post(Data.REGISTER_SERVICE, params, new JsonHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                if (response.has("roles")){
                    Toast.makeText(Registrandose.this,"Usuario Registrado", Toast.LENGTH_LONG).show();
                    Intent menu = new Intent(Registrandose.this, DrawerActivity.class);
                    startActivity(menu);
                }

                /*
                try {
                    String msj = response.getString("message");
                    if (msj != null){
                        //datos de usuario
                        Toast.makeText(Registrandose.this, msj, Toast.LENGTH_SHORT).show();
                        Registrandose.this.finish();

                    }else{
                        Toast.makeText(Registrandose.this, response.getString("error"), Toast.LENGTH_LONG).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }*/


            }
            /*
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
            }*/
        });


    }

    private void setSpinner() {


        tipo = new ArrayList<>();
        tipo.add("Comprador");
        tipo.add("Vendedor");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tipo);
        Spinner spinner = findViewById(R.id.tipo);
        spinner.setAdapter(adapter);
    }




}


