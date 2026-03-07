package com.scalamentis.modulos.modulo1.labs.plataforma;

/**
 * LAB: Información del sistema
 *
 * Este programa muestra información básica del sistema donde
 * se está ejecutando la JVM.
 *
 * Permite observar cómo Java puede obtener datos del entorno
 * sin depender directamente del sistema operativo.
 */
public class InfoSistema {

    public static void main(String[] args) {

        System.out.println("=== Información del Sistema ===");
        System.out.println("Sistema Operativo: " + System.getProperty("os.name"));
        System.out.println("Versión del SO: " + System.getProperty("os.version"));
        System.out.println("Arquitectura: " + System.getProperty("os.arch"));

        System.out.println();

        System.out.println("=== Usuario ===");
        System.out.println("Usuario actual: " + System.getProperty("user.name"));
        System.out.println("Directorio home: " + System.getProperty("user.home"));
        System.out.println("Directorio de trabajo: " + System.getProperty("user.dir"));
    }
}