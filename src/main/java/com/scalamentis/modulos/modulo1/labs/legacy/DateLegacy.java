package com.scalamentis.modulos.modulo1.labs.legacy;

import java.util.Date;
import java.util.Calendar;

public class DateLegacy {
    public static void main(String[] args) {
        // ------------------------------
        // Crear un objeto Date con la fecha y hora actuales
        // ------------------------------
        Date now = new Date();
        System.out.println("Fecha actual: " + now);
        // Muestra algo como: "Fri Mar 06 10:15:30 ART 2026"

        // ------------------------------
        // Crear un objeto Date a partir de milisegundos desde epoch
        // Epoch = 1 de enero de 1970 00:00:00 UTC
        // ------------------------------
        Date past = new Date(0L); // fecha inicial del epoch
        System.out.println("Fecha pasada: " + past);
        // Muestra: "Thu Jan 01 01:00:00 ART 1970" (según zona horaria)

        // ------------------------------
        // Usar Calendar para extraer partes específicas de la fecha
        // ------------------------------
        Calendar cal = Calendar.getInstance(); // obtiene la fecha y hora actuales
        cal.setTime(now); // asignamos la fecha actual a Calendar

        int year = cal.get(Calendar.YEAR); // obtener año
        int month = cal.get(Calendar.MONTH) + 1; // obtener mes (0=enero, por eso +1)
        int day = cal.get(Calendar.DAY_OF_MONTH); // obtener día del mes

        System.out.println("Año: " + year + ", Mes: " + month + ", Día: " + day);
        // Muestra algo como: "Año: 2026, Mes: 3, Día: 6"

        // ------------------------------
        // Observaciones importantes sobre Date y Calendar
        // ------------------------------
        // 1. Date es mutable → puedes cambiar su valor accidentalmente.
        // 2. Calendar también es mutable y los meses empiezan en 0, lo que genera errores frecuentes.
        // 3. Manejar zonas horarias es complejo y propenso a bugs.
        // 4. Por estas razones, Java 8 introdujo java.time (LocalDate, LocalDateTime, ZonedDateTime) más seguro y claro.
    }
}