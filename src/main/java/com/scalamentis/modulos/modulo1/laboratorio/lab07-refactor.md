# 🧪 Lab 01 — Refactorización de Código

🎯 **Objetivo**

Comparar código “espagueti” con código refactorizado. Veremos cómo separar responsabilidades, reducir duplicación y mejorar legibilidad.

---

## 1️⃣ Código Espagueti

Archivo:

`CodigoEspagueti.java`

- Contiene métodos largos, if anidados, duplicación de código y mezcla de responsabilidades.
- Difícil de mantener y de probar.

```java
// Código completo de CodigoEspagueti.java (ejemplos de espagueti)
```

---

## 2️⃣ Código Refactorizado

Archivo:

`CodigoRefactorizado.java`

- Métodos pequeños con una sola responsabilidad.
- Eliminación de duplicación.
- Uso de guard clauses para reducir anidación.
- Separación de UI, lógica y persistencia.

```java
// Código completo de CodigoRefactorizado.java
```
---

## 3️⃣ Ejemplos comparativos

| Ejemplo | Espagueti | Refactorizado |
|---------|-----------|---------------|
| 1️⃣ Método gigante | `procesarTodo()` con todo mezclado | Se separa en `procesarElementos()`, `guardarResultados()`, `enviarNotificaciones()` |
| 2️⃣ If anidado | Varios if/else anidados | Uso de guard clauses para salir temprano y simplificar la lógica |
| 3️⃣ Duplicación | Impresión repetida de listas | Método `imprimirLista(List<String>)` reutilizable |
| 4️⃣ Mezcla de responsabilidades | UI, lógica y persistencia juntos | Separación en métodos `mostrarBienvenida()`, `calcularDescuento()`, `guardarCliente()` |

---

### 4️⃣ Conceptos clave

| Concepto | Explicación |
|----------|-------------|
| Refactorización | Mejorar estructura y legibilidad del código sin cambiar su comportamiento. |
| Código espagueti | Código difícil de leer, mantener y probar. |
| Métodos pequeños | Cada método realiza una sola acción, facilita mantenimiento y pruebas. |
| Guard clauses | Salida temprana para simplificar lógica condicional. |
| Separación de responsabilidades | UI, lógica de negocio y persistencia deben estar separados. |
| Eliminación de duplicación | Evitar repetir código para mejorar mantenibilidad. |

---

## 5️⃣ Observación práctica

> - Refactorizar mejora legibilidad, mantenibilidad y seguridad.
> - El código refactorizado es más fácil de probar y modificar.
> - Permite ver cómo pequeñas mejoras en la estructura pueden reducir errores y esfuerzo de mantenimiento.

---

