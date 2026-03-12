# Programación Funcional y Streams en Java

## 1. Interfaces Funcionales

Una **interfaz funcional** es una interfaz que tiene **un único método abstracto**.  
Se utilizan junto con **expresiones lambda** y **Streams**.

```java
@FunctionalInterface
interface Operacion {
    int aplicar(int a, int b);
}
```

Uso con lambda:

```java
Operacion suma = (a, b) -> a + b;
System.out.println(suma.aplicar(3,4));
```

### Interfaces funcionales más importantes

| Interfaz | Entrada | Salida | Uso |
|---|---|---|---|
| `Predicate<T>` | T | boolean | filtros |
| `Function<T,R>` | T | R | transformar |
| `Consumer<T>` | T | void | ejecutar acciones |
| `Supplier<T>` | — | T | generar valores |
| `Comparator<T>` | T,T | int | ordenar |

---

# 2. Predicate (Filtros)

Un `Predicate` representa una función que recibe un objeto y devuelve **true o false**.

```java
Predicate<Employee> esIT = e -> e.getDepartment().equals("IT");
```

## Operaciones lógicas

| Método | Significado |
|---|---|
| `and()` | Y lógico |
| `or()` | O lógico |
| `negate()` | NOT |

Ejemplo:

```java
Predicate<Employee> esSenior = e -> e.getYearsAtCompany() > 5;

Predicate<Employee> itSenior = esIT.and(esSenior);

Predicate<Employee> noEsIT = esIT.negate();
```

Uso con Streams:

```java
employees.stream()
    .filter(itSenior)
    .forEach(System.out::println);
```

---

# 3. Function (Transformaciones)

Representa una función que **transforma un objeto en otro**.

```java
Function<Employee, Double> getSalary = e -> e.getSalary();
```

## Composición de funciones

### `andThen()`

Ejecuta primero la función actual y luego la siguiente.

```
f.andThen(g)
```

Equivale a:

```
g(f(x))
```

Ejemplo:

```java
Function<Employee, Double> getSalary = e -> e.getSalary();
Function<Double, Double> aplicarBonus = s -> s * 1.10;
Function<Double, String> formatear = s -> "$" + s;

Function<Employee, String> sueldoFinal =
    getSalary.andThen(aplicarBonus).andThen(formatear);
```

### `compose()`

Ejecuta primero la función pasada como parámetro.

```
f.compose(g)
```

Equivale a:

```
f(g(x))
```

---

# 4. Consumer (Acciones)

Un `Consumer` recibe un objeto y **no devuelve nada**.

Se usa para ejecutar acciones.

```java
Consumer<Employee> imprimir = e -> System.out.println(e);
```

Uso:

```java
employees.forEach(imprimir);
```

### Encadenar acciones

```java
Consumer<Employee> log =
    e -> System.out.println("Procesando " + e.getName());

Consumer<Employee> mostrar =
    e -> System.out.println(e);

employees.forEach(log.andThen(mostrar));
```

---

# 5. Supplier

Genera valores **sin recibir parámetros**.

```java
Supplier<Double> random = () -> Math.random();
```

Uso:

```java
System.out.println(random.get());
```

---

# 6. Programación Funcional

La programación funcional consiste en **tratar las funciones como datos** y trabajar de forma **declarativa**.

Principios principales:

## 1. Inmutabilidad

Los datos **no se modifican**, se crean nuevos.

Incorrecto:

```java
list.add("nuevo");
```

Correcto:

```java
List<String> nueva =
    list.stream().collect(Collectors.toList());
```

---

## 2. Funciones puras

Una función pura:

- siempre produce el mismo resultado
- no modifica variables externas
- no tiene efectos secundarios

Ejemplo:

```java
int cuadrado(int x){
    return x * x;
}
```

---

## 3. Declarativo vs Imperativo

### Imperativo (cómo hacerlo)

```java
List<String> nombres = new ArrayList<>();

for(Employee e : employees){
    if(e.getSalary() > 2000){
        nombres.add(e.getName());
    }
}
```

### Declarativo (qué quieres)

```java
List<String> nombres = employees.stream()
    .filter(e -> e.getSalary() > 2000)
    .map(Employee::getName)
    .collect(Collectors.toList());
```

---

# 7. Streams en Java

Un **Stream** es una secuencia de datos que permite procesarlos de forma funcional.

```java
employees.stream()
```

Un Stream tiene tres partes.

---

## 1. Fuente

La colección de datos.

```java
employees.stream()
```

---

## 2. Operaciones intermedias

Devuelven otro Stream.

| Operación | Uso |
|---|---|
| `filter()` | filtrar |
| `map()` | transformar |
| `sorted()` | ordenar |
| `limit()` | limitar |
| `distinct()` | eliminar duplicados |
| `peek()` | inspeccionar |

Ejemplo:

```java
stream.filter(...)
```

---

## 3. Operaciones terminales

Ejecutan el Stream.

| Operación | Resultado |
|---|---|
| `forEach()` | ejecuta acción |
| `collect()` | crea colección |
| `count()` | contar |
| `reduce()` | reducir |
| `findFirst()` | primer elemento |

Ejemplo:

```java
.collect(Collectors.toList());
```

---

# 8. Lazy Evaluation (Evaluación perezosa)

Los Streams **no se ejecutan hasta que aparece una operación terminal**.

Ejemplo:

```java
employees.stream()
    .filter(e -> {
        System.out.println(e);
        return true;
    });
```

Esto **no imprime nada**.

Correcto:

```java
employees.stream()
    .filter(e -> {
        System.out.println(e);
        return true;
    })
    .count();
```

---

# 9. Short Circuit (Cortocircuito)

Algunas operaciones **detienen el Stream antes de recorrer todos los elementos**.

| Método | Comportamiento |
|---|---|
| `findFirst()` | se detiene al encontrar uno |
| `anyMatch()` | se detiene al encontrar uno |
| `noneMatch()` | se detiene al encontrar uno |
| `limit()` | se detiene al llegar al límite |

Ejemplo:

```java
employees.stream()
    .filter(e -> e.getSalary() > 5000)
    .findFirst();
```

---

# 10. Method References

Forma corta de escribir lambdas.

En vez de:

```java
e -> e.getName()
```

Se usa:

```java
Employee::getName
```

Tipos:

| Tipo | Ejemplo |
|---|---|
| método de instancia | `Employee::getName` |
| método estático | `Integer::parseInt` |
| constructor | `ArrayList::new` |

Ejemplo:

```java
employees.stream()
    .map(Employee::getName)
    .forEach(System.out::println);
```

---

# 11. Reduce (muy importante)

`reduce` combina todos los elementos en uno.

Ejemplo sumar números:

```java
int suma = numbers.stream()
    .reduce(0, (a,b) -> a + b);
```

Equivalente a:

```java
int suma = 0;

for(int n : numbers){
    suma += n;
}
```

---

# 12. Ejemplo completo (tipo examen)

```java
List<String> topIT = employees.stream()

    .filter(e -> e.getDepartment().equals("IT"))

    .sorted(Comparator.comparing(Employee::getSalary).reversed())

    .limit(3)

    .map(Employee::getName)

    .collect(Collectors.toList());
```

Flujo del Stream:

```
employees
   ↓
filter
   ↓
sorted
   ↓
limit
   ↓
map
   ↓
collect
```

---

# 13. Errores típicos de examen

### 1. Pensar que el Stream modifica la lista

Incorrecto.  
Los Streams **no modifican la colección original**.

---

### 2. Olvidar operación terminal

```java
stream.filter(...)
```

No ejecuta nada.

---

### 3. Confundir `map` y `filter`

```
filter → devuelve boolean
map → transforma el objeto
```

---

### 4. Confundir `andThen` y `compose`

```
andThen → izquierda → derecha
compose → derecha → izquierda
```

---

### 5. Intentar usar variables modificadas dentro de lambda

Las variables usadas en lambdas deben ser **final o effectively final**.

# Ejemplos

```java
List<Integer> allNodes = IntStream.range(0, graph.size()).boxed().collect(Collectors.toList());
```

```java 
private static List<Integer> filterNodes(List<Integer> nodes, Predicate<Integer> p) {
    return nodes.stream()
        .filter(p)
        .collect(Collectors.toList());
}
```

```java
System.out.println("Departamentos");
employees.stream()
    .map(Employee::getDepartment)
    .filter(dept -> dept != null && !dept.trim().isEmpty())
    .map(String::toUpperCase)
    .distinct()
    .sorted()
    .forEach(dept -> System.out.println(dept));
```

```java
int[] PRUEBAS = {-2, -1, 0, 1, 2, 3, 5};

int total = (int) Arrays.stream(PRUEBAS).count(); 
boolean pares = Arrays.stream(PRUEBAS).anyMatch(x -> (x%2) == 0); 
boolean todosPositivos = Arrays.stream(PRUEBAS).allMatch(x -> x > 0); 
```