package com.example;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Search {
    public Search(Graph G, int s) {
        // find vertices connected to source S use UF

    }

    boolean marked(int v) {
        // is v connected to s?
        return false;
    }

    int count() {
        // how many vertices are connected to s?
        return 0;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[0]);
        Search search = new Search(G, s);
        for (int v = 0; v < G.vertices(); v++) {
            if (search.marked(v)) StdOut.print(v + " ");
            StdOut.println();
            if (search.count() != G.vertices())
            StdOut.print("NOT");
            StdOut.println("connected");
        }
    }
}
