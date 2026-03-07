# 🧪 Lab 01 — DateLegacy

🎯 **Objetivo**  
Demostrar cómo se manejaban fechas y horas en Java antes de Java 8, usando `Date` y `Calendar`. Veremos sus limitaciones y por qué se introdujo la API moderna (`java.time`).

---

## 1️⃣ Código utilizado

Archivo:  
`src/main/java/com/scalamentis/modulos/modulo1/labs/legacy/DateLegacy.java`

```java
package com.scalamentis.modulos.modulo1.labs.legacy;

import java.util.Date;
import java.util.Calendar;

public class DateLegacy {
    public static void main(String[] args) {
        // Crear un objeto Date con la fecha y hora actuales
        Date now = new Date();  
        System.out.println("Fecha actual: " + now);

        // Crear un objeto Date a partir de milisegundos desde epoch
        Date past = new Date(0L); 
        System.out.println("Fecha pasada: " + past);

        // Usar Calendar para extraer partes específicas de la fecha
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; // 0=enero
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println("Año: " + year + ", Mes: " + month + ", Día: " + day);

        // Observaciones:
        // - Date es mutable → riesgo de cambios accidentales.
        // - Calendar también es mutable y los meses empiezan en 0.
        // - Manejar zonas horarias era propenso a errores.
        // - Java 8 introdujo java.time para mayor seguridad y claridad.
    }
}
```
> **Nota:** Esta API se considera legacy; se usa aquí para comprender cómo evolucionó Java.

---

## 2️⃣ Compilar la clase

Desde la terminal, estando en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/legacy/DateLegacy.java`

- -d indica dónde se generarán los .class.

---

## 3️⃣ Ejecutar la clase

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.legacy.DateLegacy`

Salida esperada (ejemplo):

```bash
Fecha actual: Fri Mar 06 10:15:30 ART 2026
Fecha pasada: Thu Jan 01 01:00:00 ART 1970
Año: 2026, Mes: 3, Día: 6
```

---

## 4️⃣ Qué se ve en la salida

- La fecha y hora actuales (now) y la fecha del epoch (past).
- Cómo se obtiene año, mes y día usando Calendar.
- Observaciones sobre la mutabilidad y problemas de la API clásica.

---

## 5️⃣ Conceptos clave

| Concepto   | Explicación                                                                                 |
|------------|--------------------------------------------------------------------------------------------|
| Date       | Representa una fecha y hora; mutable y con métodos obsoletos.                               |
| Calendar   | Permite manipular fechas por partes (año, mes, día, hora); también mutable.                |
| Epoch      | 1 de enero de 1970 00:00:00 UTC; referencia de milisegundos para Date.                     |
| Mutabilidad| Los objetos pueden modificarse, lo que puede generar errores inesperados.                  |
| java.time  | API moderna introducida en Java 8 (LocalDate, LocalDateTime, ZonedDateTime). Más segura.   |

---

## 6️⃣ Observación práctica

> - El manejo de fechas antiguas es propenso a errores (mes 0-indexado, mutabilidad, zonas horarias).
> - Permite entender la evolución hacia java.time y cómo Java resolvió problemas de claridad y seguridad en la manipulación de fechas.

---

# 🧪 Lab 02 — Sin Generics (Legacy)

## 🎯 Objetivo
Demostrar cómo eran las colecciones en Java antes de Java 5, sin generics.  
Veremos los riesgos de usar colecciones sin tipo y cómo el *cast* es necesario al recuperar elementos.

---

## 1️⃣ Código utilizado

Archivo:  
`src/main/java/com/scalamentis/modulos/modulo1/labs/legacy/SinGenerics.java`

```java
package com.scalamentis.modulos.modulo1.labs.legacy;

import java.util.ArrayList;
import java.util.List;

public class SinGenerics {

    public static void main(String[] args) {
        // Antes de Java 5 no existían los Generics
        List lista = new ArrayList();

        // Agregamos distintos tipos de objetos
        lista.add("Hola");
        lista.add(42);
        lista.add(3.14);

        // Al recuperar elementos hay que hacer cast
        String mensaje = (String) lista.get(0); 
        Integer numero = (Integer) lista.get(1);

        System.out.println("Mensaje: " + mensaje);
        System.out.println("Número: " + numero);

        // Lista completa
        System.out.println("Lista completa: " + lista);
    }
}
```

> **⚠ Nota:** los casts son obligatorios y cualquier error de tipo se detecta solo en tiempo de ejecución (ClassCastException).

---

## 2️⃣ Compilar la clase

Desde la terminal, estando en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/legacy/SinGenerics.java`

- -d indica dónde se generarán los .class.

> No hay advertencias de generics porque no se usan.

---

## 3️⃣ Ejecutar la clase

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.legacy.SinGenerics`

---

## 4️⃣ Qué se ve en la salida

```java
Mensaje: Hola
Número: 42
Lista completa: [Hola, 42, 3.14]
```

- Hola y 42 se recuperan correctamente gracias al cast.
- Si se intenta hacer un cast incorrecto (ej. (String) lista.get(1)), se produce un ClassCastException.
- Esto demuestra que las colecciones sin generics son propensas a errores de tipo en tiempo de ejecución.

---

## 5️⃣ Conceptos clave

| Concepto                  | Explicación                                                                                 |
|----------------------------|--------------------------------------------------------------------------------------------|
| Raw type / Sin generics     | Colección que no tiene tipo, acepta cualquier objeto.                                       |
| Cast                        | Conversión de tipo necesaria al recuperar elementos. Riesgosa porque errores se detectan solo en runtime. |
| ClassCastException          | Error que ocurre al intentar convertir un objeto a un tipo incorrecto.                     |
| Generics                    | Introducidos en Java 5; permiten seguridad de tipos en tiempo de compilación y eliminan la necesidad de casts. |
| Legacy                      | Código previo a Java 5, basado en colecciones sin tipo y bucles imperativos.               |

---

## 6️⃣ Observación práctica

- Usar colecciones sin tipo es inseguro y puede generar errores en producción.
- Los generics introducen seguridad de tipos y legibilidad.
- Este lab permite **entender por qué Java evolucionó y modernizó sus colecciones**.

---

# 🧪 Lab 04 — Switch Antiguo (Legacy)

🎯 **Objetivo**

Entender cómo funcionaba el switch clásico en Java antes de las mejoras modernas, identificar riesgos de fall-through y comparar con la sintaxis moderna introducida en Java 14.

---

## 1️⃣ Código utilizado

**Archivo:**

`src/main/java/com/scalamentis/modulos/modulo1/labs/legacy/SwitchAntiguo.java`

```java
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

        // Ejemplo de fall-through accidental
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
```

---

## 2️⃣ Compilar la clase

Desde la terminal, en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/legacy/SwitchAntiguo.java`

- -d indica dónde se generarán los .class.

---

## 3️⃣ Ejecutar la clase

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.legacy.SwitchAntiguo`

---

## 4️⃣ Qué se ve en la salida

```bash
=== Switch Antiguo (Legacy) Demo ===
Miércoles
Caso 2 (fall-through!)
Caso 3 (fall-through!)
Fin del main
```

- El primer switch muestra el día correspondiente.
- El segundo switch evidencia fall-through si olvidamos break.
- La JVM ejecuta todos los cases siguientes hasta encontrar un break o terminar el switch.

---

## 5️⃣ Conceptos clave

| Concepto             | Explicación |
|---------------------|-------------|
| Switch clásico       | Sintaxis tradicional; requiere `break` para evitar "fall-through". Cada case no devuelve valor. |
| Fall-through         | Comportamiento clásico donde un case continúa ejecutando el siguiente si no hay break. |
| Switch moderno       | Introducido en Java 14; cada case usa `->` y devuelve directamente un valor. Más conciso y seguro. |
| Expresiones de switch| Permiten asignar el resultado de un switch directamente a una variable. |
| Legacy               | Código previo a Java 14, basado en estructuras imperativas. |

---

## 6️⃣ Observación práctica

- El switch clásico funciona, pero puede generar errores sutiles por fall-through accidental.
- La sintaxis moderna mejora la legibilidad y seguridad del código.
- Este lab permite comparar cómo Java evolucionó hacia constructos más expresivos y menos propensos a errores.

---