package com.scalamentis.modulos.modulo1.labs.modernizacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo {
    public static void main(String[] args) {
        // Crear fechas
        LocalDate hoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(1990, 5, 15);

        System.out.println("Hoy: " + hoy);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);

        // Sumar y restar días
        LocalDate proxSemana = hoy.plusDays(7);
        LocalDate semanaPasada = hoy.minusDays(7);
        System.out.println("Próxima semana: " + proxSemana);
        System.out.println("Semana pasada: " + semanaPasada);

        // Comparar fechas
        if (fechaNacimiento.isBefore(hoy)) {
            System.out.println("La fecha de nacimiento ya pasó.");
        }

        // Formatear fechas
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Hoy formateado: " + hoy.format(formato));

        // LocalDateTime
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Fecha y hora actual: " + ahora);
    }
}