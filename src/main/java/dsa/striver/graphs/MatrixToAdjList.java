package dsa.striver.graphs;

import java.util.*;

public class MatrixToAdjList {
    public static void main(String[] args) {
        int[][] connected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int n = connected.length;
        List<List<Integer>> adjList = new ArrayList<>();

        System.out.println("adjList after --->List<List<Integer>> adjList = new ArrayList<>()"+adjList);

        // Initialize empty lists for each node
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("adjList after --->adjList.add(new ArrayList<>());"+adjList);


        // Convert matrix to adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (connected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }

        // Print adjacency list
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + adjList.get(i));
        }
    }
}
