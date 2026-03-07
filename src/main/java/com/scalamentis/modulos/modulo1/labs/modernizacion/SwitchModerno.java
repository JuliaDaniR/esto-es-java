package com.scalamentis.modulos.modulo1.labs.modernizacion;

public class SwitchModerno {

    public static void main(String[] args) {
        // Ejemplo de switch moderno en Java 14+
        // Cada case usa -> y puede devolver directamente un valor.
        // Se evita el fall-through y no se necesitan break.

        int dia = 3;

        String nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Día inválido";
        };

        System.out.println("Nombre del día: " + nombreDia);

        // También se puede usar switch como expresión para ejecutar bloques:
        int factor = 2;
        int resultado = switch (factor) {
            case 1, 2, 3 -> {
                int temp = factor * 10;
                yield temp; // yield devuelve el valor del bloque
            }
            default -> 0;
        };

        System.out.println("Resultado: " + resultado);
    }
}