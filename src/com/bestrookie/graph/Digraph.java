package com.bestrookie.graph;

import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @des 有向图
 * @version 1.0
 * @date 2022/9/20 22:14
 */
public class Digraph {
    //顶点的数量
    private final int V;
    //边的数量
    private int E;
    //邻接表
    private MyQueue<Integer> [] adj;

    public Digraph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new MyQueue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new MyQueue<Integer>();
        }
    }

    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].enQueue(w);
        E++;
    }

    public MyQueue<Integer> adj(int v){
        return adj[v];
    }

    private Digraph reverse(){
        Digraph r = new Digraph(V);
        for (int i = 0; i < V; i++) {
            for (Integer w : adj[i]) {
                r.addEdge(w,i);
            }
        }
        return r;
    }

}
