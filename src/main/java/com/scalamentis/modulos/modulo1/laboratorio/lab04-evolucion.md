# 🧪 Lab 01 — Evolución de Java (Java 8 Features)

🎯 **Objetivo**  
Demostrar cómo ha evolucionado Java desde versiones legacy hacia Java 8+, mostrando mejoras en legibilidad, manejo de colecciones, y seguridad ante `null`.

---

## 1️⃣ Código utilizado

Archivo:  
`src/main/java/com/scalamentis/modulos/modulo1/labs/evolucion/Java8Features.java`

```java
package com.scalamentis.modulos.modulo1.labs.evolucion;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Features {
    public static void main(String[] args) {
        System.out.println("=== Java 8 Features Demo ===");

        // Código Legacy (antes de Java 8)
        List<String> nombres = Arrays.asList("Ana", "Luis", "Carlos", "Bea");
        List<String> nombresConA = new ArrayList<>();
        for (String nombre : nombres) {
            if (nombre.startsWith("A")) {
                nombresConA.add(nombre);
            }
        }
        System.out.println("Legacy - nombres que empiezan con A: " + nombresConA);

        // Código Moderno (Java 8+)
        List<String> nombresConAStream = nombres.stream()
                .filter(n -> n.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Java 8 Stream - nombres que empiezan con A: " + nombresConAStream);

        // Uso de Optional
        Optional<String> primerNombre = nombres.stream()
                .filter(n -> n.startsWith("C"))
                .findFirst();
        primerNombre.ifPresent(n -> System.out.println("Primer nombre que empieza con C: " + n));

        // Uso de forEach con Lambda
        System.out.println("Imprimiendo todos los nombres con forEach:");
        nombres.forEach(n -> System.out.println("- " + n));

        // Uso de Method Reference
        System.out.println("Usando method reference para imprimir nombres:");
        nombres.forEach(System.out::println);

        System.out.println("=== Fin del demo ===");
    }
}
```
---

## 2️⃣ Compilar la clase

Desde la terminal, estando en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/evolucion/Java8Features.java`

- -d indica dónde se generarán los .class.

---

## 3️⃣ Ejecutar la clase

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.evolucion.Java8Features`

---

## 4️⃣ Qué se ve en la salida

```java
=== Java 8 Features Demo ===
Legacy - nombres que empiezan con A: [Ana]
Java 8 Stream - nombres que empiezan con A: [Ana]
Primer nombre que empieza con C: Carlos
Imprimiendo todos los nombres con forEach:
- Ana
- Luis
- Carlos
- Bea
Usando method reference para imprimir nombres:
Ana
Luis
Carlos
Bea
=== Fin del demo ===
```

**Comparación Legacy vs Java 8:**

- El filtrado tradicional con for se reemplaza por Stream + filter.
- Optional previene NullPointerException.
- forEach con lambda o referencia a métodos hace el código más legible y conciso.

---

## 5️⃣ Conceptos clave

| Concepto            | Explicación                                                                 |
|--------------------|----------------------------------------------------------------------------|
| Stream             | API que permite operar sobre colecciones de manera declarativa y funcional.|
| Lambda             | Función anónima que simplifica iteraciones y callbacks.                    |
| Method Reference   | Forma concisa de referirse a un método existente (System.out::println).   |
| Optional           | Encapsula un valor que puede ser nulo, evitando NullPointerException.     |
| Legacy             | Código previo a Java 8, basado en bucles y estructuras imperativas.       |
| Collectors.toList()| Convierte un Stream en una lista, aplicando filtros o transformaciones.   |

## 6️⃣ Observación práctica

- Java 8 simplifica operaciones con colecciones.
- Reduce código boilerplate y mejora legibilidad.
- Introduce herramientas para programar más seguro y funcional, sin romper compatibilidad con código legacy.

---

# 🧪 Lab 02 — Evolución del Switch (Java 14+)

🎯 **Objetivo**

Mostrar cómo el switch evolucionó desde versiones clásicas de Java hasta la sintaxis moderna introducida en Java 14.
Veremos cómo escribir código más conciso, evitar errores por fall-through y devolver valores directamente desde una expresión de switch.

---

## 1️⃣ Código utilizado

**Archivo:**

`src/main/java/com/scalamentis/modulos/modulo1/labs/evolucion/Java14Switch.java`

```java
package com.scalamentis.modulos.modulo1.labs.evolucion;

public class Java14Switch {

    public static void main(String[] args) {
        int day = 3; // Día de la semana (1 = Lunes, 2 = Martes, …)

        // Switch clásico (Java previo a 14)
        String dayNameOld;
        switch (day) {
            case 1: dayNameOld = "Lunes"; break;
            case 2: dayNameOld = "Martes"; break;
            case 3: dayNameOld = "Miércoles"; break;
            case 4: dayNameOld = "Jueves"; break;
            case 5: dayNameOld = "Viernes"; break;
            case 6: dayNameOld = "Sábado"; break;
            case 7: dayNameOld = "Domingo"; break;
            default: dayNameOld = "Desconocido";
        }
        System.out.println("Switch clásico: " + dayNameOld);

        // Switch moderno (Java 14+)
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
```

> **Nota:** El switch moderno permite devolver directamente un valor, usando -> para cada caso, evitando break y el problema de fall-through.

---

## 2️⃣ Compilar la clase

Desde la terminal, estando en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/evolucion/Java14Switch.java`

- -d indica dónde se generarán los .class.

La clase compilada estará en:

`out/production/java-labs/com/scalamentis/modulos/modulo1/labs/evolucion/Java14Switch.class`

---

## 3️⃣ Ejecutar

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.evolucion.Java14Switch`

- -cp indica el classpath donde están las clases compiladas.

---

## 4️⃣ Qué se ve en la salida

```bash
Switch clásico: Miércoles
Switch moderno: Miércoles
```

- Ambos switches devuelven el mismo resultado, pero la versión moderna es más concisa.
- No necesita break, y cada case puede devolver un valor directamente.
- Evita errores comunes de fall-through que ocurren en el switch clásico.

---

## 5️⃣ Conceptos clave

| Concepto              | Explicación                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| Switch clásico        | Sintaxis tradicional; requiere break para evitar "fall-through". Cada case no devuelve valor. |
| Switch moderno        | Introducido en Java 14; cada case usa -> y devuelve directamente un valor. Más conciso y seguro. |
| Fall-through          | Comportamiento clásico donde un case continua ejecutando el siguiente si no hay break. |
| Expresiones de switch | Permiten asignar el resultado de un switch directamente a una variable.     |

---

# 🧪 Lab 03 — Java 17 Records

🎯 **Objetivo**  
Mostrar cómo los **records** simplifican la creación de clases inmutables que solo contienen datos.  
Los records generan automáticamente constructor, getters, `equals()`, `hashCode()` y `toString()`.

---

## 1️⃣ Código utilizado

Archivo:  
`src/main/java/com/scalamentis/modulos/modulo1/labs/evolucion/Java17Record.java`

```java
package com.scalamentis.modulos.modulo1.labs.evolucion;

public class Java17Record {

    // Definición de un record simple
    record Persona(String nombre, int edad) {}

    public static void main(String[] args) {

        // Crear instancias del record
        Persona p1 = new Persona("Julia", 25);
        Persona p2 = new Persona("Carlos", 30);

        // Mostrar los datos con toString generado automáticamente
        System.out.println(p1); // Persona[nombre=Julia, edad=25]
        System.out.println(p2); // Persona[nombre=Carlos, edad=30]

        // Comparar records con equals (basado en contenido)
        System.out.println(p1.equals(new Persona("Julia", 25))); // true

        // Acceder a campos
        System.out.println("Nombre: " + p1.nombre() + ", Edad: " + p1.edad());
    }
}
```

> **Nota:** Los records son inmutables; sus campos no se pueden modificar después de crear la instancia.

---

## 2️⃣ Compilar la clase

Desde la terminal, en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/evolucion/Java17Record.java`

- -d indica dónde se generarán los .class.

> Se puede ignorar cualquier advertencia si todo está correcto con Java 17+.

---

## 3️⃣ Ejecutar la clase

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.evolucion.Java17Record`

- -cp → indica el classpath hacia las clases compiladas.

---

## 4️⃣ Qué se ve en la salida

```bash
Persona[nombre=Yazmin, edad=25]
Persona[nombre=Franco, edad=30]
true
Nombre: Yazmin, Edad: 25
```

- toString() automático muestra nombre y edad.
- equals() compara por contenido, no por referencia.
- Los campos se acceden directamente con los métodos generados (nombre(), edad()).

---

## 5️⃣ Conceptos clave

| Concepto       | Explicación |
|----------------|------------|
| Record         | Clase inmutable para contener datos; genera constructor, getters, equals, hashCode y toString automáticamente. |
| Inmutabilidad  | Una vez creado un record, sus campos no se pueden modificar. |
| Constructor    | Se genera automáticamente con los campos declarados en el record. |
| equals()       | Compara el contenido de los records, no la referencia de memoria. |
| hashCode()     | Generado automáticamente, consistente con equals(). |
| toString()     | Muestra todos los campos del record en formato [nombreCampo=valor]. |

---

## 6️⃣ Observación práctica

- Los records eliminan boilerplate al definir clases que solo contienen datos.
- Mejoran la legibilidad y reducen errores al implementar equals(), hashCode() y toString() manualmente.
- Su uso es recomendado para DTOs, respuestas de APIs y cualquier clase que represente solo datos inmutables.

---

