package com.scalamentis.modulos.modulo1.labs.memoria;

public class GarbageCollectionDemo {

    static class DemoObjeto {
        private final String nombre;

        DemoObjeto(String nombre) {
            this.nombre = nombre;
            System.out.println("Creado: " + nombre);
        }

        @Override
        @SuppressWarnings("removal")
        protected void finalize() throws Throwable {
            System.out.println("Finalizado (GC): " + nombre);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Garbage Collection Demo ===");

        // Crear algunos objetos
        DemoObjeto obj1 = new DemoObjeto("Objeto 1");
        DemoObjeto obj2 = new DemoObjeto("Objeto 2");

        // Liberar referencia de obj1
        obj1 = null;

        // Forzar recolección de basura
        System.gc();

        // Esperar un poco para que se ejecute el GC
        Thread.sleep(100);

        // Crear más objetos
        DemoObjeto obj3 = new DemoObjeto("Objeto 3");
        DemoObjeto obj4 = new DemoObjeto("Objeto 4");
        DemoObjeto obj5 = new DemoObjeto("Objeto 5");

        // Liberar referencias de algunos
        obj2 = null;
        obj3 = null;

        // Forzar otra recolección
        System.gc();
        Thread.sleep(100);

        System.out.println("Fin del main");
    }
}