package mapsReuseCurry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

/**
 * Block 1: map / flatMap / reduce on an undirected graph.
 *
 * We represent the graph as an adjacency-list:
 *
 *   List<List<Integer>> graph
 *
 * where graph.get(i) is the list of neighbors of node i.
 *
 * Block 2: reusing lambdas with Predicate / Function / Consumer.
 */
public class GraphFunctional {

    // ------------------------------------------------------------
    // MAIN METHOD (test harness)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=== GraphFunctional: Blocks 1 and 2 ===");
        System.out.println();

        // Create a small sample graph:
        List<List<Integer>> graph = createSampleGraph();

        System.out.println("Adjacency-list representation:");
        printAdjacencyListGraph(graph);
        System.out.println();

        // Block 1: map / flatMap / reduce
        System.out.println("=== BLOCK 1: map / flatMap / reduce on graphs ===");
        System.out.println();

        exercise1_NodeDegrees(graph);
        System.out.println();

        exercise2_NeighborsOfNeighbors(graph, 0);
        System.out.println();

        exercise3_SecondLevelNeighborsUnique(graph, 0);
        System.out.println();

        exercise4_CountEdges(graph);
        System.out.println();

        exercise5_MaxDegreeNodes(graph);
        System.out.println();

        // Block 2: Reusing lambdas with Predicate / Function / Consumer
        System.out.println("=== BLOCK 2: Reusing Predicate / Function / Consumer ===");
        System.out.println();

        exercise1_FilterReusablePredicates(graph);
        System.out.println();

        exercise2_GraphPredicates(graph);
        System.out.println();

        exercise3_FunctionReusable(graph);
        System.out.println();

        exercise4_ConsumerReusable(graph);
        System.out.println();

        exercise5_PathValidationReusable(graph);
        System.out.println();

        System.out.println("=== End of GraphFunctional ===");
        

    }

    // ------------------------------------------------------------
    // Helper: build a small undirected graph
    // ------------------------------------------------------------

    /**
     * Builds an example graph:
     *
     * 0: 1, 2
     * 1: 0, 3
     * 2: 0, 3, 4
     * 3: 1, 2, 4
     * 4: 2, 3
     */
    private static List<List<Integer>> createSampleGraph() {
        int n = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected edges
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 2, 3);
        addUndirectedEdge(graph, 2, 4);
        addUndirectedEdge(graph, 3, 4);

        return graph;
    }

    /**
     * Adds an undirected edge u - v to the adjacency list.
     */
    private static void addUndirectedEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    /**
     * Prints the adjacency list of the graph.
     */
    private static void printAdjacencyListGraph(List<List<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node " + i + " -> " + graph.get(i));
        }
    }

    // ============================================================
    // BLOCK 1: map / flatMap / reduce on graphs
    // ============================================================

    /**
     * Exercise 1:
     * - Compute the degree of each node.
     * - Print the list of degrees.
     */
    private static void exercise1_NodeDegrees(List<List<Integer>> graph) {
  
    	// MI SOLUCION
        List<Integer> degrees = graph.stream()
                .map(List::size)
                .collect(Collectors.toList());
        
        System.out.println("Lista de grados: " + degrees);
        
        /*
        for (int i = 0; i < degrees.size(); i++) {
            System.out.println("El grado del nodo " + i + " es: " + degrees.get(i));
        }
        */
        IntStream.range(0, graph.size())
        	.forEach(i -> {
        		 System.out.println("El grado del nodo " + i + " es: " + degrees.get(i));
        	});
        
    }

    /**
     * Exercise 2:
     * - For a given node "start", compute all neighbors-of-neighbors:
     *     neighbors(neighbors(start))
     *   using Stream's map / flatMap.
     */
    private static void exercise2_NeighborsOfNeighbors(List<List<Integer>> graph, int start) {
    	
    	List<Integer> vecinosDirectos = graph.get(start);
    	System.out.println("Vecinos directos de " + start + ": "  + vecinosDirectos);
    	
    	List<Integer> vecinosDeVecinos = vecinosDirectos.stream()
                .flatMap(v -> graph.get(v).stream())
                .collect(Collectors.toList());

        System.out.println("Vecinos de vecinos (con duplicados): " + vecinosDeVecinos);
    }

    /**
     * Exercise 3:
     * - For a given node "start", compute the set of second-level neighbors
     *   (neighbors of neighbors) without duplicates and without including
     *   "start" itself.
     */
    private static void exercise3_SecondLevelNeighborsUnique(List<List<Integer>> graph, int start) {
    	
    	List<Integer> vecinosDirectos = graph.get(start);
        
        List<Integer> unicosSegundoNivel = vecinosDirectos.stream()
                .flatMap(v -> graph.get(v).stream())
                .distinct() 
                .filter(n -> n != start) 
                .filter(n -> !vecinosDirectos.contains(n))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Vecinos únicos de segundo nivel: " + unicosSegundoNivel);
    }

    /**
     * Exercise 4:
     * - Count the total number of edges in the undirected graph using reduce.
     *   (Recall that in an undirected graph represented this way, each edge
     *    appears twice in the adjacency list.)
     */
    private static void exercise4_CountEdges(List<List<Integer>> graph) {

        int totalDegree = graph.stream()
                .map(List::size)
                .reduce(0, Integer::sum);

  
        int edges = totalDegree / 2;

        System.out.println("Suma de grados: " + totalDegree);
        System.out.println("Número total de aristas: " + edges);
    }

    /**
     * Exercise 5:
     * - Find the node(s) with maximum degree using Streams.
     */
    private static void exercise5_MaxDegreeNodes(List<List<Integer>> graph) {
        
    	List<Integer> degrees = graph.stream()
				.map(List::size)
				.collect(Collectors.toList());

		int maxDegree = degrees.stream()
				.max(Integer::compareTo)
				.orElse(0);

		List<Integer> maxDegreeNodes = IntStream.range(0, degrees.size())
				.filter(i -> degrees.get(i) == maxDegree)
				.boxed()
				.collect(Collectors.toList());

		System.out.println("Grados de los nodos: " + degrees);
		System.out.println("Grado máximo: " + maxDegree);
		System.out.println("Nodos con grado máximo: " + maxDegreeNodes);
    	
    }

    // ============================================================
    // BLOCK 2: Reusing Predicate / Function / Consumer
    // ============================================================

    /**
     * Exercise 1:
     * - Build reusable Predicate<Integer> instances to filter nodes
     *   by degree, then apply them via a generic helper method.
     */
    public static void exercise1_FilterReusablePredicates(List<List<Integer>> graph) {

        List<Integer> numbers = List.of(-2, -1, 0, 1, 2, 3, 4, 5, 6);
        
  
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        
        
        List<Integer> result = numbers.stream()
                .filter(isEven.and(isPositive))
                .collect(Collectors.toList());
                
        System.out.println("Números pares y positivos: " + result);
    }

    /**
     * Exercise 2:
     * - Combine predicates and apply them to filter nodes
     *   (e.g. even degree AND degree >= 2, etc.).
     */
    public static void exercise2_GraphPredicates(List<List<Integer>> graph) {

        Predicate<Integer> isLeafNode = nodeIndex -> graph.get(nodeIndex).size() == 1;

        List<Integer> allNodes = IntStream.range(0, graph.size()).boxed().collect(Collectors.toList());
        
        List<Integer> leaves = filterNodes(allNodes, isLeafNode);
        
        System.out.println("Hojas ejercicio 2: " + leaves);

    }

    /**
     * Exercise 3:
     * - Use reusable Function<Integer, String> to create labels
     *   for nodes, and a Function<List<Integer>, String> to pretty-print paths.
     */
    public static void exercise3_FunctionReusable(List<List<Integer>> graph) {
        Function<Integer, Integer> doubleValue = n -> n * 2; 
        Function<Integer, Integer> increment = n -> n + 1;   

        Function<Integer, Integer> doubleThenIncrement = doubleValue.andThen(increment);

        int val = 5;
        System.out.println("Ejercicio 3 - Resultado para " + val + ": " + doubleThenIncrement.apply(val));
    }

    /**
     * Exercise 4:
     * - Define reusable Consumer<String> for logging,
     *   and compose them with andThen to see order effects.
     */
    public static void exercise4_ConsumerReusable(List<List<Integer>> graph) {

        Consumer<Integer> print = n -> System.out.print("Node: " + n + " ");
        Consumer<Integer> debug = n -> System.out.print("[debug] visiting " + n + " ");
        
        List<Integer> nodes = List.of(0, 1, 2);
        

        System.out.println("Ejecución compuesta (Print + Debug):");
        visitNodes(nodes, print.andThen(debug));
    }

    /**
     * Exercise 5:
     * - Use a reusable path validator (Predicate<Integer>) to check if
     *   a sequence of nodes is a valid path in the graph.
     */
    public static void exercise5_PathValidationReusable(List<List<Integer>> graph) {
  
        Predicate<Integer> positiveIndex = i -> i >= 0;
        Predicate<Integer> lessThanSize = i -> i < graph.size();
        Predicate<Integer> validIndex = positiveIndex.and(lessThanSize);

        java.util.function.BiPredicate<Integer, Integer> areAdjacent = 
            (u, v) -> graph.get(u).contains(v);

        List<Integer> path = List.of(0, 1, 3, 4);
        boolean isValid = true;

        for (int i = 0; i < path.size() - 1; i++) {
            if (!validIndex.test(path.get(i)) || !areAdjacent.test(path.get(i), path.get(i+1))) {
                isValid = false;
                break;
            }
        }
        System.out.println("¿El camino " + path + " es válido?: " + isValid);
    }

    // ------------------------------------------------------------
    // Helper methods for Block 2 (given to students)
    // ------------------------------------------------------------

    /**
     * Helper method:
     * - Given a list of nodes [0..n-1] and a Predicate<Integer>,
     *   returns a list of nodes that satisfy the predicate.
     */
    private static List<Integer> filterNodes(List<Integer> nodes, Predicate<Integer> p) {
        return nodes.stream()
                    .filter(p)
                    .collect(Collectors.toList());
    }

    /**
     * Helper method:
     * - Applies a Function<Integer, String> to each node id,
     *   returning a list of strings.
     */
    private static List<String> transformNodes(List<Integer> nodes, Function<Integer, String> f) {
        return nodes.stream()
                    .map(f)
                    .collect(Collectors.toList());
    }

    /**
     * Helper method:
     * - Visits each node and applies a Consumer<Integer> (for logging, etc.).
     */
    private static void visitNodes(List<Integer> nodes, Consumer<Integer> c) {
        nodes.forEach(c);
    }

    /**
     * Helper for checking path validity using a reusable predicate.
     */
    private static boolean validatePath(List<Integer> path, Predicate<Integer> nodeValidator) {
        for (Integer v : path) {
            if (!nodeValidator.test(v)) {
                return false;
            }
        }
        return true;
    }
    
 

}

