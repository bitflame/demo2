package com.example;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("unchecked")
public class DrawGraph {

    public static void main(String[] args) {
        Bag<Double>[] adj = (Bag<Double>[]) new Bag[100];
        List<Double>[] l = (List<Double>[]) new List[100];
        In in = new In("tinyDG.txt");
        Graph graph = new Graph(in);
        Draw draw = new Draw();
        double radius = 0.02;
        int counter = 0;
        for (int index = 0; index < 13; index++) {
            l[index] = new ArrayList<>();
            l[index].add(Math.PI / 360 * counter);
            l[index].add(StdRandom.uniform(0.0, 1.0));
            counter += 8;
        }
        boolean[] marked = new boolean[13];
        for (int i = 0; i < graph.vertices(); i++) {
            draw.circle(l[i].get(0), l[i].get(1), radius);
            marked[i] = true;
            for (int v : graph.adjacent(i)) {
                if (!marked[v]) {
                    marked[v] = true;
                    draw.circle(l[v].get(0), l[v].get(1), radius);
                }
                draw.line(l[i].get(0), l[i].get(1), l[v].get(0), l[v].get(1));
            }
        }
    }
}
