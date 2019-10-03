package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

public class IMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        dibujarFlechaAtras();

        ImageView imageView = findViewById(R.id.imagen_playa);
        imageView.setImageResource(R.drawable.playa);

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
