package com.scalamentis.modulos.modulo1.labs.plataforma;
import java.util.Map;

/**
 * LAB: Variables de entorno
 *
 * Este programa muestra algunas variables de entorno del sistema.
 * Permite entender cómo Java puede acceder a información del entorno
 * donde se ejecuta el programa.
 *
 * Diferencia importante:
 * - System.getProperty() -> propiedades de la JVM
 * - System.getenv()      -> variables del sistema operativo
 */
public class VariablesEntorno {

    public static void main(String[] args) {

        System.out.println("=== Variables de entorno ===");

        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
        System.out.println("PATH: " + System.getenv("PATH"));

        System.out.println();

        System.out.println("=== Todas las variables del sistema ===");

        Map<String, String> variables = System.getenv();

        for (Map.Entry<String, String> entry : variables.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}