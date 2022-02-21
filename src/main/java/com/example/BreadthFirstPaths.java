package com.example;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths {
    private boolean[] visited;
    private int[] edgeTo;
    private final int source;
    private int[] distTo;

    public BreadthFirstPaths(GraphInterface graph, int source) {
        visited = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
        this.source = source;
        distTo = new int[graph.vertices()];
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (vertex == source) {
                continue;
            }
            distTo[vertex] = Integer.MAX_VALUE;
        }
        bfs(graph, source);
    }

    public void bfs(GraphInterface graph, int sourceVertex) {
        Queue<Integer> queue = new Queue<>();
        visited[sourceVertex] = true;
        queue.enqueue(sourceVertex);
        while(!queue.isEmpty()){
            int currentVertex=queue.dequeue();
            for (int neighbor: graph.adjacent(currentVertex)){
                if (!visited[neighbor]){
                    visited[neighbor]=true;
                    edgeTo[neighbor]=currentVertex;
                    distTo[neighbor]=distTo[currentVertex]+1;
                    queue.enqueue(neighbor);
                }
            }         
        }
    }
    public int distTo(int vertex){
        return distTo[vertex];
    }
    public int edgeTo(int vertex){
        return edgeTo[vertex];
    }
    public boolean hasPathTo(int vertex){
        return visited[vertex];
    }
    public Iterable<Integer> pathTo(int vertex){
        if (!hasPathTo(vertex)){
            return null;
        }
        Stack<Integer> path  = new Stack<>  ();
        for (int currentVertex = vertex; currentVertex != source; currentVertex=edgeTo[currentVertex]) {
            path.push(currentVertex);
        }
        path.push(source);
        return path;
    }
}
