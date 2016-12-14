package com.example.lounchy.nombrealreverse;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Menchu y Dainis on 13/12/2016.
 */

public class EscuchaButton implements View.OnClickListener {
    private Context context;

    public EscuchaButton(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Activity activity = (Activity) context;
        EditText editText = (EditText) activity.findViewById(R.id.nombre_edit_text);
        String nombre = editText.getText().toString();
        String mensaje = mensajeSalida(nombre);
        TextView textView = (TextView) activity.findViewById(R.id.generar_text_view);

        if (nombre.length() > 1) {
            textView.setText(mensaje);
        } else if (nombre.length() > 16) {
            textView.setText("Ha producido un error!" + "\n" + "Su nombre es demasiado largo para generarlo.");
        } else {
            textView.setText("Ha producido un error!" + "\n" + "Para generar su nombre hace falta introducir más de una letra!");
        }


    }

    private String mensajeSalida(String nombre) {
        String nombreReverse = new StringBuffer(nombre).reverse().toString();
        String mensaje = "¡Hola " + nombre +"!"  + "\n" + "Su nombre al reverse es:" + "\n" + nombreReverse;
        return mensaje;
    }
}
