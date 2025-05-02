package dsa.faang.binarytree.pathsum;

import java.util.*;
import java.util.stream.Collectors;

public class PrintAllKsumPaths {

    protected static class Node {
        int data;
        Node left, right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    private static void printAllPaths(Node root, int k, Stack<Integer> st, int csum) {
        if (root == null) return;

        st.push(root.data);
        csum += root.data;

        if (csum == k) {
            //System.out.println(st);
            System.out.println(st.stream().map(String::valueOf).collect(Collectors.joining(" -> ")));

        }

        printAllPaths(root.left, k, st, csum);
        printAllPaths(root.right, k, st, csum);

        st.pop();  // backtrack
    }

    public static void main(String[] args) {
        int k = 18;

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);

        Stack<Integer> st = new Stack<>();
        printAllPaths(root, k, st, 0);
    }
}

