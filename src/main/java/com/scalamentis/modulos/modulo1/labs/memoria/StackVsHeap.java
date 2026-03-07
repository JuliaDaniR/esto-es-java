package com.scalamentis.modulos.modulo1.labs.memoria;

public class StackVsHeap {

    static class DemoObject {
        private final String name;

        DemoObject(String name) {
            this.name = name;
            System.out.println("Creado: " + name + " en heap, hash=" + System.identityHashCode(this));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stack vs Heap Demo ===");

        // Variables primitivas → stack
        int a = 10;
        int b = 20;
        System.out.println("Variables primitivas en stack: a=" + a + ", b=" + b);

        // Objetos → heap
        DemoObject obj1 = new DemoObject("Obj1");
        DemoObject obj2 = obj1; // Referencia stack apuntando al mismo heap
        DemoObject obj3 = new DemoObject("Obj3");

        System.out.println("obj1 hash=" + System.identityHashCode(obj1));
        System.out.println("obj2 hash=" + System.identityHashCode(obj2)); // mismo objeto
        System.out.println("obj3 hash=" + System.identityHashCode(obj3)); // distinto objeto

        // Cambiar referencias
        obj1 = null; // obj1 deja de apuntar, obj2 todavía apunta a Obj1
        System.out.println("obj1 liberado, obj2 sigue apuntando a Obj1");

        System.gc(); // Solicitar GC (obj1=null no libera realmente si hay otras referencias)

        System.out.println("Fin del main");
    }
}