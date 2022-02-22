package com.example;

import edu.princeton.cs.algs4.In;

public class Exercise5 extends Graph {

    public Exercise5(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int v, int w) {
        if (v == w || hasEdge(v, w) == true)
            return;
        super.addEdge(v, w);
    }

}
