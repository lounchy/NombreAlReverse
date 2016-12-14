package com.example.lounchy.nombrealreverse;



public class StringMensaje {

    public static String mensajeSalida(String nombre){

        /**
         * Defino --nombreReverse-- que hará que nombre aparece reverse
         */
        String nombreReverse = new StringBuffer(nombre).reverse().toString();

        /**
         * Defino --mensaje-- para que la clase EscuchaButton encuentra
         */
        String mensaje = "¡Hola " + nombre +"!"  + "\n" + "Su nombre al reverse es:" + "\n" + nombreReverse;
        return mensaje;
    }

}
