package com.scalamentis.modulos.modulo1.labs.refactor;

import java.util.List;

public class CodigoEspagueti {

    // 1️⃣ Método gigante que hace todo
    // Problema: hace demasiadas cosas en un solo método → difícil de leer, probar y mantener
    public void procesarTodo() {
        System.out.println("Inicio del procesamiento");

        for (int i = 0; i < 10; i++) {
            System.out.println("Procesando elemento " + i);
            if (i % 2 == 0) {
                System.out.println("Elemento par: logica A");
            } else {
                System.out.println("Elemento impar: logica B");
            }
        }

        System.out.println("Guardando resultados en archivo...");
        System.out.println("Enviando notificaciones...");
        System.out.println("Fin del procesamiento");
    }

    // 2️⃣ Lógica anidada con muchos if/else
    // Problema: demasiada anidación → difícil seguir la lógica y agregar casos nuevos
    public void calcular(int x, int y) {
        if (x > 0) {
            if (y > 0) {
                System.out.println("x y y positivos");
            } else {
                System.out.println("x positivo, y no");
            }
        } else {
            if (y > 0) {
                System.out.println("x no positivo, y positivo");
            } else {
                System.out.println("x y y no positivos");
            }
        }
    }

    // 3️⃣ Código duplicado
    // Problema: duplicación → mantenimiento caro y riesgo de inconsistencias
    public void imprimirLista1(List<String> lista) {
        for (String s : lista) {
            System.out.println("Elemento: " + s);
        }
    }

    public void imprimirLista2(List<String> lista) {
        for (String s : lista) {
            System.out.println("Elemento: " + s);
        }
    }

    // 4️⃣ Mezcla de UI, lógica y persistencia
    // Problema: mezcla de responsabilidades → difícil de testear, modificar o reutilizar
    public void procesarCliente(String nombre) {
        System.out.println("Bienvenido " + nombre); // UI
        int descuento = nombre.length() * 2; // Lógica
        System.out.println("Descuento aplicado: " + descuento); // UI
        // Simulando guardado en BD
        System.out.println("Guardando " + nombre + " con descuento " + descuento + " en base de datos"); // Persistencia
    }

    // Método main para probar los ejemplos
    public static void main(String[] args) {
        CodigoEspagueti ce = new CodigoEspagueti();

        System.out.println("=== Ejemplo 1: Método gigante ===");
        ce.procesarTodo();

        System.out.println("\n=== Ejemplo 2: If anidado ===");
        ce.calcular(5, -3);

        System.out.println("\n=== Ejemplo 3: Código duplicado ===");
        List<String> lista = List.of("A", "B", "C");
        ce.imprimirLista1(lista);
        ce.imprimirLista2(lista);

        System.out.println("\n=== Ejemplo 4: Mezcla de responsabilidades ===");
        ce.procesarCliente("Julia");
    }
}