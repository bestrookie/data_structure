package com.bestrookie.graph.weighgraph;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/10/8 22:19
 * @description 加权有向边
 *
 */
public class DirectedEdge {
    private final int v;
    private final  int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;

    }

    public double getWeight(){
        return weight;
    }

    public int form(){
        return v;
    }

    public int to(){
        return w;
    }
}
