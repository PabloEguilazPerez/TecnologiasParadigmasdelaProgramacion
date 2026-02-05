package functionalStreamStudent;

import java.util.function.*;
import java.util.*;
import java.util.stream.*;

public class FunctionalStream {

    public static void main(String[] args) {
        System.out.println("=== BLOQUE 1: Functional Interfaces sin Streams ===\n");

        ejercicio1PredicateStringIsEmpty();
        ejercicio2PredicateCharacterIsUpperCase();
        ejercicio3FunctionStringToLength();
        ejercicio4FunctionStringToIntegerParse();
        ejercicio5ConsumerPrintWithSystemOut();
        ejercicio6ConsumerAddToList();
        ejercicio7SupplierRandomNumber();
        ejercicio8SupplierCreateStringBuilder();

        System.out.println("=== FIN BLOQUE 1 ===\n");

        System.out.println("=== BLOQUE 2: Streams basicos (sin map/flatMap/reduce) ===\n");
        runBlock2StreamsBasics();
        System.out.println("=== FIN BLOQUE 2 ===\n");

        System.out.println("=== MINI TEXT STREAM LAB ===\n");
        runMiniTextStreamLab();
        System.out.println("=== FIN MINI TEXT STREAM LAB ===");
    }

    // =========================================================
    // BLOQUE 1 - INTERFACES FUNCIONALES Y METHOD REFERENCES
    // =========================================================

    /**
     * Ejercicio 1:
     * Predicate<String> usando referencia a metodo de instancia de objeto (String::isEmpty)
     * y su lambda equivalente (s -> s.isEmpty()).
     */
    public static void ejercicio1PredicateStringIsEmpty() {
        System.out.println("Ejercicio 1: Predicate<String> con String::isEmpty");
        // TODO: implementar Predicate<String> usando String::isEmpty
        // y su lambda equivalente, probando con cadenas vacia y no vacia.
        System.out.println();
    }

    /**
     * Ejercicio 2:
     * Predicate<Character> usando referencia a metodo estatico (Character::isUpperCase)
     * y su lambda equivalente (c -> Character.isUpperCase(c)).
     */
    public static void ejercicio2PredicateCharacterIsUpperCase() {
        System.out.println("Ejercicio 2: Predicate<Character> con Character::isUpperCase");
        // TODO: implementar Predicate<Character> usando Character::isUpperCase
        // y su lambda equivalente, probando con letras mayusculas y minusculas.
        System.out.println();
    }

    /**
     * Ejercicio 3:
     * Function<String,Integer> usando referencia a metodo de instancia de tipo (String::length)
     * y su lambda equivalente (s -> s.length()).
     */
    public static void ejercicio3FunctionStringToLength() {
        System.out.println("Ejercicio 3: Function<String,Integer> con String::length");
        // TODO: implementar Function<String,Integer> usando String::length
        // y su lambda equivalente, probando con varias palabras.
        System.out.println();
    }

    /**
     * Ejercicio 4:
     * Function<String,Integer> usando referencia a metodo estatico (Integer::parseInt)
     * y su lambda equivalente (s -> Integer.parseInt(s)).
     */
    public static void ejercicio4FunctionStringToIntegerParse() {
        System.out.println("Ejercicio 4: Function<String,Integer> con Integer::parseInt");
        // TODO: implementar Function<String,Integer> usando Integer::parseInt
        // y su lambda equivalente, probando con varias cadenas numericas.
        System.out.println();
    }

    /**
     * Ejercicio 5:
     * Consumer<String> usando referencia a metodo de instancia de objeto (System.out::println)
     * y su lambda equivalente (s -> System.out.println(s)).
     */
    public static void ejercicio5ConsumerPrintWithSystemOut() {
        System.out.println("Ejercicio 5: Consumer<String> con System.out::println");
        // TODO: implementar Consumer<String> usando System.out::println
        // y su lambda equivalente, imprimiendo varios mensajes.
        System.out.println();
    }

    /**
     * Ejercicio 6:
     * Consumer<String> usando referencia a metodo de instancia de objeto (lista::add)
     * y su lambda equivalente (s -> lista.add(s)).
     */
    public static void ejercicio6ConsumerAddToList() {
        System.out.println("Ejercicio 6: Consumer<String> con lista::add");
        // TODO: crear una lista de String, definir un Consumer<String> usando lista::add
        // y otro usando lambda, y mostrar el contenido final de la lista.
        System.out.println();
    }

    /**
     * Ejercicio 7:
     * Supplier<Double> usando referencia a metodo estatico (Math::random)
     * y su lambda equivalente (() -> Math.random()).
     */
    public static void ejercicio7SupplierRandomNumber() {
        System.out.println("Ejercicio 7: Supplier<Double> con Math::random");
        // TODO: implementar Supplier<Double> usando Math::random
        // y su lambda equivalente, mostrando varios valores generados.
        System.out.println();
    }

    /**
     * Ejercicio 8:
     * Supplier<StringBuilder> usando referencia a constructor (StringBuilder::new)
     * y su lambda equivalente (() -> new StringBuilder()).
     */
    public static void ejercicio8SupplierCreateStringBuilder() {
        System.out.println("Ejercicio 8: Supplier<StringBuilder> con StringBuilder::new");
        // TODO: implementar Supplier<StringBuilder> usando StringBuilder::new
        // y su lambda equivalente, construyendo y mostrando cadenas.
        System.out.println();
    }

    // =========================================================
    // BLOQUE 2 - STREAMS BÁSICOS 
    // =========================================================

    /**
     * En este metodo se agrupan los ejercicios del Bloque 2 sobre streams:
     * - creacion de streams,
     * - operaciones terminales (forEach, count, anyMatch, allMatch, noneMatch),
     * - cadenas de operaciones intermedias (filter, sorted, distinct, limit)
     *   seguidas de una terminal.
     *
     * El alumnado debe escribir el codigo correspondiente a cada ejercicio.
     */
    public static void runBlock2StreamsBasics() {

        // -----------------------------------------------------
        // Ejercicio 1: Crear streams de distintas formas
        // -----------------------------------------------------
        System.out.println("Ejercicio 1 (Bloque 2): Crear streams de distintas formas");
        // TODO:
        // - Crear un Stream<String> a partir de una lista de nombres.
        // - Crear un IntStream a partir de un array de enteros.
        // - Recorrer ambos streams con forEach para mostrar su contenido.
        System.out.println();

        // -----------------------------------------------------
        // Ejercicio 2: Solo operaciones terminales (count, anyMatch, allMatch)
        // -----------------------------------------------------
        System.out.println("Ejercicio 2 (Bloque 2): Solo operaciones terminales");
        // TODO:
        // - Definir una lista de enteros.
        // - Usar count() para contar elementos.
        // - Usar anyMatch() para comprobar si hay algun numero par.
        // - Usar allMatch() para comprobar si todos son positivos.
        System.out.println();

        // -----------------------------------------------------
        // Ejercicio 3: Uso de noneMatch
        // -----------------------------------------------------
        System.out.println("Ejercicio 3 (Bloque 2): Uso de noneMatch");
        // TODO:
        // - Definir otra lista de enteros.
        // - Usar noneMatch() para comprobar que ningun elemento es par.
        System.out.println();

        // -----------------------------------------------------
        // Ejercicio 4: Cadena con filter + forEach
        // -----------------------------------------------------
        System.out.println("Ejercicio 4 (Bloque 2): filter + forEach");
        // TODO:
        // - Definir una lista de palabras.
        // - Crear un stream, filtrar las que tengan longitud > 3 y mostrarlas con forEach.
        System.out.println();

        // -----------------------------------------------------
        // Ejercicio 5: Cadena con filter + sorted + forEach
        // -----------------------------------------------------
        System.out.println("Ejercicio 5 (Bloque 2): filter + sorted + forEach");
        // TODO:
        // - Definir una lista de cadenas (por ejemplo, nombres de ciudades).
        // - Filtrar segun una condicion y ordenar alfabeticamente antes de mostrar.
        System.out.println();

        // -----------------------------------------------------
        // Ejercicio 6: Cadena con distinct + filter + count
        // -----------------------------------------------------
        System.out.println("Ejercicio 6 (Bloque 2): distinct + filter + count");
        // TODO:
        // - Definir una lista de enteros con repeticiones.
        // - Usar distinct() para eliminar duplicados.
        // - Filtrar solo los pares y contar cuantos hay.
        System.out.println();

        // -----------------------------------------------------
        // Ejercicio 7: Cadena con filter + limit + forEach
        // -----------------------------------------------------
        System.out.println("Ejercicio 7 (Bloque 2): filter + limit + forEach");
        // TODO:
        // - Definir una lista de enteros.
        // - Filtrar mayores que un cierto valor.
        // - Usar limit() para quedarse con los primeros resultados y mostrarlos.
        System.out.println();
    }

    // =========================================================
    // TEXTO BASE PARA LA MINIAPLICACION DE STREAMS DE TEXTO
    // =========================================================

    /**
     * Texto base para la miniaplicacion.
     * El profesorado puede sustituir estas lineas por el monologo real si lo desea.
     */
    private static final List<String> TEXT_LINES = Arrays.asList(
        "I've seen things you people wouldn't believe.",
        "Attack ships on fire off the shoulder of Orion.",
        "I watched C-beams glitter in the dark near the Tannhauser Gate.",
        "All those moments will be lost in time, like tears in rain.",
        "Time to die."
    );

    // ---------------------------------------------------------
    // Metodos auxiliares de la miniaplicacion de texto
    // ---------------------------------------------------------

    /**
     * Devuelve una lista con todas las palabras del texto en TEXT_LINES,
     * separando por espacios.
     */
    private static List<String> getAllWordsFromText() {
        List<String> words = new ArrayList<>();
        for (String line : TEXT_LINES) {
            String[] parts = line.split("\\s+");
            for (String p : parts) {
                if (!p.isEmpty()) {
                    words.add(p);
                }
            }
        }
        return words;
    }

    /**
     * Devuelve true si la cadena contiene al menos un digito.
     */
    private static boolean containsDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // =========================================================
    // MINIAPLICACION: MINI TEXT STREAM LAB (ESQUELETO)
    // =========================================================

    /**
     * Metodo principal del laboratorio de texto.
     * Muestra un menu y llama a las distintas opciones.
     */
    public static void runMiniTextStreamLab() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printTextLabMenu();
            System.out.print("Choose an option: ");
            String line = sc.nextLine().trim();
            int option;
            try {
                option = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option, try again.");
                System.out.println();
                continue;
            }

            List<String> words = getAllWordsFromText();

            switch (option) {
                case 1:
                    runOption1ShowOriginalText();
                    break;
                case 2:
                    runOption2BasicStatistics(words);
                    break;
                case 3:
                    runOption3WordsStartingWith(sc, words);
                    break;
                case 4:
                    runOption4DistinctSortedWords(words);
                    break;
                case 5:
                    runOption5CheckWordConditions(words);
                    break;
                case 6:
                    runOption6FirstWordsWithMinLength(sc, words);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting text stream lab.");
                    break;
                default:
                    System.out.println("Unknown option, try again.");
            }
            System.out.println();
        }
        
    }

    private static void printTextLabMenu() {
        System.out.println("=== Mini Text Stream Lab ===");
        System.out.println("1. Show original text (lines)");
        System.out.println("2. Basic statistics about words");
        System.out.println("3. List words starting with a given letter");
        System.out.println("4. List distinct words sorted alphabetically");
        System.out.println("5. Check conditions on words (anyMatch / allMatch / noneMatch)");
        System.out.println("6. Show first 5 words with minimum length");
        System.out.println("0. Exit text lab");
    }

    // ---------------------------------------------------------
    // Opcion 1: mostrar texto original linea a linea
    // ---------------------------------------------------------
    private static void runOption1ShowOriginalText() {
        System.out.println("Original text (lines):");
        // TODO: crear un stream a partir de TEXT_LINES y mostrar cada linea con forEach.
    }

    // ---------------------------------------------------------
    // Opcion 2: estadisticas sobre palabras
    // ---------------------------------------------------------
    private static void runOption2BasicStatistics(List<String> words) {
        // TODO:
        // - Calcular total de palabras con count().
        // - Calcular palabras distintas con distinct().count().
        // - Calcular cuantas tienen longitud > 5 con filter().count().
        // - Mostrar los resultados por pantalla.
    }

    // ---------------------------------------------------------
    // Opcion 3: palabras que empiezan por una letra dada
    // ---------------------------------------------------------
    private static void runOption3WordsStartingWith(Scanner sc, List<String> words) {
        // TODO:
        // - Pedir al usuario una letra (usar solo el primer caracter).
        // - Filtrar palabras que empiecen por esa letra ignorando mayusculas/minusculas.
        // - Mostrar las palabras resultantes.
    }

    // ---------------------------------------------------------
    // Opcion 4: palabras distintas ordenadas alfabeticamente
    // ---------------------------------------------------------
    private static void runOption4DistinctSortedWords(List<String> words) {
        // TODO:
        // - Crear un stream desde words.
        // - Aplicar distinct() y luego sorted().
        // - Mostrar el resultado con forEach.
    }

    // ---------------------------------------------------------
    // Opcion 5: anyMatch / allMatch / noneMatch sobre palabras
    // ---------------------------------------------------------
    private static void runOption5CheckWordConditions(List<String> words) {
        // TODO:
        // - Usar anyMatch para comprobar si hay alguna palabra con longitud > 10.
        // - Usar allMatch para comprobar si todas las palabras tienen longitud > 1.
        // - Usar noneMatch junto con containsDigit para comprobar que ninguna palabra tiene digitos.
        // - Mostrar los resultados por pantalla.
    }

    // ---------------------------------------------------------
    // Opcion 6: primeras 5 palabras con una longitud minima
    // ---------------------------------------------------------
    private static void runOption6FirstWordsWithMinLength(Scanner sc, List<String> words) {
        // TODO:
        // - Pedir al usuario un entero con la longitud minima.
        // - Crear un stream, filtrar palabras con longitud >= longitud minima.
        // - Usar limit(5) para mostrar solo las primeras 5 palabras que cumplan la condicion.
    }
}

