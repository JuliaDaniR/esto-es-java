package com.scalamentis.modulos.modulo1.labs.legacy;

public class SwitchAntiguo {
    public static void main(String[] args) {
        System.out.println("=== Switch Antiguo (Legacy) Demo ===");

        int dia = 3; // 1=Lunes, 2=Martes, ..., 7=Domingo

        // Switch clásico: requiere break, no devuelve valor
        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
            case 7:
                System.out.println("Fin de semana");
                break;
            default:
                System.out.println("Día inválido");
        }

        // Ejemplo de *fall-through* accidental
        int valor = 2;
        switch (valor) {
            case 1:
                System.out.println("Caso 1");
            case 2:
                System.out.println("Caso 2 (fall-through!)"); // Se ejecuta aunque no sea deseado
            case 3:
                System.out.println("Caso 3 (fall-through!)");
        }

        System.out.println("Fin del main");
    }
}