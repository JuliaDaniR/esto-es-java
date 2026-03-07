package com.scalamentis.modulos.modulo1.labs.legacy;

import java.util.ArrayList;
import java.util.List;

public class SinGenerics {

    public static void main(String[] args) {
        // 🔹 Antes de Java 5 no existían los Generics
        // List podía contener cualquier tipo de objeto
        List lista = new ArrayList();

        // Agregamos distintos tipos de objetos
        lista.add("Hola");
        lista.add(42);
        lista.add(3.14);

        // 🔹 Problema: al recuperar objetos, siempre hay que hacer cast
        String mensaje = (String) lista.get(0); // correcto
        Integer numero = (Integer) lista.get(1); // correcto

        // Esto compila, pero genera ClassCastException en runtime si hay error
        // String error = (String) lista.get(1); // ⚠ ClassCastException

        System.out.println("Mensaje: " + mensaje);
        System.out.println("Número: " + numero);

        // 🔹 Con generics se evita el cast y se detecta en tiempo de compilación
        System.out.println("Lista completa: " + lista);
    }
}