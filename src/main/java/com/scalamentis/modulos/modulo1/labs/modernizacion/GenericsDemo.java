package com.scalamentis.modulos.modulo1.labs.modernizacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsDemo {
    public static void main(String[] args) {
        // -------------------------------
        // Lista sin generics (legacy)
        // -------------------------------
        List legacyList = new ArrayList();
        legacyList.add("Texto");
        legacyList.add(123); // permitido, pero peligroso
        System.out.println("Lista legacy: " + legacyList);

        // -------------------------------
        // Lista con generics (Java 5+)
        // -------------------------------
        List<String> stringList = new ArrayList<>();
        stringList.add("Hola");
        stringList.add("Mundo");
        // stringList.add(100); // ERROR de compilación
        System.out.println("Lista con generics: " + stringList);

        // -------------------------------
        // Map con generics
        // -------------------------------
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Uno");
        map.put(2, "Dos");
        // map.put("Tres", 3); // ERROR de compilación
        System.out.println("Mapa con generics: " + map);

        // -------------------------------
        // Operaciones seguras
        // -------------------------------
        for (String s : stringList) {
            System.out.println("Iterando stringList: " + s);
        }

        // Usando métodos genéricos
        String first = getFirstElement(stringList);
        System.out.println("Primer elemento de stringList: " + first);
    }

    // Método genérico que funciona con cualquier tipo de lista
    public static <T> T getFirstElement(List<T> list) {
        if (list.isEmpty()) return null;
        return list.get(0);
    }
}