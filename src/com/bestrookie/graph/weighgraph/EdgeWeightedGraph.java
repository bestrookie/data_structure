package com.bestrookie.graph.weighgraph;

import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @des 加权无向图
 * @version 1.0
 * @date 2022/9/24 22:08
 */
public class EdgeWeightedGraph {
    private final int V; //顶点数量
    private int E; //边的数量;
    private MyQueue<Edge>[] adj;//邻接表


    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new MyQueue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new MyQueue<Edge>();
        }

    }
    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    public void addEdge(Edge edge){
        int v = edge.either();
        int w = edge.getOther(v);

        adj[v].enQueue(edge);
        adj[w].enQueue(edge);

    }

    public MyQueue<Edge> adj(int v){
        return adj[v];
    }

    public MyQueue<Edge> getEdge(){
        MyQueue<Edge> allEdge = new MyQueue<>();

        for (int i = 0; i <V; i++) {
            for (Edge e : adj[i]) {
                if (e.getOther(i) < i){
                    allEdge.enQueue(e);
                }
            }

        }
        return allEdge;
    }
}
