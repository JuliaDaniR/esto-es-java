package com.scalamentis.modulos.modulo1.labs.memoria;

public class StringPoolDemo {

    public static void main(String[] args) {
        System.out.println("=== String Pool Demo ===");

        // Strings literales (reutilizan el pool)
        String s1 = "Hola";
        String s2 = "Hola";

        // Comparación de referencias
        System.out.println("s1 == s2: " + (s1 == s2)); // true, mismo objeto en pool

        // String con new (objeto nuevo en heap)
        String s3 = new String("Hola");
        System.out.println("s1 == s3: " + (s1 == s3)); // false, diferentes referencias

        // intern() fuerza a usar el pool
        String s4 = s3.intern();
        System.out.println("s1 == s4: " + (s1 == s4)); // true, ahora apunta al pool

        // Diferencias entre contenido y referencia
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true, mismo contenido
    }
}