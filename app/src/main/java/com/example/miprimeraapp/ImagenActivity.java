package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ImagenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        dibujarFlechaAtras();

        //setear imagen
        ImageView imagen_pantera = findViewById(R.id.pantera);
        imagen_pantera.setImageResource(R.drawable.pantera_rosa);

        //TODO ATRIBUTOS DE VISIBILIDAD DE UNA IMAGEN o vista

       // imagen_pantera.setVisibility(View.VISIBLE);//estado original
        imagen_pantera.setVisibility(View.INVISIBLE);//está pero no se vé
        imagen_pantera.setVisibility(View.GONE);//se elimina del XML
        imagen_pantera.setVisibility(View.VISIBLE);//estado original

        
//




        //RESOLUCIONES https://stackoverflow.com/a/37321194

    }

    private void dibujarFlechaAtras(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//dibujo la flecha

    }

    //ESTE MÉTODO SE INVOCA AL TOCAR UNA OPCIÓN DEL MENÚ
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("MIAPP", "Se ha tocado un elemento de la barra/menú");

        switch (item.getItemId())
        {
            case android.R.id.home:
                Log.d("MIAPP", "Ha tocado la flecha de para atrás");
                finish();
                break;
            case R.id.voz:
                Log.d("MIAPP", "Ha tocado la opción de voz");
                break;
            case R.id.buscar:
                Log.d("MIAPP", "Ha tocado la opción de buscar");
                break;
        }

        return true;//super.onOptionsItemSelected(item);
    }

}
