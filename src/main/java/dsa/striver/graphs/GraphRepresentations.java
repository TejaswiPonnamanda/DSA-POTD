package dsa.striver.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GraphRepresentations {

    private static final Logger logger = Logger.getLogger(GraphRepresentations.class.getName());

    // Pair class for weighted edges
    static class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Unweighted Graph Representation
    static class UnweightedGraph {
        private final int numVertices;
        private final List<List<Integer>> adjacencyList;

        public UnweightedGraph(int numVertices) {
            this.numVertices = numVertices;
            this.adjacencyList = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination, boolean directed) {
            adjacencyList.get(source).add(destination);
            if (!directed) {
                adjacencyList.get(destination).add(source);
            }
            logger.info(String.format("Added %s edge: %d -> %d",
                    directed ? "directed" : "undirected", source, destination));
        }

        public void displayGraph() {
            logger.info("Unweighted Graph Representation:");
            for (int i = 0; i < numVertices; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(" -> ");
                for (int neighbor : adjacencyList.get(i)) {
                    sb.append(neighbor).append(" ");
                }
                logger.info(sb.toString());
            }
        }
    }

    // Weighted Graph Representation
    static class WeightedGraph {
        private final int numVertices;
        private final List<List<Pair>> adjacencyList;

        public WeightedGraph(int numVertices) {
            this.numVertices = numVertices;
            this.adjacencyList = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination, int weight, boolean directed) {
            adjacencyList.get(source).add(new Pair(destination, weight));
            if (!directed) {
                adjacencyList.get(destination).add(new Pair(source, weight));
            }
            logger.info(String.format("Added %s edge: %d -> %d with weight %d",
                    directed ? "directed" : "undirected", source, destination, weight));
        }

        public void displayGraph() {
            logger.info("Weighted Graph Representation:");
            for (int i = 0; i < numVertices; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(" -> ");
                for (Pair p : adjacencyList.get(i)) {
                    sb.append(String.format("(%d, weight=%d) ", p.node, p.weight));
                }
                logger.info(sb.toString());
            }
        }
    }

    // Main method for testing both types
    public static void main(String[] args) {
        logger.setLevel(Level.INFO);

        logger.info("Creating Unweighted Directed Graph...");
        UnweightedGraph unweightedGraph = new UnweightedGraph(5);
        unweightedGraph.addEdge(0, 1, true);
        unweightedGraph.addEdge(0, 2, true);
        unweightedGraph.addEdge(1, 3, true);
        unweightedGraph.displayGraph();

        logger.info("\nCreating Weighted Undirected Graph...");
        WeightedGraph weightedGraph = new WeightedGraph(5);
        weightedGraph.addEdge(0, 1, 4, false);  // time = 4
        weightedGraph.addEdge(0, 2, 1, false);  // time = 1
        weightedGraph.addEdge(1, 3, 5, false);  // time = 5
        weightedGraph.displayGraph();
    }
}
