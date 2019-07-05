package com.example.app_aplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
    }

    private void loadComponents() {
        Button button_iniciar = findViewById(R.id.button_iniciar);
        button_iniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_iniciar:{
                Intent iniciar_sesion = new Intent(this,Ubicacion.class);
                startActivity(iniciar_sesion);
                break;
            }
        }
    }
}
