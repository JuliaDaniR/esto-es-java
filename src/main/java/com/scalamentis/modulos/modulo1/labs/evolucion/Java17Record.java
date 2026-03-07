package com.scalamentis.modulos.modulo1.labs.evolucion;

/**
 * 🧪 Lab 03 — Java 17 Records
 *
 * Objetivo:
 * Mostrar cómo los records simplifican la creación de clases inmutables con campos de datos.
 *
 * Un record genera automáticamente:
 *  - Constructor
 *  - Métodos getters (nombre de campo)
 *  - equals()
 *  - hashCode()
 *  - toString()
 *
 * Uso recomendado para clases que solo contienen datos, evitando boilerplate.
 */

public class Java17Record {

    // Definición de un record simple
    record Persona(String nombre, int edad) {}

    public static void main(String[] args) {

        // Crear instancia del record
        Persona p1 = new Persona("Yazmin", 25);
        Persona p2 = new Persona("Franco", 30);

        // Mostrar los datos con toString generado automáticamente
        System.out.println(p1); // Persona[nombre=Yazmin, edad=25]
        System.out.println(p2); // Persona[nombre=Franco, edad=30]

        // Comparar records con equals (basado en contenido, no en referencia)
        System.out.println(p1.equals(new Persona("Yazmin", 25))); // true

        // Acceder a campos
        System.out.println("Nombre: " + p1.nombre() + ", Edad: " + p1.edad());
    }
}