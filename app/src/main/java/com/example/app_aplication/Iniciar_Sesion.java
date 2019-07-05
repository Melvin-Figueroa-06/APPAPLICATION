package com.example.app_aplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Iniciar_Sesion extends AppCompatActivity {

    Button login;
    Button Iniciar_sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar__sesion);
        login = findViewById(R.id.login);
        Iniciar_sesion.findViewById(R.id.Iniciar_sesion);
        Iniciar_sesion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(Iniciar_Sesion.this,Registro.class));
                finish();
            }

        });
    }
}
