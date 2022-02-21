package com.example;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * Hello world!
 *
 */
public class App {
    boolean [] marked;
    private  void DepthFirstSearch(Graph graph) {
        marked = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            if (!marked[i]) dfs(graph,i);
        }
    }
private void dfs(Graph graph, int i){
    marked[i]=true;
    for (int j :graph.adj(i)) {
        if (!marked[j]) dfs(graph,j);
    }
}
    public static void main(String[] args) {
        System.out.println("Hello World!");
        StdOut.println("Testing");
        Graph graph = new Graph(new In("digraph1.txt"));
        App app= new App();
        app.DepthFirstSearch(graph);

    }
}
