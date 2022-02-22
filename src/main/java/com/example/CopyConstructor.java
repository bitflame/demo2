package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CopyConstructor {
    List<Integer>[] adj;
    int V;
    int E;

    // Question 4.1.3
    public CopyConstructor(Graph G) {
        this.V = G.V();
        this.E = G.E();

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

    // Question 4.1.4
    public boolean hasEdge(int v, int w) {
        for (int i : this.adj[v]) {
            if (i == w)
                return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices " + E + " edges " + "\n");
        for (int i = 0; i < V; i++) {
            s.append(i + ": ");
            for (int w : adj[i]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        // Graph graph = new Graph(new In("tinyDG.txt"));
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);

        // build a new Graph
        CopyConstructor constructor = new CopyConstructor(graph);
        StdOut.println("Expected:\n" +
                "0: 3 2 1\n" +
                "1: 4 2 0\n" +
                "2: 3 1 0\n" +
                "3: 2 0\n" +
                "4: 1\n");
        constructor.adj[0].add(0, 4);
        StdOut.println(graph);
        StdOut.println(constructor);
        StdOut.println("expect true: "+constructor.hasEdge(0, 3));
        StdOut.println("expect false: "+constructor.hasEdge(1, 3));
    }
}
