# 🧪 Lab 01 — JVM y Bytecode

Este laboratorio muestra cómo un programa Java no se ejecuta directamente como código nativo, sino que primero se compila a **bytecode**, que luego es interpretado o compilado por la **JVM (Java Virtual Machine)**.

El flujo real de ejecución es:

Java Source (.java)
↓
Compilador javac
↓
Bytecode (.class)
↓
JVM ejecuta las instrucciones

Este modelo permite que Java sea **multiplataforma**.

> Write Once, Run Anywhere

---

## 1️⃣ Código del laboratorio

Archivo:
src/main/java/com/scalamentis/modulos/modulo1/labs/jvm/BytecodeDemo.java


Ejemplo simplificado:

```java
public class BytecodeDemo {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int resultado = sumar(a, b);

        System.out.println("Resultado de la suma: " + resultado);
    }

    public static int sumar(int x, int y) {
        return x + y;
    }
}
```
---

## 2️⃣ Compilar el programa
Desde la terminal, ejecuta el compilador de Java:

```bash
javac BytecodeDemo.java
```
Esto genera el archivo: `BytecodeDemo.class`. Este archivo contiene el bytecode de la JVM.

---

## 3️⃣ Ver el bytecode generado
Java incluye una herramienta llamada `javap` que permite inspeccionar el bytecode.

**Ejecutar:**

```bash
javap -c BytecodeDemo
```

**Salida simplificada:**

```java
public static int sumar(int, int)
    Code:
    0:iload_0
    1:iload_1
    2:iadd
    3:ireturn
```
---

## 4️⃣ Interpretación del bytecode

El método Java original:

```java
return x + y;
```

Se convierte en las siguientes instrucciones de la JVM, que trabajan sobre una pila de ejecución:

| Instrucción | Significado |
| :--- | :--- |
| `iload_0` | Cargar primer parámetro |
| `iload_1` | Cargar segundo parámetro |
| `iadd` | Sumar enteros |
| `ireturn` | Devolver resultado |

---

## 5️⃣ Qué demuestra este laboratorio
Este experimento muestra que:

* **Java no se ejecuta directamente** como código máquina.
* **El compilador produce bytecode**, un lenguaje intermedio.
* **La JVM interpreta o compila** ese bytecode en tiempo real.
* **Portabilidad:** El mismo bytecode puede ejecutarse en cualquier sistema operativo.

---

## 6️⃣ Conceptos clave
* **JVM** (Java Virtual Machine)
* **Bytecode**
* **Compilación** con `javac`
* **Inspección** con `javap`
* **Modelo:** *Write Once, Run Anywhere*

### 🧠 Experimento adicional
Modifica el código agregando un loop:

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

Luego vuelve a ejecutar:

```bash
javap -c BytecodeDemo
```

Observar las nuevas instrucciones generadas:

- goto
- if_icmp
- iinc

### Esto permite explorar cómo la JVM representa estructuras de control como loops y condicional .

---

## 📘 Tabla de instrucciones de bytecode comunes

Al inspeccionar el bytecode con `javap`, aparecen instrucciones propias de la **JVM**.  
Estas instrucciones son operaciones de bajo nivel que la máquina virtual ejecuta.

A continuación se muestran algunas de las más comunes:

| Bytecode | Significado |
|--------|-------------|
| `iconst_0` | cargar entero 0 en la pila |
| `iconst_5` | cargar entero 5 en la pila |
| `iload` | cargar una variable entera desde las variables locales |
| `istore` | guardar un entero en las variables locales |
| `iadd` | sumar dos enteros |
| `iinc` | incrementar una variable entera |
| `getstatic` | obtener un campo estático (por ejemplo `System.out`) |
| `invokevirtual` | invocar un método de instancia |
| `invokestatic` | invocar un método estático |
| `invokedynamic` | invocar una llamada dinámica (usada por optimizaciones modernas como concatenación de Strings) |
| `goto` | salto incondicional a otra instrucción |
| `if_icmpge` | comparación entre enteros con salto condicional |
| `return` | finalizar el método |

---

## 🧠 Cómo leer el bytecode

Un fragmento como este:

- 60: iconst_0
- 61: istore 4
- 63: iload 4
- 65: iconst_5
- 66: if_icmpge 88


puede interpretarse como:

1. inicializar `i = 0`
2. cargar `i`
3. cargar `5`
4. comparar
5. si `i >= 5` → salir del loop

Las instrucciones de la JVM trabajan principalmente sobre:

- **pila de operandos (operand stack)**
- **variables locales (local variables)**

---

## 💡 Idea clave

El código Java de alto nivel:

```java
for (int i = 0; i < 5; i++) {
    System.out.println("indice " + i);
}
```

se transforma en una serie de instrucciones simples de bytecode que la JVM ejecuta paso a paso.

Esto permite que el mismo programa Java pueda ejecutarse en cualquier sistema operativo a través de la JVM.

---

# 🧪 Lab 02 — ClassLoader

## 🎯 Objetivo

En este laboratorio vamos a explorar **cómo la JVM carga las clases en memoria**.

Antes de que un programa Java pueda ejecutarse, sus clases deben ser:

1. encontradas
2. cargadas en memoria
3. verificadas por la JVM
4. preparadas para su ejecución

Este proceso es realizado por componentes llamados **ClassLoaders**.

---

## 🧠 ¿Qué es un ClassLoader?

Un **ClassLoader** es el responsable de **cargar clases dentro de la JVM**.

Cuando ejecutamos un programa Java, la JVM no conoce nuestras clases de antemano.  
Debe **localizarlas en el classpath y cargarlas dinámicamente**.

---

## 🧪 Clase utilizada

Clase del laboratorio:

```java
ClassLoaderDemo
```

Este programa imprime **qué ClassLoader cargó la clase actual**.

---

## ▶ Ejecutar el laboratorio

Compilar:

```bash
javac com/scalamentis/modulos/modulo1/labs/jvm/ClassLoaderDemo.java
```

Ejecutar:

```bash
java com.scalamentis.modulos.modulo1.labs.jvm.ClassLoaderDemo
```

---

## 🖥 Ejemplo de salida

```bash
=== ClassLoader Demo ===

ClassLoader que cargó esta clase:
jdk.internal.loader.ClassLoaders$AppClassLoader@2a139a55

ClassLoader padre:
jdk.internal.loader.ClassLoaders$PlatformClassLoader@4617c264

ClassLoader raíz (Bootstrap):
null
```

---

## 🔎 Qué estamos viendo

La JVM utiliza una **jerarquía de ClassLoaders**.

---
Bootstrap ClassLoader

&nbsp;
↓
&nbsp;

Platform ClassLoader

&nbsp;
↓
&nbsp;

Application ClassLoader

---
### Bootstrap ClassLoader

Carga las clases fundamentales del lenguaje.

Ejemplos:

```java
java.lang.Object
java.lang.String
java.lang.System
```

Está implementado dentro de la propia JVM, por eso en Java aparece como:

```java
null
```

---

### Platform ClassLoader

Carga módulos internos del JDK.

Ejemplos:

```java
java.sql
java.xml
java.logging
```

---

### Application ClassLoader

Carga **las clases de nuestra aplicación**.

Por ejemplo:

---
**ClassLoaderDemo**

&nbsp;
**↓**
&nbsp;

**HolaPlataforma**

&nbsp;
**↓**
&nbsp;

**BytecodeDemo**

---

## 🧠 Modelo de delegación

Los ClassLoaders siguen un modelo llamado:

**Parent Delegation Model**

Esto significa que antes de cargar una clase, un ClassLoader **delegará la búsqueda a su padre**.

El flujo es:

---

**Application ClassLoader**

&nbsp;
**↓**
&nbsp;

**Platform ClassLoader**

&nbsp;
**↓**
&nbsp;

**Bootstrap ClassLoader**

---
Si el padre no encuentra la clase, el ClassLoader actual intenta cargarla.

---

## 🧪 Experimento adicional

Podemos ver **todas las clases que la JVM carga durante la ejecución**.

Ejecutar:

```bash
java -verbose:class com.scalamentis.modulos.modulo1.labs.jvm.ClassLoaderDemo
```

La JVM mostrará mensajes como:

```bash
[Loaded java.lang.Object]
[Loaded java.lang.String]
[Loaded java.lang.System]
```

Esto demuestra que **las clases se cargan dinámicamente mientras el programa se ejecuta**.

---

## 🧠 Idea clave del laboratorio

Antes de ejecutar cualquier programa Java, la JVM debe:


- localizar la clase
- cargarla en memoria
- verificar su bytecode
- prepararla para ejecución
- ejecutar el método main()

Todo este proceso comienza con el **ClassLoader**.

---

# 🧪 Lab 03 — JIT (Just-In-Time Compiler)

## 🎯 Objetivo

Este laboratorio muestra cómo la **JVM optimiza la ejecución de métodos** que se llaman muchas veces, usando el **JIT Compiler**.

El JIT permite que Java no solo interprete bytecode, sino que compile partes del programa a **código nativo en tiempo real** para acelerar su ejecución.

---

## 1️⃣ Código utilizado

**Archivo:**  
`src/main/java/com/scalamentis/modulos/modulo1/labs/jvm/JitDemo.java`

Ejemplo simplificado:

```java
public class JitDemo {

    public static void main(String[] args) {
        System.out.println("=== JIT Demo Súper Visual ===");

        for (int i = 0; i < 5; i++) {
            buclePesadoConProgreso();
        }
    }

    public static void buclePesadoConProgreso() {
        long suma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            suma += i;
        }
    }
}
```
## 2️⃣ Ejecutar con JIT y ver compilaciones

Desde la terminal:

```bash
java -XX:+UnlockDiagnosticVMOptions -XX:+PrintCompilation -cp out/production/java-labs com.scalamentis.modulos.modulo1.labs.jvm.JitDemo
```
---

### Qué se ve en la salida

- La JVM lista los **métodos que está compilando** y su **nivel de optimización**.
- Métodos repetidos muchas veces se marcan con `%` → indica que el **JIT los está optimizando**.
- Algunos métodos aparecen como `native` → son métodos **implementados en código nativo del JDK**.
- También se muestra cuando un método pasa de **interpretado** a **compilado a código máquina** para acelerar su ejecución.

**Ejemplo simplificado de interpretación:**
- Método ejecutado 1 vez (sin optimización)
- Método ejecutado varias veces → activación del JIT

---

### 3️⃣ Conceptos clave

| Concepto       | Explicación                                                                 |
|----------------|----------------------------------------------------------------------------|
| **JIT**        | Compilador Just-In-Time: convierte bytecode a código nativo mientras el programa corre. |
| **HotSpot**    | Parte de la JVM que decide qué métodos optimizar según cuántas veces se ejecutan. |
| **Optimización** | Métodos repetidos muchas veces se ejecutan más rápido luego de la compilación JIT. |
| **%** en salida | Indica que un método se ha optimizado.                                      |
| **native**      | Método ya está implementado en código nativo del sistema.                  |

---

### 4️⃣ Observación práctica

Comparando la primera ejecución con las siguientes del mismo método:

- La primera ejecución puede tardar más, porque solo se interpreta el bytecode.
- Las ejecuciones siguientes son más rápidas, porque el **JIT ya compiló a código nativo**.

Esto demuestra cómo la JVM combina **portabilidad** (bytecode) con **rendimiento** (JIT).

---

### 5️⃣ Idea clave del laboratorio

- El **bytecode sigue siendo la base**, como vimos en Lab 01.
- El **JIT actúa sobre los métodos “calientes”** para acelerar su ejecución.
- La JVM **no ejecuta todo el código igual**: prioriza lo que más se repite.

Esto explica por qué los programas Java pueden ser **portables y rápidos al mismo tiempo**.