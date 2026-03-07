package com.scalamentis.modulos.modulo1.labs.refactor;

import java.util.List;

public class CodigoRefactorizado {

    // 1️⃣ Método refactorizado: separar en métodos pequeños
    public void procesarTodo() {
        System.out.println("Inicio del procesamiento");

        procesarElementos(10);
        guardarResultados();
        enviarNotificaciones();

        System.out.println("Fin del procesamiento");
    }

    private void procesarElementos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Procesando elemento " + i);
            procesarElemento(i);
        }
    }

    private void procesarElemento(int i) {
        if (i % 2 == 0) {
            System.out.println("Elemento par: logica A");
        } else {
            System.out.println("Elemento impar: logica B");
        }
    }

    private void guardarResultados() {
        System.out.println("Guardando resultados en archivo...");
    }

    private void enviarNotificaciones() {
        System.out.println("Enviando notificaciones...");
    }

    // 2️⃣ Refactorizar if anidado usando guard clauses
    public void calcular(int x, int y) {
        if (x > 0 && y > 0) {
            System.out.println("x y y positivos");
            return;
        }
        if (x > 0) {
            System.out.println("x positivo, y no");
            return;
        }
        if (y > 0) {
            System.out.println("x no positivo, y positivo");
            return;
        }
        System.out.println("x y y no positivos");
    }

    // 3️⃣ Refactorizar código duplicado en un solo método genérico
    public void imprimirLista(List<String> lista) {
        lista.forEach(s -> System.out.println("Elemento: " + s));
    }

    // 4️⃣ Separar responsabilidades: UI, lógica y persistencia
    public void procesarCliente(String nombre) {
        mostrarBienvenida(nombre);
        int descuento = calcularDescuento(nombre);
        mostrarDescuento(descuento);
        guardarCliente(nombre, descuento);
    }

    private void mostrarBienvenida(String nombre) {
        System.out.println("Bienvenido " + nombre);
    }

    private int calcularDescuento(String nombre) {
        return nombre.length() * 2;
    }

    private void mostrarDescuento(int descuento) {
        System.out.println("Descuento aplicado: " + descuento);
    }

    private void guardarCliente(String nombre, int descuento) {
        System.out.println("Guardando " + nombre + " con descuento " + descuento + " en base de datos");
    }

    // Método main para probar los ejemplos refactorizados
    public static void main(String[] args) {
        CodigoRefactorizado cr = new CodigoRefactorizado();

        System.out.println("=== Ejemplo 1: Método gigante refactorizado ===");
        cr.procesarTodo();

        System.out.println("\n=== Ejemplo 2: If anidado refactorizado ===");
        cr.calcular(5, -3);

        System.out.println("\n=== Ejemplo 3: Código duplicado refactorizado ===");
        List<String> lista = List.of("A", "B", "C");
        cr.imprimirLista(lista);

        System.out.println("\n=== Ejemplo 4: Mezcla de responsabilidades refactorizado ===");
        cr.procesarCliente("Yazmin");
    }
}