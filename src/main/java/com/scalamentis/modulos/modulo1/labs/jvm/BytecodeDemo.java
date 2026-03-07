package com.scalamentis.modulos.modulo1.labs.jvm;

/**
 * LAB: Bytecode Demo
 *
 * Este laboratorio muestra cómo un programa Java
 * se compila a bytecode antes de ser ejecutado
 * por la JVM.
 */
public class BytecodeDemo {

    public static void main(String[] args) {

        System.out.println("=== DEMO BYTECODE ===");
        System.out.println();

        int a = 10;
        int b = 20;
        int resultado = sumar(a, b);

        System.out.println("Resultado de la suma: " + resultado);

        System.out.println();
        System.out.println("Este código Java fue compilado a BYTECODE.");
        System.out.println("La JVM ejecuta el archivo .class generado por javac.");
    }

    public static int sumar(int x, int y) {
        return x + y;
    }
}