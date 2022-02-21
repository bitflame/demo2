package com.example;
/* Copy of https://github.com/reneargento */ 
public class Cycle {
    private boolean[] visited;
    private boolean hasCycle;

    public Cycle(Graph graph) {
        visited = new boolean[graph.vertices()];
        for (int source = 0; source < graph.vertices(); source++) {
            if (!visited[source]) {
                dfs(graph, source, source);
            }
        }
    }

    private void dfs(Graph graph, int vertex, int origin) {
        visited[vertex] = true;
        for (int neighbor : graph.adjacent(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, vertex);
            } else if (neighbor != origin) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
