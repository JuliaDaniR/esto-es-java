# ☕ LAB — Plataforma Java

## 🎯 Objetivo

En este laboratorio vamos a explorar **sobre qué plataforma se ejecuta Java**.

Uno de los principios fundamentales del lenguaje es:

**Write Once, Run Anywhere**

Esto significa que un programa Java puede ejecutarse en **diferentes sistemas operativos** sin modificaciones.

Esto es posible gracias a la **JVM (Java Virtual Machine)**.

En este laboratorio vamos a:

- explorar información de la **JVM**
- ver datos del **sistema operativo**
- entender la diferencia entre **JVM, JRE y JDK**
- acceder a **variables del entorno**

---
## 🧪 Parte 1 — Hola Plataforma

**Clase:** `HolaPlataforma`

Este programa imprime **información básica del entorno donde se ejecuta Java**.

### Código

```java
System.out.println("Hola desde Java ☕");
System.out.println("Write Once, Run Anywhere");

System.out.println("Versión de Java: " + System.getProperty("java.version"));
System.out.println("Proveedor JVM: " + System.getProperty("java.vendor"));

System.out.println("Sistema Operativo: " + System.getProperty("os.name"));
System.out.println("Arquitectura: " + System.getProperty("os.arch"));
System.out.println("Usuario: " + System.getProperty("user.name"));
```
---

### 🔎 Qué estamos viendo

El método:

```java
System.getProperty()
```

- permite obtener propiedades de la JVM.

Estas propiedades describen:

- versión de Java

- proveedor de la JVM

- sistema operativo

- usuario actual

El programa no consulta directamente al sistema operativo.

La JVM actúa como intermediario entre el programa Java y el sistema operativo.

--- 

## 🧪 Parte 2 — Información del Sistema

**Clase:** `InfoSistema`

Este programa explora **más detalles del entorno donde se está ejecutando la JVM**.

### Propiedades utilizadas

| Propiedad | Significado |
|-----------|-------------|
| `os.name` | nombre del sistema operativo |
| `os.version` | versión del sistema |
| `os.arch` | arquitectura (x86, amd64, arm, etc.) |
| `user.name` | usuario actual |
| `user.home` | directorio home del usuario |
| `user.dir` | directorio donde se ejecuta el programa |

---

### Ejemplo de salida

```bash
=== Información del Sistema ===
Sistema Operativo: Windows 11
Versión del SO: 10.0
Arquitectura: amd64

=== Usuario ===
Usuario actual: user
Directorio home: C:\Users\user
Directorio de trabajo: C:\proyectos\java
```

Esto demuestra que **Java puede adaptarse al entorno donde se ejecuta**.

## 🧪 Parte 3 — JDK vs JRE vs JVM

**Clase:** `JdkVsJreDemo`

Este programa ayuda a entender **la estructura del ecosistema Java**.

---

## Conceptos clave

### JVM — Java Virtual Machine

Es la **máquina virtual que ejecuta el bytecode**.

Responsabilidades principales:

- ejecutar programas Java
- gestionar memoria
- manejar el **Garbage Collector**
- ejecutar instrucciones de **bytecode**

---

### JRE — Java Runtime Environment

El **JRE** es el entorno necesario para **ejecutar programas Java**.

Incluye:

- la **JVM**
- las **librerías estándar de Java**

Con el **JRE** solo podemos **ejecutar programas**, pero **no compilarlos**.

---

### JDK — Java Development Kit

El **JDK** es el **kit de desarrollo completo** para Java.

Incluye:

- el **JRE**
- el compilador **`javac`**
- herramientas de desarrollo
- utilidades como **`javadoc`**, **`jar`**, **`javap`**

Es lo que usan los desarrolladores para **crear programas Java**.

---

## Relación entre ellos

JDK

└── JRE

└── JVM


---

## 🧪 Parte 4 — Variables de Entorno

**Clase:** `VariablesEntorno`

Aquí exploramos cómo Java accede a **variables del sistema operativo**.

Existe una diferencia importante entre dos métodos de la clase `System`:

--- 

### Diferencia entre propiedades y variables de entorno

| Método | Accede a |
|------|------|
| `System.getProperty()` | propiedades de la JVM |
| `System.getenv()` | variables del sistema operativo |

---

### Ejemplo

```java
System.getenv("JAVA_HOME");
System.getenv("PATH");
```

Estas variables son configuradas directamente en el **sistema operativo**.

---

### Ejemplo típico

```java
JAVA_HOME = C:\Program Files\Java\jdk-21
```


Java puede leer estas variables para:

- encontrar el **JDK**
- localizar **herramientas del entorno**
- configurar el **entorno de ejecución**

--- 

### 🔎 **Exploración extra**

El programa también imprime **todas las variables del sistema**:

```java
Map<String, String> variables = System.getenv();
```
Esto devuelve un Map con todas las variables del entorno del sistema operativo.

Luego podemos recorrerlas usando un loop:

```java
for (Map.Entry<String, String> entry : variables.entrySet())
```

Cada elemento del Map representa un par:

```java
NOMBRE = VALOR
```
Por ejemplo:

```bash
JAVA_HOME = C:\Program Files\Java\jdk-21
PATH = C:\Windows\System32;...
```

### 🧠 **Idea clave del laboratorio**

Un programa Java **no se comunica directamente con el sistema operativo**.

El flujo real es:

```bash
Programa Java
↓
JVM
↓
Sistema Operativo
```

La **JVM actúa como intermediaria** entre el programa Java y el sistema operativo.

Gracias a esta arquitectura, un mismo archivo compilado (`.class`) puede ejecutarse en **distintos sistemas operativos sin necesidad de recompilar**.

Por ejemplo:

- Windows
- Linux
- macOS

Este principio es lo que se conoce como:

**Write Once, Run Anywhere**  
*(escribe una vez, ejecuta en cualquier lugar).*