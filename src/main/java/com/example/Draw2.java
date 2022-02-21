package com.example;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.In;

/* Question 2*/
public class Draw2 {
    public static void main(String[] args) {
        In in = new In("tinyGex2.txt");
        Graph graph = new Graph(in);
        Draw draw = new Draw();
        boolean[] marked = new boolean[graph.vertices()];
        double y = 0.95;
        List<Double>[] l = (List<Double>[]) new List[graph.vertices()];
        for (int i = 0; i < graph.vertices(); i++) {
            draw.square(0.1, y, .02);
            draw.text(0.1, y, String.valueOf(i));
            l[i] = new ArrayList<>();
            l[i].add(0.1);
            l[i].add(y);
            y = y - 0.07;
        }
        for (int i = 0; i < graph.vertices(); i++) {
            for (int j : graph.adjacent(i)) {
                double xCoor = l[i].get(0) + 0.1;
                double yCoor = l[i].get(1);
                draw.square(xCoor, yCoor, .02);
                draw.text(xCoor, yCoor, String.valueOf(j));
                draw.line(l[i].get(0), l[i].get(1), xCoor, yCoor);
                l[i] = new ArrayList<>();
                l[i].add(xCoor);
                l[i].add(yCoor);
            }
        }
    }
}
