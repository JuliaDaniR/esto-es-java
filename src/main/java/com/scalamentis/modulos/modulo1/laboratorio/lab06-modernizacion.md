# 🧪 Lab 01 — Generics Demo

🎯 **Objetivo**

Demostrar cómo los generics introducidos en Java 5 permiten seguridad de tipos en tiempo de compilación, evitando errores y eliminando la necesidad de casts.

---

## 1️⃣ Código utilizado

Archivo:  
`src/main/java/com/scalamentis/modulos/modulo1/labs/modernizacion/GenericsDemo.java`

```java
package com.scalamentis.modulos.modulo1.labs.modernizacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsDemo {
    public static void main(String[] args) {
        // -------------------------------
        // Lista sin generics (legacy)
        // -------------------------------
        List legacyList = new ArrayList();
        legacyList.add("Texto");
        legacyList.add(123); // permitido, pero peligroso
        System.out.println("Lista legacy: " + legacyList);

        // -------------------------------
        // Lista con generics (Java 5+)
        // -------------------------------
        List<String> stringList = new ArrayList<>();
        stringList.add("Hola");
        stringList.add("Mundo");
        // stringList.add(100); // ERROR de compilación
        System.out.println("Lista con generics: " + stringList);

        // -------------------------------
        // Map con generics
        // -------------------------------
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Uno");
        map.put(2, "Dos");
        // map.put("Tres", 3); // ERROR de compilación
        System.out.println("Mapa con generics: " + map);

        // -------------------------------
        // Operaciones seguras
        // -------------------------------
        for (String s : stringList) {
            System.out.println("Iterando stringList: " + s);
        }

        // Usando método genérico
        String first = getFirstElement(stringList);
        System.out.println("Primer elemento de stringList: " + first);
    }

    // Método genérico que funciona con cualquier tipo de lista
    public static <T> T getFirstElement(List<T> list) {
        if (list.isEmpty()) return null;
        return list.get(0);
    }
}
```

---

> **Nota:** El uso de listas y mapas sin generics es heredado de versiones previas a Java 5 y se considera legacy. Los generics mejoran la seguridad de tipos y legibilidad.

---

## 2️⃣ Compilar la clase

Desde la terminal, en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/modernizacion/GenericsDemo.java`

- -d indica dónde se generarán los .class.

> Se pueden ignorar advertencias si se mezclan tipos sin generics.

---

## 3️⃣ Ejecutar la clase

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.modernizacion.GenericsDemo`

- -cp → classpath hacia las clases compiladas.

---

## 4️⃣ Qué se ve en la salida

```bash
Lista legacy: [Texto, 123]
Lista con generics: [Hola, Mundo]
Mapa con generics: {1=Uno, 2=Dos}
Iterando stringList: Hola
Iterando stringList: Mundo
Primer elemento de stringList: Hola
```

- Lista legacy: acepta cualquier tipo, puede generar errores en runtime.
- Lista con generics: solo acepta String; errores se detectan en compilación.
- Map con generics: clave y valor tienen tipos específicos; más seguro.
- Método genérico <T>: permite reutilizar lógica con distintos tipos de colecciones.

---

## 5️⃣ Conceptos clave

| Concepto                  | Explicación                                                                 |
|----------------------------|-----------------------------------------------------------------------------|
| Raw type / Sin generics     | Colección que no tiene tipo, acepta cualquier objeto.                       |
| Cast                        | Conversión de tipo necesaria al recuperar elementos; riesgo de ClassCastException. |
| ClassCastException          | Error que ocurre al intentar convertir un objeto a un tipo incorrecto.       |
| Generics                    | Introducidos en Java 5; permiten seguridad de tipos en tiempo de compilación y eliminan la necesidad de casts. |
| Legacy                      | Código previo a Java 5, basado en colecciones sin tipo y bucles imperativos. |

---

## 6️⃣ Observación práctica

- Usar colecciones sin tipo es inseguro y puede generar errores en producción.
- Los generics mejoran la seguridad de tipos, legibilidad y mantenimiento.
- Este lab permite entender cómo Java modernizó sus colecciones y evolucionó hacia código más seguro y expresivo.

---

# 🧪 Lab 02 — LocalDate y API de Fechas Modernas

🎯 **Objetivo**  
Entender cómo trabajar con fechas usando la API moderna `java.time` de Java 8+, evitando problemas de mutabilidad y métodos obsoletos de `Date` y `Calendar`.

---

1️⃣ **Código utilizado**

Archivo:  
`src/main/java/com/scalamentis/modulos/modulo1/labs/modernizacion/LocalDateDemo.java`

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo {
    public static void main(String[] args) {
        // Crear fechas
        LocalDate hoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(1990, 5, 15);

        // Sumar y restar días
        LocalDate proxSemana = hoy.plusDays(7);
        LocalDate semanaPasada = hoy.minusDays(7);

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
```
---

> **✅ Nota:** LocalDate y LocalDateTime son inmutables y thread-safe, a diferencia de Date y Calendar.

---

## 2️⃣ Compilar la clase

Desde la terminal, en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/modernizacion/LocalDateDemo.java`

- -d indica dónde se generarán los .class.

---

## 3️⃣ Ejecutar la clase

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.modernizacion.LocalDateDemo`

- -cp → classpath hacia las clases compiladas.

---

## 4️⃣ Qué se ve en la salida

- Fechas actuales y calculadas (suma/resta de días).
- Comparación de fechas (isBefore, isAfter).
- Fechas formateadas según patrón (dd/MM/yyyy).
- Fecha y hora completa usando LocalDateTime.

---

## 5️⃣ **Conceptos clave**

| Concepto         | Explicación |
|-----------------|-------------|
| LocalDate        | Representa solo fecha (día, mes, año); inmutable. |
| LocalDateTime    | Representa fecha y hora; inmutable. |
| DateTimeFormatter | Permite formatear y parsear fechas con patrones. |
| plusDays / minusDays | Métodos para sumar o restar unidades de tiempo; retornan nuevas instancias. |
| isBefore / isAfter | Comparación de fechas. |
| Inmutabilidad    | Objetos no se modifican; operaciones devuelven nuevas instancias. |
| java.time API    | Reemplaza Date y Calendar; más segura y legible. |

---

## 6️⃣ **Observación práctica**

> - La API moderna evita problemas de mutabilidad de fechas.
> - Se mejora legibilidad, seguridad y mantenimiento del código.
> - Permite manipular y comparar fechas fácilmente, y formatearlas según necesidad.

---

# 🧪 Lab 03 — Switch Moderno en Java

🎯 **Objetivo**  
Comprender la sintaxis moderna del `switch` introducida en versiones recientes de Java (Java 14+), que permite escribir código más claro, seguro y expresivo.

---

## 1️⃣ Código utilizado

Archivo:  
`src/main/java/com/scalamentis/modulos/modulo1/labs/modernizacion/SwitchModerno.java`

```java
package com.scalamentis.modulos.modulo1.labs.modernizacion;

public class SwitchModerno {

    public static void main(String[] args) {

        int dia = 3;

        // Switch moderno como expresión
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

        // Switch moderno con bloque y yield
        int factor = 2;

        int resultado = switch (factor) {
            case 1, 2, 3 -> {
                int temp = factor * 10;
                yield temp;
            }
            default -> 0;
        };

        System.out.println("Resultado: " + resultado);
    }
}
```

---

## 2️⃣ Compilar la clase

Desde la terminal en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/modernizacion/SwitchModerno.java`

---

## 3️⃣ Ejecutar la clase

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.modernizacion.SwitchModerno`

---

## 4️⃣ Qué se ve en la salida

```bash
Nombre del día: Miércoles
Resultado: 20
```

- El switch devuelve directamente valores.
- No se necesitan break.
- Se pueden usar múltiples case en una sola línea.

---

## 5️⃣ Conceptos clave

| Concepto | Explicación |
|----------|-------------|
| Switch clásico | Utiliza `case`, `break` y puede generar fall-through si se olvidan los `break`. |
| Switch moderno | Introduce `->` y evita fall-through. |
| Switch como expresión | Permite devolver valores directamente desde el `switch`. |
| yield | Permite devolver un valor desde un bloque dentro de un `switch`. |
| case múltiple | Se pueden agrupar varios `case` en una sola línea (`case 1,2,3`). |

---

## 6️⃣ Observación práctica

- El switch moderno reduce errores comunes como olvidar `break`.
- Permite escribir código más compacto y legible.
- Se integra mejor con programación funcional y expresiones.

---

