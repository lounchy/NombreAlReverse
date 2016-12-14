package com.example.lounchy.nombrealreverse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         * IMPORTANTE Y FUNDAMENTAL
         * usar ---Log--- para un control mejor.
         */
        Log.v(getClass().getCanonicalName(), "Ha entrado en el metodo onCreate");

        /**
         * Llamando el metodo --onCreate-- de ---Padre---
         */
        super.onCreate(savedInstanceState);

        /**
         *Dentro de un --onCreate-- siempre hay que poner ---setContentView---
         * Mostra una XML
         */
        setContentView(R.layout.activity_main);

        /**
         * Detecto el boton en XML
         */
        Button button = (Button)findViewById(R.id.generar_button);

        /**
         *Defino la clase --EscuchaButton-- creando nuevo objeto
         */
        EscuchaButton escuchaButton = new EscuchaButton(this);      //--this es el objeto de MainActivity (la pantalla)

        /**
         *De forma explicita acossio al button la clase que se va encargar a escucharlo.
         */
        button.setOnClickListener(escuchaButton);

    }
}
