package com.example;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class Search {
    int source;
    UF uf;

    public Search(Graph G, int s) {
        source = s;
        uf = new UF(G.vertices());
        // find vertices connected to source S use UF
        for (int i = 0; i < G.vertices(); i++) {
            for (int v : G.adjacent(i)) {
                uf.union(i, v);
            }
        }
    }

    boolean marked(int v) {
        // is v connected to s?
        return uf.find(v) == uf.find(source);
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
            if (search.marked(v))
                StdOut.print(v + " ");
            StdOut.println();
            if (search.count() != G.vertices())
                StdOut.print("NOT");
            StdOut.println("connected");
        }
    }
}
