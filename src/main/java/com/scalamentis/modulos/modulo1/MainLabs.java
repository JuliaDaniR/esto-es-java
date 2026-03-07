package com.scalamentis.modulos.modulo1;

import java.util.Scanner;

public class MainLabs {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=====================================");
            System.out.println("      🚀 SCALAMENTIS JAVA LABS       ");
            System.out.println("=====================================");
            System.out.println("1️⃣  Plataforma Java");
            System.out.println("2️⃣  JVM");
            System.out.println("3️⃣  Modelo de Memoria");
            System.out.println("4️⃣  Evolución de Java");
            System.out.println("5️⃣  Legacy Java");
            System.out.println("6️⃣  Modernización");
            System.out.println("7️⃣  Refactorización");
            System.out.println("0️⃣  Salir");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> menuPlataforma(scanner);
                case 2 -> menuJvm(scanner);
                case 3 -> menuMemoria(scanner);
                case 4 -> menuEvolucion(scanner);
                case 5 -> menuLegacy(scanner);
                case 6 -> menuModernizacion(scanner);
                case 7 -> menuRefactor(scanner);
                case 0 -> System.out.println("👋 Hasta luego!");
                default -> System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void menuPlataforma(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=====================================");
            System.out.println("--- 💻 LABS PLATAFORMA JAVA ---");
            System.out.println("=====================================");
            System.out.println("1️⃣  Hola Plataforma");
            System.out.println("2️⃣  Información del Sistema");
            System.out.println("3️⃣  JDK vs JRE");
            System.out.println("4️⃣  Variables de Entorno");
            System.out.println("0️⃣  Volver al menú principal");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> com.scalamentis.modulos.modulo1.labs.plataforma.HolaPlataforma.main(null);
                case 2 -> com.scalamentis.modulos.modulo1.labs.plataforma.InfoSistema.main(null);
                case 3 -> com.scalamentis.modulos.modulo1.labs.plataforma.JdkVsJreDemo.main(null);
                case 4 -> com.scalamentis.modulos.modulo1.labs.plataforma.VariablesEntorno.main(null);
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 0);
    }

    private static void menuJvm(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=====================================");
            System.out.println("--- 🖥️ LABS JVM ---");
            System.out.println("=====================================");
            System.out.println("1️⃣  Bytecode Demo");
            System.out.println("2️⃣  ClassLoader Demo");
            System.out.println("3️⃣  JIT Demo");
            System.out.println("0️⃣  Volver al menú principal");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> com.scalamentis.modulos.modulo1.labs.jvm.BytecodeDemo.main(null);
                case 2 -> com.scalamentis.modulos.modulo1.labs.jvm.ClassLoaderDemo.main(null);
                case 3 -> com.scalamentis.modulos.modulo1.labs.jvm.JitDemo.main(null);
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 0);
    }

    private static void menuMemoria(Scanner scanner) throws InterruptedException {
        int opcion;
        do {
            System.out.println("\n=====================================");
            System.out.println("--- 🧠 LABS MEMORIA ---");
            System.out.println("=====================================");
            System.out.println("1️⃣  Garbage Collection Demo");
            System.out.println("2️⃣  Stack vs Heap");
            System.out.println("3️⃣  String Pool Demo");
            System.out.println("0️⃣  Volver al menú principal");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> com.scalamentis.modulos.modulo1.labs.memoria.GarbageCollectionDemo.main(null);
                case 2 -> com.scalamentis.modulos.modulo1.labs.memoria.StackVsHeap.main(null);
                case 3 -> com.scalamentis.modulos.modulo1.labs.memoria.StringPoolDemo.main(null);
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 0);
    }

    private static void menuEvolucion(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=====================================");
            System.out.println("--- ⏳ LABS EVOLUCIÓN JAVA ---");
            System.out.println("=====================================");
            System.out.println("1️⃣  Java 8 Features");
            System.out.println("2️⃣  Java 14 Switch");
            System.out.println("3️⃣  Java 17 Record");
            System.out.println("0️⃣  Volver al menú principal");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> com.scalamentis.modulos.modulo1.labs.evolucion.Java8Features.main(null);
                case 2 -> com.scalamentis.modulos.modulo1.labs.evolucion.Java14Switch.main(null);
                case 3 -> com.scalamentis.modulos.modulo1.labs.evolucion.Java17Record.main(null);
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 0);
    }

    private static void menuLegacy(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=====================================");
            System.out.println("--- 📜 LABS LEGACY JAVA ---");
            System.out.println("=====================================");
            System.out.println("1️⃣  Date Legacy");
            System.out.println("2️⃣  Sin Generics");
            System.out.println("3️⃣  Switch Antiguo");
            System.out.println("0️⃣  Volver al menú principal");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> com.scalamentis.modulos.modulo1.labs.legacy.DateLegacy.main(null);
                case 2 -> com.scalamentis.modulos.modulo1.labs.legacy.SinGenerics.main(null);
                case 3 -> com.scalamentis.modulos.modulo1.labs.legacy.SwitchAntiguo.main(null);
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 0);
    }

    private static void menuModernizacion(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=====================================");
            System.out.println("--- 🛠️ LABS MODERNIZACIÓN JAVA ---");
            System.out.println("=====================================");
            System.out.println("1️⃣  Generics Demo");
            System.out.println("2️⃣  LocalDate Demo");
            System.out.println("3️⃣  Switch Moderno");
            System.out.println("0️⃣  Volver al menú principal");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> com.scalamentis.modulos.modulo1.labs.modernizacion.GenericsDemo.main(null);
                case 2 -> com.scalamentis.modulos.modulo1.labs.modernizacion.LocalDateDemo.main(null);
                case 3 -> com.scalamentis.modulos.modulo1.labs.modernizacion.SwitchModerno.main(null);
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 0);
    }

    private static void menuRefactor(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=====================================");
            System.out.println("--- 🧹 LABS REFACTOR ---");
            System.out.println("=====================================");
            System.out.println("1️⃣  Código Espagueti");
            System.out.println("2️⃣  Código Refactorizado");
            System.out.println("0️⃣  Volver al menú principal");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> com.scalamentis.modulos.modulo1.labs.refactor.CodigoEspagueti.main(null);
                case 2 -> com.scalamentis.modulos.modulo1.labs.refactor.CodigoRefactorizado.main(null);
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 0);
    }
}