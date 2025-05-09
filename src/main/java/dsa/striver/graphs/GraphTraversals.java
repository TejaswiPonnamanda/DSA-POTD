package dsa.striver.graphs;

import java.util.*;

public class GraphTraversals {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int n = matrix.length;
        List<List<Integer>> adjList = buildAdjList(matrix);

        System.out.println("BFS from Single Source (0):");
        bfsSingleSource(0, adjList, n);
        System.out.println("\nTime Complexity: O(V + E)");

        System.out.println("\n\nBFS from Multiple Sources:");
        bfsMultiSource(adjList, n);
        System.out.println("Time Complexity: O(V + E)");

        System.out.println("\nDFS from Single Source (0):");
        boolean[] visitedDfs1 = new boolean[n];
        dfsSingleSource(0, adjList, visitedDfs1);
        System.out.println("\nTime Complexity: O(V + E)");

        System.out.println("\n\nDFS from Multiple Sources:");
        dfsMultiSource(adjList, n);
        System.out.println("Time Complexity: O(V + E)");
    }

    // 🔧 Utility to convert matrix to adjacency list
    public static List<List<Integer>> buildAdjList(int[][] matrix) {
        int n = matrix.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 1 && i != j)
                    adjList.get(i).add(j);
        System.out.println(adjList);
        return adjList;
    }

    // ✅ 1. BFS from Single Source
    public static void bfsSingleSource(int start, List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }

    // ✅ 2. BFS from Multiple Sources (count connected components)
    public static void bfsMultiSource(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                System.out.print("Component " + components + ": ");
                Queue<Integer> q = new LinkedList<>();
                visited[i] = true;
                q.offer(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    System.out.print(node + " ");
                    for (int nei : adj.get(node)) {
                        if (!visited[nei]) {
                            visited[nei] = true;
                            q.offer(nei);
                        }
                    }
                }
                System.out.println();
            }
        }

        System.out.println("Total Components: " + components);
    }

    // ✅ 3. DFS from Single Source
    public static void dfsSingleSource(int start, List<List<Integer>> adj, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int nei : adj.get(start)) {
            if (!visited[nei]) {
                dfsSingleSource(nei, adj, visited);
            }
        }
    }

    // ✅ 4. DFS from Multiple Sources (count connected components)
    public static void dfsMultiSource(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                System.out.print("Component " + components + ": ");
                dfsSingleSource(i, adj, visited);
                System.out.println();
            }
        }

        System.out.println("Total Components: " + components);
    }
}
