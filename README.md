# ☕ Esto es Java — Módulo 1

![Java](https://img.shields.io/badge/Java-21+-orange)
![Labs](https://img.shields.io/badge/labs-prácticos-green)

Este módulo introduce los **fundamentos de Java y la JVM**.  
El objetivo es comprender **cómo funciona Java internamente**, más allá de solo escribir código.

Aquí exploramos conceptos esenciales como:

- La **plataforma Java**
- La **JVM**
- El **bytecode**
- La **memoria y el Garbage Collector**
- El **String Pool**
- La evolución del lenguaje
- Un **proyecto integrador**

Este módulo combina **explicación conceptual + experimentación práctica**.

---

## 🧭 Cómo está organizado el módulo

El módulo se divide en dos partes principales:

```
modulo1
│
├── laboratorio
│ ├── explicaciones y guías conceptuales
│
├── labs
│ ├── ejercicios prácticos en código
│
└── README.md
```

## 📖 Carpeta `laboratorio`

Contiene la **explicación teórica de cada laboratorio**.

Aquí encontrarás:

- contexto conceptual
- explicación paso a paso
- ejemplos de código
- referencias al laboratorio práctico

Estos documentos funcionan como **guía de estudio**.

---

## 🧪 Carpeta `labs`

Aquí se encuentran los **ejercicios prácticos**.

En estos laboratorios podrás:

- ejecutar código Java
- modificar ejemplos
- experimentar con el comportamiento de la JVM
- observar cómo funciona Java internamente

---

## 🔗 Relación entre `labs` y `laboratorios`

Cada laboratorio tiene dos partes:

| Parte | Ubicación | Descripción |
|-----|-----|-----|
| Explicación | `laboratorios/` | Explica el concepto |
| Práctica | `labs/` | Código para experimentar |

Ejemplo:

```bash
laboratorios/lab05-memoria.md
```

explica el funcionamiento del **Garbage Collector**

mientras que:

```bash
/modulo1/labs/memoria/GarbageCollectionDemo
```

contiene código para **experimentar con memoria y GC**.

---

## 📚 Laboratorios del módulo

| Lab | Tema |
|----|----|
| Lab 01 | Plataforma |
| Lab 02 | Memoria|
| Lab 03 | JVM |
| Lab 04 | Evolucion |
| Lab 05 | Legacy |
| Lab 06 | Modernizacion |
| Lab 07 | Refactor |
| Lab 08 | Proyecto integrador |

---

## 🧠 Recorrido sugerido

Se recomienda seguir los laboratorios **en orden**, ya que cada uno construye sobre el anterior.

### 1️⃣ Plataforma Java

- qué es Java
- cómo funciona la plataforma
- compilación y ejecución de programas

---

### 2️⃣ Memoria en Java

- cómo se almacenan los objetos
- referencias
- conceptos básicos de memoria

---

### 3️⃣ JVM

- qué es la Java Virtual Machine
- cómo ejecuta bytecode
- portabilidad del lenguaje

---

### 4️⃣ Evolución de Java

- historia del lenguaje
- cambios en versiones importantes
- introducción de nuevas características

---

### 5️⃣ Código Legacy

- características del código Java antiguo
- problemas comunes en sistemas legacy
- patrones que aparecen en código antiguo

---

### 6️⃣ Modernización

- uso de características modernas de Java
- mejoras de legibilidad y seguridad de tipos
- actualización de código existente

---

### 7️⃣ Refactorización

- transformación de código legacy
- mejora de diseño y estructura
- preparación del código para Java moderno

---

### 8️⃣ Proyecto Integrador

Implementación de un pequeño proyecto que compara:

- código **Java legacy**
- código **Java moderno**

Analizando:

- estilo de programación
- legibilidad
- rendimiento

---

## ▶️ Cómo ejecutar los laboratorios

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/JuliaDaniR/esto-es-java.git
```
2️⃣ Entrar al módulo
```bash
cd esto-es-java/modulo1
```
3️⃣ Ir al labs
```bash
labs/
```
4️⃣ Compilar
```bash
javac Archivo.java
```
5️⃣ Ejecutar
```bash
java Archivo
```
---
## 🎯 Objetivo del módulo

Al finalizar este módulo deberías poder:

- entender cómo funciona Java internamente
- comprender cómo la JVM ejecuta código
- analizar cómo se gestiona la memoria
- interpretar bytecode
- comprender la evolución del lenguaje Java

---

## 🧪 Recomendación

> No te limites a ejecutar el código.

**Intenta también:**

- modificar ejemplos
- cambiar estructuras
- agregar println
- experimentar con diferentes escenarios

> La mejor forma de aprender Java es experimentando con el código.

---

## ☕ Sobre este repositorio

> Este proyecto forma parte de Esto es Java, una serie de laboratorios diseñados para aprender > Java entendiendo cómo funciona realmente el lenguaje.

---

## 🔗 Recursos relacionados

- 📘 Documentación: https://scalamentis.vercel.app/esto-es-java  
- 🧪 Laboratorios incluidos en este repositorio  
- ☕ Código de ejemplo para experimentar con la JVM

---

## 👩‍💻 Autor

Proyecto creado por **Julia Rodriguez**.

Forma parte de la serie educativa **"Esto es Java"**, un conjunto de laboratorios diseñados para comprender cómo funciona Java internamente y desarrollar criterio técnico al programar.

GitHub:  
https://github.com/JuliaDaniR

---

## 📜 Licencia

Este proyecto se distribuye bajo la licencia **MIT**.

Puedes usar, estudiar y modificar el código libremente siempre que se mantenga la atribución al autor original.


> Aprender Java no es solo escribir código.
> Es entender cómo funciona la JVM.
