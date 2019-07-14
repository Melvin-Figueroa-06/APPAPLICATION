package com.example.app_aplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    ArrayList<String> sexo;
    ArrayList<String> tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        setSpinner();
    }

    private void setSpinner() {

        sexo = new ArrayList<>();
        sexo.add("Hombre");
        sexo.add("Mujer");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sexo);
        Spinner spinner = findViewById(R.id.sex);
        spinner.setAdapter(adapter);
        //spinner.getSelectedItemPosition();


        tipo = new ArrayList<>();
        tipo.add("Comprador");
        tipo.add("Vendedor");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tipo);
        Spinner spinner1 = findViewById(R.id.tipo);
        spinner.setAdapter(adapter);
        //spinner.getSelectedItemPosition();
    }
}
