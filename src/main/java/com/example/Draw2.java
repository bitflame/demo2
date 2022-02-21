package com.example;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.In;

/* Question 2*/
public class Draw2 {
    public static void main(String[] args) {
        In in = new In("tinyGex2.txt");
        int v = in.readInt();
        int e = in.readInt();
        Draw draw = new Draw();
        List<Double>[] l = (List<Double>[]) new List[v];
        while (!in.isEmpty()) {
            int x = in.readInt();
            int y = in.readInt();
            double xCoor;
            double yCoor;
            if (l[x] == null) {
                xCoor = 0.1;
                yCoor = (double) (12.0 - x) / 15;
                draw.square(xCoor, yCoor, .02);
                draw.text(xCoor, yCoor, String.valueOf(x));
                l[x] = new ArrayList<>();
                l[x].add(xCoor);
                l[x].add(yCoor);
                draw.line(xCoor, yCoor, (xCoor + 0.1), yCoor);
                xCoor = xCoor + 0.1;
                draw.square(xCoor, yCoor, .02);
                draw.text(xCoor, yCoor, String.valueOf(y));
                l[x] = new ArrayList<>();
                l[x].add(xCoor);
                l[x].add(yCoor);
            } else {
                xCoor = l[x].get(0);
                yCoor = l[x].get(1);
                draw.square(xCoor, yCoor, .02);
                // draw.text(xCoor, yCoor, String.valueOf(x));
                draw.line(xCoor, yCoor, (xCoor + 0.1), yCoor);
                xCoor = xCoor + 0.1;
                draw.square(xCoor, yCoor, .02);
                draw.text(xCoor, yCoor, String.valueOf(y));
                l[x] = new ArrayList<>();
                l[x].add(xCoor);
                l[x].add(yCoor);
            }

        }
    }
}
