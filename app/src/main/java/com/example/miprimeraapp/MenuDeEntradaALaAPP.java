package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MenuDeEntradaALaAPP extends AppCompatActivity {


    private static String RESPUESTA_BUENA1 = "caja activity";
    private static String RESPUESTA_BUENA2 = "caja shakira activity";
    private static String RESPUESTA_BUENA3 = "da la vuelta activity";
    private static String RESPUESTA_BUENA4 = "imagen activity";
    private static String RESPUESTA_BUENA5 = "imc activity";
    private static String RESPUESTA_BUENA6 = "mi linear layout";
    private static String RESPUESTA_BUENA7 = "version activity";
    private static String RESPUESTA_BUENA8 = "victotia activity";

    private static String URL_VIDEO_YOUTUBE = "https://youtube/Yxd5qU_XvKc";
    private static String PREGUNTA = "¿Qué quieres reina?";
    private MediaPlayer mediaPlayer;


    /**
     *
     * PARA DIBUJAR EL MENÚ
     * 1) DEFINO UN XML EN RES/MENU QUE REPRESENTA EL MENÚ
     * 2) SOBREESCRIBIR EL MÉTODO ONCREATEOPTIONSMENU
     * 3) PARA DETECTAR LOS EVENTOS DE MENÚ DEBO SOBREESCRIBIR EL onOptionsItemSelected
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_de_entrada_ala_app);

        dibujarFlechaAtras();

        //Ejemplo de Intent implícito: digo que quiero VER una WEB
        //ANDROID BUSCA LAS ACTIVIDADES CANDIDATAS Y PUEDEN PASAR 3 COSAS
        //1 Que no encuentre ninguna app en el movil capaz de llevar a cabo la acción
        //2 Que encuentre una app candidata --> abrirlo
        //3 Que encuentre más de una app candidata --> ¿con qué quieres abrirlo?

        /*
        String url = "http://www.marca.com";//Compongo la cadena;
        Intent intent = null;
        Uri uri = null;
        uri = Uri.parse(url);//y Su URI "Paso de String a URI"
        intent = new Intent(Intent.ACTION_VIEW, uri); //creo el intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            Log.d("MIAPP", "Hay al menos una app en el dispositivo " +
                    "que puede llevar a cabao esta acción");
            startActivity(intent);//lanzo la activida
        } else {
            Log.d("MIAPP", "NO una app en el dispositivo " +
                    "que puede llevar a cabao esta acción");
            Toast.makeText(this, "NO SE ENCUENTRA APP COMPATIBLE", Toast.LENGTH_SHORT).show();

        }
        */
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
                pregunta();
                break;
            case R.id.buscar:
                Log.d("MIAPP", "Ha tocado la opción de buscar");
                break;
        }

        return true;//super.onOptionsItemSelected(item);
    }

    //debo sobrrescribir este método para cargar mi menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();//este objeto será el encargado de cargar/inlfar mi menú
        mi.inflate(R.menu.menu_del_dia, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private void pregunta() {


        mediaPlayer = MediaPlayer.create(this, R.raw.pregunta_2);
        mediaPlayer.setLooping(false);
        mediaPlayer.setVolume(100, 100);

        Intent intent = new Intent
                (RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, PREGUNTA);
        startActivityForResult(intent, 200);

        mediaPlayer.start();
    }

    //METODO DONDE VUELVE EL MICROFONO
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                List<String> results = data.getStringArrayListExtra
                        (RecognizerIntent.EXTRA_RESULTS);
                String mAnswer = results.get(0).toLowerCase();

                Log.d("MIAPP", mAnswer);


                Intent intent;
                switch (mAnswer)
                {
                    case "caja activity":
                        Log.d("MITAPP", "RESPUESTA BUENA1");
                        Toast.makeText(this, "RESPUESTA BUENA1", Toast.LENGTH_SHORT).show();
                        //preparo el intent
                        intent = new Intent(this, CajaActivity.class);
                        //lanzo
                        startActivity(intent);
                        break;
                    case "caja shakira activity":
                        Log.d("MITAPP", "RESPUESTA BUENA2");
                        Toast.makeText(this, "RESPUESTA BUENA2", Toast.LENGTH_SHORT).show();
                        //preparo el intent
                        intent = new Intent(this, CajaShakiraActivity.class);
                        //lanzo
                        startActivity(intent);
                        break;
                    case "da la vuelta activity":
                        Log.d("MITAPP", "RESPUESTA BUENA3");
                        Toast.makeText(this, "RESPUESTA BUENA3", Toast.LENGTH_SHORT).show();
                        //preparo el intent
                        intent = new Intent(this, DaLaVueltaActivity.class);
                        //lanzo
                        startActivity(intent);
                        break;
                    case "IMC activity":
                        Log.d("MITAPP", "RESPUESTA BUENA4");
                        Toast.makeText(this, "RESPUESTA BUENA4", Toast.LENGTH_SHORT).show();
                        //preparo el intent
                        intent = new Intent(this, IMCActivity.class);
                        //lanzo
                        startActivity(intent);
                        break;
                    case "imagen activity":
                        Log.d("MITAPP", "RESPUESTA BUENA5");
                        Toast.makeText(this, "RESPUESTA BUENA5", Toast.LENGTH_SHORT).show();
                        //preparo el intent
                        intent = new Intent(this, ImagenActivity.class);
                        //lanzo
                        startActivity(intent);
                        break;
                    case "mi linear layout":
                        Log.d("MITAPP", "RESPUESTA BUENA6");
                        Toast.makeText(this, "RESPUESTA BUENA6", Toast.LENGTH_SHORT).show();
                        //preparo el intent
                        intent = new Intent(this, MiLinearLayout.class);
                        //lanzo
                        startActivity(intent);
                        break;
                    case "version activity":
                        Log.d("MITAPP", "RESPUESTA BUENA7");
                        Toast.makeText(this, "RESPUESTA BUENA7", Toast.LENGTH_SHORT).show();
                        //preparo el intent
                        intent = new Intent(this, VersionActivity.class);
                        //lanzo
                        startActivity(intent);
                        break;
                    case "victoria activity":
                        Log.d("MITAPP", "RESPUESTA BUENA8");
                        Toast.makeText(this, "RESPUESTA BUENA8", Toast.LENGTH_SHORT).show();
                        //preparo el intent
                        intent = new Intent(this, VictoriaActivity.class);
                        //lanzo
                        startActivity(intent);
                        break;
                     default:
                         Log.d("MIAPP", "RESPUESTA MALA");
                         Toast.makeText(this, "RESPUESTA MALA", Toast.LENGTH_SHORT).show();
                         mediaPlayer = MediaPlayer.create(this, R.raw.dennis_2);
                         mediaPlayer.setLooping(false);
                         mediaPlayer.setVolume(100, 100);
                         mediaPlayer.start();
                }
            }
        }
    }

    public void botonMenuTocado(View view) {
        Log.d("MIAPP", "BOTON MENU TOCADO");

        RadioButton radioButtonTocado = (RadioButton) view;//casting

        String actividad = String.valueOf(radioButtonTocado.getText());
        Intent intent;
        switch (actividad)
        {
            case "CajaActivity":
                Log.d("MITAPP", "RESPUESTA BUENA1");
                Toast.makeText(this, "RESPUESTA BUENA1", Toast.LENGTH_SHORT).show();
                //preparo el intent
                intent = new Intent(this, CajaActivity.class);
                //lanzo
                startActivity(intent);
                break;
            case "cajaShakiraActivity":
                Log.d("MITAPP", "RESPUESTA BUENA2");
                Toast.makeText(this, "RESPUESTA BUENA2", Toast.LENGTH_SHORT).show();
                //preparo el intent
                intent = new Intent(this, CajaShakiraActivity.class);
                //lanzo
                startActivity(intent);
                break;
            case "DaLaVueltaActivity":
                Log.d("MITAPP", "RESPUESTA BUENA3");
                Toast.makeText(this, "RESPUESTA BUENA3", Toast.LENGTH_SHORT).show();
                //preparo el intent
                intent = new Intent(this, DaLaVueltaActivity.class);
                //lanzo
                startActivity(intent);
                break;
            case "IMCActivity":
                Log.d("MITAPP", "RESPUESTA BUENA4");
                Toast.makeText(this, "RESPUESTA BUENA4", Toast.LENGTH_SHORT).show();
                //preparo el intent
                intent = new Intent(this, IMCActivity.class);
                //lanzo
                startActivity(intent);
                break;
            case "ImagenActivity":
                Log.d("MITAPP", "RESPUESTA BUENA5");
                Toast.makeText(this, "RESPUESTA BUENA5", Toast.LENGTH_SHORT).show();
                //preparo el intent
                intent = new Intent(this, ImagenActivity.class);
                //lanzo
                startActivity(intent);
                break;
            case "MiLinearLayout":
                Log.d("MITAPP", "RESPUESTA BUENA6");
                Toast.makeText(this, "RESPUESTA BUENA6", Toast.LENGTH_SHORT).show();
                //preparo el intent
                intent = new Intent(this, MiLinearLayout.class);
                //lanzo
                startActivity(intent);
                break;
            case "VersionActivity":
                Log.d("MITAPP", "RESPUESTA BUENA7");
                Toast.makeText(this, "RESPUESTA BUENA7", Toast.LENGTH_SHORT).show();
                //preparo el intent
                intent = new Intent(this, VersionActivity.class);
                //lanzo
                startActivity(intent);
                break;
            case "VictoriaActivity":
                Log.d("MITAPP", "RESPUESTA BUENA8");
                Toast.makeText(this, "RESPUESTA BUENA8", Toast.LENGTH_SHORT).show();
                //preparo el intent
                intent = new Intent(this, VictoriaActivity.class);
                //lanzo
                startActivity(intent);
                break;
            default:
                Log.d("MIAPP", "RESPUESTA MALA");
                Toast.makeText(this, "RESPUESTA MALA", Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(this, R.raw.dennis_2);
                mediaPlayer.setLooping(false);
                mediaPlayer.setVolume(100, 100);
                mediaPlayer.start();
        }
    }
}

