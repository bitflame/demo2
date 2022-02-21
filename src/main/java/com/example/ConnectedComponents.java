package com.example;

public interface ConnectedComponents {
    boolean connected(int vertex1, int vertex2);
    int id(int vertex);
    int count();
}
