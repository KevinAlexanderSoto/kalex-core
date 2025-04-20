package com.kalex.core

import android.content.Context
import android.widget.Toast

object KalexUtils {

    /**
     * Muestra un Toast simple.
     * Asegúrate de que las funciones/clases que quieres exponer sean 'public' (por defecto en Kotlin).
     */
    fun showSimpleToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    // Añade aquí más funciones útiles...
}