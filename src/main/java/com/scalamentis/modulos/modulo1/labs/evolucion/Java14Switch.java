package com.scalamentis.modulos.modulo1.labs.evolucion;

public class Java14Switch {

    public static void main(String[] args) {
        int day = 3; // Día de la semana (1 = Lunes, 2 = Martes, …)

        // -----------------------------
        // Switch clásico (Java previo a 14)
        // -----------------------------
        // Uso de break obligatorio para evitar "fall-through"
        // Cada case es una sentencia, no retorna valor directamente
        String dayNameOld;
        switch (day) {
            case 1:
                dayNameOld = "Lunes";
                break;
            case 2:
                dayNameOld = "Martes";
                break;
            case 3:
                dayNameOld = "Miércoles";
                break;
            case 4:
                dayNameOld = "Jueves";
                break;
            case 5:
                dayNameOld = "Viernes";
                break;
            case 6:
                dayNameOld = "Sábado";
                break;
            case 7:
                dayNameOld = "Domingo";
                break;
            default:
                dayNameOld = "Desconocido"; // Caso por defecto si no coincide ningún case
        }
        System.out.println("Switch clásico: " + dayNameOld);

        // -----------------------------
        // Switch moderno (Java 14+)
        // -----------------------------
        // Expresión de switch: devuelve directamente un valor
        // Sintaxis con '->' evita fall-through y es más concisa
        String dayNameNew = switch (day) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Desconocido";
        };
        System.out.println("Switch moderno: " + dayNameNew);
    }
}