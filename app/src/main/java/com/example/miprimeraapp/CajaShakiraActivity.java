package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class CajaShakiraActivity extends AppCompatActivity {

    private int color_negro;
    private int n_cajas_tocadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caja_shakira);
        this.color_negro = getResources().getColor(R.color.black);

        dibujarFlechaAtras();
    }

    private void dibujarFlechaAtras() {
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

            case R.id.buscar:
                Log.d("MIAPP", "Ha tocado la opción de buscar");
                break;
        }

        return true;//super.onOptionsItemSelected(item);
    }

    //VERSION SHAKIRA
    public void cajaTocada2 (View view)
    {
        Log.d("MIAPP", "Caja Tocada");
        MiLinearLayout caja = (MiLinearLayout) view;//casting
        if (!caja.isTocado())
        {
            Log.d("MIAPP", "Tocada por primera vez");
            caja.setBackgroundColor(color_negro);//pongo negra la caja
            caja.setTocado(true);
            n_cajas_tocadas++;
            if (n_cajas_tocadas==8)
            {
                Log.d("MIAPP", "Se han tocado todas");
                finish();
            }

        } else {
            Log.d("MIAPP", "Ya se ha tocado la caja, no hago ná");
        }

    }
}
