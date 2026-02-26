package mapsReuseCurry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



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
        // TODO: implement this method according to the exercise description.
    }

    /**
     * Exercise 2:
     * - For a given node "start", compute all neighbors-of-neighbors:
     *     neighbors(neighbors(start))
     *   using Stream's map / flatMap.
     */
    private static void exercise2_NeighborsOfNeighbors(List<List<Integer>> graph, int start) {
        // TODO: implement this method according to the exercise description.
    }

    /**
     * Exercise 3:
     * - For a given node "start", compute the set of second-level neighbors
     *   (neighbors of neighbors) without duplicates and without including
     *   "start" itself.
     */
    private static void exercise3_SecondLevelNeighborsUnique(List<List<Integer>> graph, int start) {
        // TODO: implement this method according to the exercise description.
    }

    /**
     * Exercise 4:
     * - Count the total number of edges in the undirected graph using reduce.
     *   (Recall that in an undirected graph represented this way, each edge
     *    appears twice in the adjacency list.)
     */
    private static void exercise4_CountEdges(List<List<Integer>> graph) {
        // TODO: implement this method according to the exercise description.
    }

    /**
     * Exercise 5:
     * - Find the node(s) with maximum degree using Streams.
     */
    private static void exercise5_MaxDegreeNodes(List<List<Integer>> graph) {
        // TODO: implement this method according to the exercise description.
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
        // TODO: implement this method according to the exercise description.
    }

    /**
     * Exercise 2:
     * - Combine predicates and apply them to filter nodes
     *   (e.g. even degree AND degree >= 2, etc.).
     */
    public static void exercise2_GraphPredicates(List<List<Integer>> graph) {
        // TODO: implement this method according to the exercise description.
    }

    /**
     * Exercise 3:
     * - Use reusable Function<Integer, String> to create labels
     *   for nodes, and a Function<List<Integer>, String> to pretty-print paths.
     */
    public static void exercise3_FunctionReusable(List<List<Integer>> graph) {
        // TODO: implement this method according to the exercise description.
    }

    /**
     * Exercise 4:
     * - Define reusable Consumer<String> for logging,
     *   and compose them with andThen to see order effects.
     */
    public static void exercise4_ConsumerReusable(List<List<Integer>> graph) {
        // TODO: implement this method according to the exercise description.
    }

    /**
     * Exercise 5:
     * - Use a reusable path validator (Predicate<Integer>) to check if
     *   a sequence of nodes is a valid path in the graph.
     */
    public static void exercise5_PathValidationReusable(List<List<Integer>> graph) {
        // TODO: implement this method according to the exercise description.
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

