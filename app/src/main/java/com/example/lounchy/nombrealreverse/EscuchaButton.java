package com.example.lounchy.nombrealreverse;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
        TextView textView = (TextView) activity.findViewById(R.id.generar_text_view);
        String mensaje = mensajeSalida(nombre);
        if (nombre.length() < 1) {
            textView.setText(R.string.error + "\n" + R.string.error_corto);
        } else if (nombre.length() > 16) {
            textView.setText(R.string.error + "\n" + R.string.error_largo);
        } else {
            textView.setText(mensaje);
        }


    }

    private String mensajeSalida(String nombre) {
        String nombreReverse = new StringBuffer().reverse().toString();
        String mensaje = "¡Hola " + "!" + nombre + "\n" + "Su nombre al reverse es:" + "\n" + nombreReverse;
        return mensaje;
    }
}
