package com.scalamentis.modulos.modulo1.labs.evolucion;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Features {
    public static void main(String[] args) {
        System.out.println("=== Java 8 Features Demo ===");

        // ---------- Código Legacy (antes de Java 8) ----------
        List<String> nombres = Arrays.asList("Ana", "Luis", "Carlos", "Bea");
        List<String> nombresConA = new ArrayList<>();

        // Filtrado usando for tradicional
        for (String nombre : nombres) {
            if (nombre.startsWith("A")) {
                nombresConA.add(nombre);
            }
        }

        System.out.println("Legacy - nombres que empiezan con A: " + nombresConA);

        // ---------- Código Moderno (Java 8+) ----------
        // Usando Stream y Lambda
        List<String> nombresConAStream = nombres.stream()
                .filter(n -> n.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Java 8 Stream - nombres que empiezan con A: " + nombresConAStream);

        // ---------- Uso de Optional ----------
        Optional<String> primerNombre = nombres.stream()
                .filter(n -> n.startsWith("C"))
                .findFirst();

        // Antes se manejaba con null, ahora Optional previene NullPointerException
        if (primerNombre.isPresent()) {
            System.out.println("Primer nombre que empieza con C: " + primerNombre.get());
        }

        // ---------- Uso de forEach con Lambda ----------
        System.out.println("Imprimiendo todos los nombres con forEach:");
        nombres.forEach(n -> System.out.println("- " + n));

        // ---------- Uso de Method Reference ----------
        System.out.println("Usando method reference para imprimir nombres:");
        nombres.forEach(System.out::println);

        System.out.println("=== Fin del demo ===");
    }
}