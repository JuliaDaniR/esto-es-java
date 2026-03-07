# 🧪 Lab 01 — Garbage Collection (GC)

🎯 **Objetivo**  
Demostrar cómo Java gestiona la memoria automáticamente usando Garbage Collection. Veremos cuándo los objetos se recolectan y cómo la JVM libera espacio en el heap.

---

## 1️⃣ Código utilizado

**Archivo:**  
`src/main/java/com/scalamentis/modulos/modulo1/labs/memoria/GarbageCollectionDemo.java`

```java
package com.scalamentis.modulos.modulo1.labs.memoria;

public class GarbageCollectionDemo {

    static class DemoObject {
        private final String name;

        DemoObject(String name) {
            this.name = name;
            System.out.println("Creado: " + name);
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalizado (GC): " + name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Garbage Collection Demo ===");

        DemoObject obj1 = new DemoObject("Objeto 1");
        DemoObject obj2 = new DemoObject("Objeto 2");

        // Liberar referencias explícitamente
        obj1 = null;
        obj2 = null;

        // Solicitar recolección de basura
        System.gc();

        Thread.sleep(500); // Esperar a que GC finalice

        DemoObject obj3 = new DemoObject("Objeto 3");
        DemoObject obj4 = new DemoObject("Objeto 4");
        DemoObject obj5 = new DemoObject("Objeto 5");

        System.out.println("Fin del main");
    }
}
```

> **Nota:** `finalize()` está deprecado en versiones recientes de Java, pero se usa aquí solo con fines educativos para mostrar la recolección de objetos.

---

## 2️⃣ Compilar la clase

Desde la terminal, estando en la raíz del proyecto:

```bash
javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/memoria/GarbageCollectionDemo.java
```

- `-d` indica dónde se generarán los `.class`.

Se puede ignorar la advertencia de `finalize()` deprecado.

---

## 3️⃣ Ejecutar con logs de GC

Para observar cómo la JVM recolecta basura:

```bash
java -verbose:gc -Xlog:gc* -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.memoria.GarbageCollectionDemo
```

**Explicación de los flags:**

- `-verbose:gc` → imprime mensajes de GC.
- `-Xlog:gc*` → muestra detalles de cada recolección (tipo de GC, fases, heap).
- `-cp` → classpath hacia las clases compiladas.

---

## 4️⃣ Qué se ve en la salida

**Creación de objetos:**

```bash
Creado: Objeto 1
Creado: Objeto 2
```

**Recolección de basura:**

```bash
Finalizado (GC): Objeto 1 
Finalizado (GC): Objeto 2
```

>> La JVM libera los objetos que ya no tienen referencias.  
Esto puede ocurrir después de llamar `System.gc()`, aunque GC es no determinista.

**Creación de nuevos objetos:**

```bash
Creado: Objeto 3
Creado: Objeto 4
Creado: Objeto 5
```

**Heap y fases internas (resumen):**

- **Phase 1: Mark live objects** → identifica objetos todavía en uso.
- **Phase 2: Prepare for compaction** → organiza memoria para mover objetos vivos.
- **Phase 3: Adjust pointers** → actualiza referencias tras mover objetos.
- **Phase 4: Compact heap** → libera espacio contiguo para nuevos objetos.

---

## 5️⃣ Conceptos clave

| Concepto           | Explicación                                                                 |
|-------------------|-----------------------------------------------------------------------------|
| GC (Garbage Collection) | Limpieza automática de memoria, elimina objetos sin referencias.        |
| Heap               | Área de memoria donde se almacenan objetos en Java.                        |
| Finalize / Cleaner | Método que se llama antes de que el objeto sea recolectado (educativo).    |
| System.gc()        | Solicita recolección de basura, pero la JVM decide cuándo ejecutarla.      |
| G1 GC              | Recolector moderno, divide heap en regiones y compacta los objetos.       |

---

## 6️⃣ Observación práctica

- La primera vez que se crean objetos, ocupan espacio en el heap.
- Objetos liberados explícitamente (`obj1 = null`) pueden ser recolectados al invocar `System.gc()`.
- Los logs muestran exactamente cómo y cuándo la JVM libera memoria.
- Permite ver la combinación de portabilidad (Java) y gestión eficiente de memoria (GC).

---

## ⚠️ Observación importante

Es posible que algunos mensajes de:

```bash
Finalizado (GC)
```

Aparezcan después de que el programa volvió al menú, incluso aunque hayas escogigo otro item.

Esto ocurre porque el Garbage Collector de la JVM trabaja de forma **asíncrona**.

La JVM decide cuándo ejecutar el GC, incluso después de que el método `main` haya terminado.

---

# 🧪 Lab 02 — Stack vs Heap

🎯 **Objetivo**

Comprender la diferencia entre stack y heap en Java, cómo se almacenan variables y objetos, y cómo se relacionan las referencias con la memoria.

## 1️⃣ Código utilizado

**Archivo:**

`src/main/java/com/scalamentis/modulos/modulo1/labs/memoria/StackVsHeap.java`


```java
package com.scalamentis.modulos.modulo1.labs.memoria;

public class StackVsHeap {

    static class DemoObject {
        private final String name;

        DemoObject(String name) {
            this.name = name;
            System.out.println("Creado: " + name + " en heap, hash=" + System.identityHashCode(this));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stack vs Heap Demo ===");

        // Variables primitivas → stack
        int a = 10;
        int b = 20;
        System.out.println("Variables primitivas en stack: a=" + a + ", b=" + b);

        // Objetos → heap
        DemoObject obj1 = new DemoObject("Obj1");
        DemoObject obj2 = obj1; // Referencia stack apuntando al mismo heap
        DemoObject obj3 = new DemoObject("Obj3");

        System.out.println("obj1 hash=" + System.identityHashCode(obj1));
        System.out.println("obj2 hash=" + System.identityHashCode(obj2)); // mismo objeto
        System.out.println("obj3 hash=" + System.identityHashCode(obj3)); // distinto objeto

        // Cambiar referencias
        obj1 = null; // obj1 deja de apuntar, obj2 todavía apunta a Obj1
        System.out.println("obj1 liberado, obj2 sigue apuntando a Obj1");

        System.gc(); // Solicitar GC (obj1=null no libera realmente si hay otras referencias)

        System.out.println("Fin del main");
    }
}

```
> **Nota:** System.identityHashCode(obj) permite ver “identidad” del objeto en heap, útil para visualizar referencias.

---

## 2️⃣ Compilar la clase

Desde la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/memoria/StackVsHeap.java`

- -d indica dónde se generarán los .class.

---

## 3️⃣ Ejecutar con logs opcionales de GC

`java -verbose:gc -Xlog:gc* -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.memoria.StackVsHeap`

- -verbose:gc → imprime mensajes de GC (opcional, si querés ver recolección de memoria).
- -Xlog:gc* → muestra detalles de recolecciones y heap.
- -cp → classpath hacia las clases compiladas.

---

## 4️⃣ Qué se ve en la salida

```bash
=== Stack vs Heap Demo ===
Variables primitivas en stack: a=10, b=20
Creado: Obj1 en heap, hash=12345678
Creado: Obj3 en heap, hash=87654321
obj1 hash=12345678
obj2 hash=12345678
obj3 hash=87654321
obj1 liberado, obj2 sigue apuntando a Obj1
Fin del main
```

- Primitivos a y b → almacenados en stack.
- Objetos Obj1 y Obj3 → creados en heap.
- obj2 sigue apuntando a Obj1, demostrando que stack solo tiene referencias.
- obj1 = null no borra el objeto de heap mientras haya otra referencia (obj2).
- GC solo puede liberar objetos sin referencias activas.

---

## 5️⃣ Conceptos clave

| Concepto               | Explicación |
|------------------------|-------------|
| Stack                  | Memoria donde se guardan variables locales y referencias a objetos. Crece y se limpia automáticamente cuando un método termina. |
| Heap                   | Memoria donde se almacenan los objetos creados con `new`. Gestionada por la JVM y recolectada por GC. |
| Referencia             | Variable en stack que apunta a un objeto en heap. |
| System.identityHashCode| Permite ver la identidad del objeto en heap (útil para visualizar que dos referencias apuntan al mismo objeto). |
| System.gc()            | Solicita recolección de basura; la JVM decide si ejecutar o no. |
| Objeto sin referencias | Solo será recolectado por GC cuando no existan referencias activas apuntando a él. |

---

# 🧪 Lab 03 — String Pool

🎯 **Objetivo**

Entender cómo Java gestiona los strings literales mediante el String Pool, la diferencia entre referencias en heap y el pool, y cómo intern() afecta la reutilización de objetos.

## 1️⃣ Código utilizado

**Archivo:**

`src/main/java/com/scalamentis/modulos/modulo1/labs/memoria/StringPoolDemo.java`

```java
package com.scalamentis.modulos.modulo1.labs.memoria;

public class StringPoolDemo {

    public static void main(String[] args) {
        System.out.println("=== String Pool Demo ===");

        // Strings literales (reutilizan el pool)
        String s1 = "Hola";
        String s2 = "Hola";

        // Comparación de referencias
        System.out.println("s1 == s2: " + (s1 == s2)); // true, mismo objeto en pool

        // String con new (objeto nuevo en heap)
        String s3 = new String("Hola");
        System.out.println("s1 == s3: " + (s1 == s3)); // false, diferentes referencias

        // intern() fuerza a usar el pool
        String s4 = s3.intern();
        System.out.println("s1 == s4: " + (s1 == s4)); // true, ahora apunta al pool

        // Diferencias entre contenido y referencia
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true, mismo contenido
    }
}
```
> **Nota:**
== compara referencias (si apuntan al mismo objeto), mientras que equals() compara el contenido de los strings.

---

## 2️⃣ Compilar la clase

Desde la terminal, en la raíz del proyecto:

`javac -d out/production/java-labs src/main/java/com/scalamentis/modulos/modulo1/labs/memoria/StringPoolDemo.java`

- -d indica dónde se generarán los .class.

---

## 3️⃣ Ejecutar

`java -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.memoria.StringPoolDemo`

- -cp → classpath hacia las clases compiladas.

---

## 4️⃣ Qué se ve en la salida

```bash
=== String Pool Demo ===
s1 == s2: true
s1 == s3: false
s1 == s4: true
s1.equals(s3): true
```

**Explicación:**

- s1 == s2 → true porque ambos literales "Hola" comparten el mismo objeto en el String Pool.
- s1 == s3 → false porque s3 se creó con new String(), generando un objeto nuevo en heap.
- s1 == s4 → true porque s4 = s3.intern() apunta al objeto en el pool.
- s1.equals(s3) → true porque el contenido de ambos strings es igual, aunque las referencias sean distintas.

---

## 5️⃣ Conceptos clave

| Concepto        | Explicación                                                                                  |
|-----------------|----------------------------------------------------------------------------------------------|
| String literal  | Texto entre comillas "..." que Java almacena en el String Pool.                               |
| Heap            | Memoria donde se crean objetos con `new`.                                                    |
| String Pool     | Área especial de heap donde Java reutiliza literales idénticos.                               |
| intern()        | Método que devuelve la referencia al objeto en el pool si existe, o lo agrega si no existe. |
| ==              | Compara referencias (si dos variables apuntan al mismo objeto).                              |
| equals()        | Compara contenido del string, no referencias.                                               |

