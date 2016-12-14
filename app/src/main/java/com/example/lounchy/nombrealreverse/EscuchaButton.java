package com.example.lounchy.nombrealreverse;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Nueva clase hay que crear si 1. Por su naturaleza 2. Por su funcionalidad
 * Clase creada para escuchar el button(por su funcionalidad).
 */

public class EscuchaButton implements View.OnClickListener {
    private Context context;

    public EscuchaButton(Context context) {
        Log.v(getClass().getCanonicalName(), "Ha entrado en el constructor EscuchaButton");
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Log.v(getClass().getCanonicalName(), "Has pulsado el boton");

        /**
         *No se muy bien que hago aqui, supongo que algo con MainActivity
         */
        Activity activity = (Activity) context;

        /**
         * Detecto el esditText en XML
         */
        EditText editText = (EditText) activity.findViewById(R.id.nombre_edit_text);

        /**
         * Defino --sacarNombre--
         * encuentra el texto de EditText
         */
        String sacarNombre = editText.getText().toString();

        Log.d(getClass().getCanonicalName(), "Has introducido el nombre: " + sacarNombre);

        /**
         * Defino --mensajeFinal--
         * encuentra el metodo --mensajeSalida-- en la clase StringMensaje
         */
        String mensajeFinal = StringMensaje.mensajeSalida(sacarNombre);

        /**
         *--------------------No lo se que estoy haciendo aqui
         */
        mostrarLayout(activity.findViewById(R.id.activity_main));

        /**
         *Defino --caja_resultado
         * encuentra LinearLayout con @id/resultado en activity_main
         */
        ViewGroup caja_resultado = (ViewGroup) activity.findViewById(R.id.resultado);
        if (caja_resultado.getChildCount() > 0) {

            /**
             * Detecto el TextView en XML
             */
            TextView textView = (TextView) activity.findViewById(R.id.mensaje_salida);

            /**
             * Creo 3 opciones de mensajes para diferentes casos
             */
            if (sacarNombre.length() > 1 && sacarNombre.length() < 16) {
                textView.setText(mensajeFinal);
            } else if (sacarNombre.length() > 16) {
                textView.setText("Ha producido un error!" + "\n" + "Su nombre es demasiado largo para generarlo.");
            } else {
                textView.setText("Ha producido un error!" + "\n" + "Para generar su nombre hace falta introducir más de una letra!");
            }


        } else {

            /**
             *--------------------No lo se que estoy haciendo aqui
             */
            LayoutInflater layoutInflater = activity.getLayoutInflater();

            /**
             *
             */
            View vista_inflada = layoutInflater.inflate(R.layout.mensaje_salida, caja_resultado);

            /**
             * Detecto el TextView en XML
             */
            TextView textView = (TextView) vista_inflada.findViewById(R.id.mensaje_salida);

            /**
             * Creo 3 opciones de mensajes para diferentes casos
             */
            if (sacarNombre.length() > 1 && sacarNombre.length() < 16) {
                textView.setText(mensajeFinal);
            } else if (sacarNombre.length() > 16) {
                textView.setText("Ha producido un error!" + "\n" + "Su nombre es demasiado largo para generarlo.");
            } else {
                textView.setText("Ha producido un error!" + "\n" + "Para generar su nombre hace falta introducir más de una letra!");
            }
        }
    }

    /**
     *--------------No lo se que estoy haciendo aqui.
     */
    private void mostrarLayout(View view) {
        Log.d(getClass().getCanonicalName(), view.getClass().getCanonicalName());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View vistaHija = viewGroup.getChildAt(i);
                mostrarLayout(vistaHija);
            }
        }
    }

}
