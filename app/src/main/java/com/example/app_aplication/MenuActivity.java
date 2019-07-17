package com.example.app_aplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        loadComponents();
    }

    private void loadComponents() {
        Button btn1 = findViewById(R.id.inicio);
        Button btn2 = findViewById(R.id.publicacion);
        Button btn3 = findViewById(R.id.perfil);
        Button btn4 = findViewById(R.id.categorias);
        Button btn5 = findViewById(R.id.anuncios);
        Button btn6 = findViewById(R.id.citas);
        Button btn7 = findViewById(R.id.favoritos);
        Button btn8 = findViewById(R.id.ayuda);
        Button btn9 = findViewById(R.id.ajustes);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inicio:{
                Intent actividad1 = new Intent(this, Inicio.class);
                actividad1.putExtra("msn","Vamos a la actividad 1-----HOLA SOY MELVIN");
                startActivity(actividad1);
                break;
            }
            case R.id.publicacion:{
                Intent actividad2 = new Intent(this, Publicando.class);
                actividad2.putExtra("msn","Vamos a la actividad 2");
                startActivity(actividad2);
                break;
            }
            case R.id.perfil:{
                Intent actividad3 = new Intent(this, Perfil.class);
                actividad3.putExtra("msn","Vamos a la actividad 3");
                startActivity(actividad3);
                break;
            }
            case R.id.categorias:{
                Intent actividad4 = new Intent(this, Categorias.class);
                actividad4.putExtra("msn","Vamos a la actividad 4");
                startActivity(actividad4);
                break;
            }
            case R.id.anuncios:{
                Intent actividad5 = new Intent(this, Anuncios.class);
                actividad5.putExtra("msn","Vamos a la actividad 1-----HOLA SOY MELVIN");
                startActivity(actividad5);
                break;
            }
            case R.id.citas:{
                Intent actividad6 = new Intent(this, Citas.class);
                actividad6.putExtra("msn","Vamos a la actividad 1-----HOLA SOY MELVIN");
                startActivity(actividad6);
                break;
            }
            case R.id.favoritos:{
                Intent actividad7 = new Intent(this, Favoritos.class);
                actividad7.putExtra("msn","Vamos a la actividad 1-----HOLA SOY MELVIN");
                startActivity(actividad7);
                break;
            }
            case R.id.ayuda:{
                Intent actividad8 = new Intent(this, Ayuda.class);
                actividad8.putExtra("msn","Vamos a la actividad 1-----HOLA SOY MELVIN");
                startActivity(actividad8);
                break;
            }
            case R.id.ajustes:{
                Intent actividad9 = new Intent(this, Ajustes.class);
                actividad9.putExtra("msn","Vamos a la actividad 1-----HOLA SOY MELVIN");
                startActivity(actividad9);
                break;
            }
        }
    }

    private Boolean checkPermission(String permisso){
        if (Build.VERSION.SDK_INT  >= Build.VERSION_CODES.M){
            Integer result = this.checkSelfPermission(permisso);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private  void startCallPhone(){

    }
}

