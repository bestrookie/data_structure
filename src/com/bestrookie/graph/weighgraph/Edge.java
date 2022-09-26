package com.bestrookie.graph.weighgraph;

/**
 * @author bestrookie
 * @des 加权无向图的边
 * @version 1.0
 * @date 2022/9/24 21:30
 */
public class Edge implements Comparable<Edge> {
    private final int v; //顶点1
    private final int w; //顶点2
    private final double weight;//权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    //获取一个顶点
    public int either(){
        return v;
    }
    //获取另一个顶点
    public int getOther(int vertex){
        return vertex == v ? w : v;
    }

    @Override
    public int compareTo(Edge o) {
        int cmp = 0;
        if (this.getWeight() > o.getWeight()){
            cmp = 1;
        }else if (this.getWeight() < o.getWeight()){
            cmp = -1;
        }
        return cmp;
    }
}
