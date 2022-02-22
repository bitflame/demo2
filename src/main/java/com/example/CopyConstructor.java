package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class CopyConstructor {
    List<Integer>[] adj;

    public CopyConstructor(Graph G) {
        adj = new ArrayList[G.V()];
        // for each vertex in v initialize a new bag
        for (int v = 0; v < G.V(); v++) {
            adj[v] = new ArrayList<Integer>();
        }

        for (int i = 0; i < G.V(); i++) {
            Stack<Integer> reverse = new Stack<>();
            for (int v : G.adj(i)) {

                reverse.push(v);
            }
            for (int w : reverse) {
                if (!adj[i].contains(w))
                    adj[i].add(w);
            }
        }
    }

    public Iterable<Integer> adj(int i) {
        return adj[i];
    }

    public static void main(String[] args) {
        Graph graph = new Graph(new In("tinyDG.txt"));
        // build a new Graph
        CopyConstructor constructor = new CopyConstructor(graph);
        int pre = -1;
        for (int i = 0; i < graph.V(); i++) {
            System.out.println("Initial Graph Nodes         Copy of Graph Nodes ");
            System.out.printf("%d - ", i);
            for (int j : graph.adj(i)) {
                if (j != pre)
                    System.out.printf("%d ", j);
                pre = j;
            }
            System.out.printf("              ");
            for (int k : constructor.adj(i)) {
                System.out.printf("%d ", k);
            }
            System.out.println();
        }
    }
}
