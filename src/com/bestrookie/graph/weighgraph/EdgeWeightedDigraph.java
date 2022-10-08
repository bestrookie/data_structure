package com.bestrookie.graph.weighgraph;

import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/10/8 22:31
 * @description 加权有向图
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private MyQueue<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new MyQueue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new MyQueue<>();
        }

    }

    public int getV(){
        return this.V;
    }

    public int getECount(){
        return this.E;
    }

    public void addEdge(DirectedEdge edge){
        int v = edge.form();
        adj[v].enQueue(edge);
        E++;

    }

    public MyQueue<DirectedEdge> adj(int v){
        return adj[v];
    }

    public MyQueue<DirectedEdge> edges(){
        MyQueue<DirectedEdge> edges = new MyQueue<>();
        for (MyQueue<DirectedEdge> directedEdges : adj) {
            for (DirectedEdge directedEdge : directedEdges) {
                edges.enQueue(directedEdge);
            }
        }
        return edges;
    }

}
