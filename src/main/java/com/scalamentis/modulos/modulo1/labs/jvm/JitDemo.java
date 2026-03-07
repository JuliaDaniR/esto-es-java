package com.scalamentis.modulos.modulo1.labs.jvm;

/**
 * LAB: JIT Demo Súper Visual
 *
 * Este laboratorio combina varias técnicas para mostrar cómo
 * la JVM optimiza código en tiempo de ejecución (JIT).
 *
 * - Barras visuales por tiempo de ejecución
 * - Puntos de progreso durante el bucle
 * - Comparación entre ejecución única vs repetida
 */
public class JitDemo {

    public static void main(String[] args) {

        System.out.println("=== JIT Demo Súper Visual ===");
        System.out.println("Comparación entre método ejecutado 1 vez y repetidamente con progreso visual\n");

        int iteraciones = 100_000_000;
        int repeticiones = 5;

        // ===== Método ejecutado 1 vez (sin optimización) =====
        System.out.println("Método ejecutado 1 vez (sin optimización):");
        long start1 = System.nanoTime();
        long resultado1 = buclePesadoConProgreso(iteraciones, false);
        long end1 = System.nanoTime();
        mostrarTiempo(1, end1 - start1);

        System.out.println("\nMétodo ejecutado varias veces (para activar JIT):");
        // ===== Método ejecutado varias veces (para JIT) =====
        for (int ejec = 1; ejec <= repeticiones; ejec++) {
            long start = System.nanoTime();
            long resultado2 = buclePesadoConProgreso(iteraciones, ejec == 1); // mostrar progreso solo en la primera repetición
            long end = System.nanoTime();
            mostrarTiempo(ejec, end - start);
        }

        System.out.println("\nObserva cómo la ejecución repetida se acelera gracias al JIT.");
    }

    /**
     * Método que realiza un cálculo repetitivo con progreso opcional
     */
    public static long buclePesadoConProgreso(int iteraciones, boolean mostrarProgreso) {
        long suma = 0;
        int paso = iteraciones / 10; // dividir en 10 partes para progreso

        for (int i = 0; i < iteraciones; i++) {
            suma += i;

            if (mostrarProgreso && i % paso == 0 && i != 0) {
                System.out.print("."); // punto de progreso
            }
        }

        if (mostrarProgreso) {
            System.out.println();
        }

        return suma;
    }

    /**
     * Imprime tiempo en ms con barra visual
     */
    public static void mostrarTiempo(int ejec, long tiempoNano) {
        long tiempoMs = tiempoNano / 1_000_000;
        System.out.printf("Ejecución %2d: %6d ms | ", ejec, tiempoMs);
        int barras = (int) (tiempoMs / 10);
        for (int i = 0; i < barras; i++) {
            System.out.print("█");
        }
        System.out.println();
    }
}
