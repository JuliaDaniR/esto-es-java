package com.scalamentis.modulos.modulo1.labs.plataforma;

/**
 * LAB: Plataforma Java
 *
 * Este programa muestra información del entorno donde se ejecuta Java.
 * Permite entender que Java corre sobre una JVM y no directamente
 * sobre el sistema operativo.
 */
public class HolaPlataforma {

    public static void main(String[] args) {

        System.out.println("Hola desde Java ☕");
        System.out.println("Write Once, Run Anywhere");
        System.out.println();

        System.out.println("=== Información de la JVM ===");
        System.out.println("Versión de Java: " + System.getProperty("java.version"));
        System.out.println("Proveedor JVM: " + System.getProperty("java.vendor"));

        System.out.println();

        System.out.println("=== Información del sistema ===");
        System.out.println("Sistema Operativo: " + System.getProperty("os.name"));
        System.out.println("Arquitectura: " + System.getProperty("os.arch"));
        System.out.println("Usuario: " + System.getProperty("user.name"));
    }
}