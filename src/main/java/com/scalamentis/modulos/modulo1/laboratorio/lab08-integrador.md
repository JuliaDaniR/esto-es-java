# 🧪 LAB 08 — Proyecto Integrador

## 🎯 Objetivo

En este laboratorio se desarrolla un **mini proyecto integrador** que permite comparar dos estilos de programación en Java:

- una implementación **legacy (Java antiguo)**
- una implementación **refactorizada con Java moderno**

El objetivo no es solo ejecutar código, sino **analizar cómo evoluciona el estilo de programación en Java** y cómo impactan las mejoras del lenguaje en:

- legibilidad
- seguridad de tipos
- mantenibilidad
- expresividad del código

Además realizamos un **pequeño experimento de rendimiento** para observar cómo se comportan ambas implementaciones.

---

## 🧩 Contexto del ejercicio

El programa simula un **procesador de pedidos**.

Cada pedido tiene un identificador como:

```bash
A100
B200
A300
```

**La lógica del sistema es simple:**

1. Recibir pedidos
2. Procesarlos
3. Contar cuántas veces aparece cada pedido que **comienza con "A"**
4. Generar un resumen del historial

**Ejemplo de salida esperada:**

```bash
A100:2;A300:1
```

---

## 🧪 Parte 1 — Implementación Legacy

La primera versión del código utiliza prácticas comunes en versiones antiguas de Java.

**Características del código:**

- uso de **Collections sin generics**
- uso de **Object**
- chequeo manual con `instanceof`
- iteradores manuales
- concatenación de Strings
- API antigua de fechas (`Date`)
- bucles `for` tradicionales

**Ejemplo simplificado:**

```java
private List pedidos = new ArrayList<>();
private Map historial = new HashMap();
```

Esto puede provocar problemas como:

- falta de seguridad de tipos
- código más difícil de mantener
- posibilidad de errores en tiempo de ejecución

---

## 🧪 Parte 2 — Implementación Refactorizada

La segunda versión aplica Java moderno y buenas prácticas.

**Mejoras aplicadas:**
- Generics
- Streams API
- API moderna de fechas (Instant)
- código más declarativo
- menor cantidad de código boilerplate

**Ejemplo:**

```java
private final List<String> pedidos = new ArrayList<>();
private final Map<String, Integer> historial = new HashMap<>();
```

Procesamiento con Streams:

```java
pedidos.stream()
       .filter(p -> p.startsWith("A"))
       .forEach(p -> historial.merge(p, 1, Integer::sum));
```

**Esto mejora:**

- claridad del código
- legibilidad
- seguridad de tipos

---

## 🧪 Parte 3 — Experimento de rendimiento

Se realizó un pequeño experimento para comparar el tiempo de ejecución de ambas implementaciones.

**Para ello se utilizó:**

```java
System.nanoTime();
```

**Ejemplo de medición:**

```java
long inicio = System.nanoTime();
procesar();
long fin = System.nanoTime();
```

> Esto permite medir el tiempo en nanosegundos.

Para obtener resultados más estables se realizaron:

- iteraciones múltiples
- una fase de warmup para permitir que la JVM optimice el código con el JIT Compiler

---

## 📊 Resultados observados

Un resultado típico del experimento fue:

```bash
Tiempo promedio legacy (ns): 281
Tiempo promedio moderno (ns): 754
```

En este caso la implementación legacy resultó más rápida.

Esto puede parecer inesperado, pero tiene explicación.

## 🧠 Interpretación de los resultados

La implementación legacy utiliza:

- loops simples
- operaciones directas

El código moderno usa:

- Streams
- lambdas
- pipelines de operaciones

Estas abstracciones introducen un pequeño overhead.

Para colecciones muy pequeñas (como en este experimento), el costo del pipeline de Streams puede ser mayor que el trabajo real.

**Por eso el loop tradicional puede resultar más rápido.**

---

## ⚠️ Importante

Este experimento no significa que el código legacy sea mejor.

El objetivo del refactor no es únicamente mejorar el rendimiento, sino:

- mejorar la mantenibilidad
- aumentar la seguridad de tipos
- escribir código más expresivo
- reducir errores potenciales

> En proyectos reales, estas ventajas suelen ser más importantes que micro-optimizar unas pocas operaciones.

---

## 🔬 Observación interesante

Durante las primeras ejecuciones del programa se observó que los tiempos variaban.

Esto ocurre porque la JVM utiliza un compilador dinámico llamado JIT (Just-In-Time Compiler).

El JIT analiza el código que se ejecuta con frecuencia y lo recompila a código máquina optimizado.

Por eso en algunos casos los tiempos pueden mejorar después de varias ejecuciones.

---

## 🧠 Idea clave del laboratorio

Este laboratorio muestra dos cosas importantes:

1️⃣ Cómo ha evolucionado el estilo de programación en Java

2️⃣ Cómo pequeñas diferencias de implementación pueden afectar el rendimiento

### Pero también enseña algo más importante:

El código más rápido no siempre es el mejor código.

### En ingeniería de software se busca equilibrio entre:

- rendimiento
- claridad
- mantenibilidad
- seguridad

> Java moderno apunta principalmente a mejorar la calidad del código.

---

## 🧪 Experimentos sugeridos

Para seguir explorando este laboratorio se pueden probar algunas modificaciones:

**1️⃣ Aumentar la cantidad de pedidos**

> - Probar con miles de pedidos en lugar de unos pocos.
> - Esto permite observar si el comportamiento de rendimiento cambia.

**2️⃣ Probar parallelStream()**

> - pedidos.parallelStream()
> - Esto permite utilizar procesamiento paralelo en múltiples núcleos.

**3️⃣ Analizar el comportamiento del JIT**

> - Ejecutar el programa varias veces y observar cómo cambian los tiempos.

---

## 🏁 Conclusión

Este proyecto integrador conecta muchos de los conceptos vistos en el módulo:

- Collections
- Generics
- Streams
- JVM
- optimización del código
- evolución del lenguaje Java

También introduce una idea fundamental en programación:

> Escribir código moderno no significa necesariamente hacerlo más rápido, sino hacerlo mejor diseñado y más mantenible.