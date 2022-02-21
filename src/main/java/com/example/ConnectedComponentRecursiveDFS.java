package com.example;

public class ConnectedComponentRecursiveDFS implements ConnectedComponents {
    private boolean[] visited;
    private int[] id;
    private int count;

    public ConnectedComponentRecursiveDFS(GraphInterface graph) {
        visited = new boolean[graph.vertices()];
        id = new int[graph.vertices()];
        for (int source = 0; source < graph.vertices(); source++) {
            if (!visited[source]) {
                dfs(graph, source);
                count++;
            }
        }
    }

    private void dfs(GraphInterface graph, int vertex) {
        visited[vertex] = true;
        id[vertex] = count;
        for (int neighbor : graph.adjacent(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor);
            }
        }
    }

    @Override
    public boolean connected(int vertex1, int vertex2) {
        // TODO Auto-generated method stub
        return id[vertex1] == id[vertex2];
    }

    @Override
    public int id(int vertex) {
        // TODO Auto-generated method stub
        return id[vertex];
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        return count;
    }
}