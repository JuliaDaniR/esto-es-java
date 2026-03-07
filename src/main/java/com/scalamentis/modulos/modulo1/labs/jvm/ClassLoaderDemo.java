package com.scalamentis.modulos.modulo1.labs.jvm;

/**
 * LAB: ClassLoader
 *
 * Este programa muestra qué ClassLoader está cargando
 * la clase actual dentro de la JVM.
 *
 * Los ClassLoader son responsables de cargar las clases
 * en memoria antes de que la JVM pueda ejecutarlas.
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {

        System.out.println("=== ClassLoader Demo ===");
        System.out.println();

        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();

        System.out.println("ClassLoader que cargó esta clase:");
        System.out.println(loader);

        System.out.println();

        System.out.println("ClassLoader padre:");
        System.out.println(loader.getParent());

        System.out.println();

        System.out.println("ClassLoader raíz (Bootstrap):");
        System.out.println(loader.getParent().getParent());
    }
}