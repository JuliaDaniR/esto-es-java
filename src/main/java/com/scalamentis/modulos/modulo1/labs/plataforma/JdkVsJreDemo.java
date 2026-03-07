package com.scalamentis.modulos.modulo1.labs.plataforma;

/**
 * LAB: JDK vs JRE
 *
 * Este programa muestra información del entorno de ejecución de Java.
 * Sirve para entender que nuestro programa se ejecuta dentro de una
 * JVM que forma parte del JRE, el cual a su vez está incluido en el JDK.
 */
public class JdkVsJreDemo {

    public static void main(String[] args) {

        System.out.println("=== Entorno de Ejecución Java ===");

        System.out.println("Versión de Java: " + System.getProperty("java.version"));
        System.out.println("Proveedor de la JVM: " + System.getProperty("java.vendor"));
        System.out.println("Java Home: " + System.getProperty("java.home"));

        System.out.println();

        System.out.println("=== Explicación ===");
        System.out.println("JVM  -> Máquina virtual que ejecuta el bytecode.");
        System.out.println("JRE  -> Entorno de ejecución (incluye la JVM y librerías).");
        System.out.println("JDK  -> Kit de desarrollo que incluye el JRE y herramientas como javac.");

    }
}