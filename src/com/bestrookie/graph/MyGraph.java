package com.bestrookie.graph;

import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/9/1 22:20
 */
public class MyGraph {
    //记录顶点的数量
    private final int V;
    //记录边的数量
    private int E;
    //邻接表
    private MyQueue<Integer>[]adj;
    MyGraph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new MyQueue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new MyQueue<Integer>();
        }
    }

    /**
     * 获取顶点的数量
     * @return 顶点数量
     */
    public int V(){
        return V;
    }

    /**
     * 获取边的数量
     * @return 边的数量
     */
    private int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].enQueue(w);
        adj[w].enQueue(v);
        E++;
    }

    /**
     * 获取某个顶点的边
     * @param v 顶点
     * @return 边
     */
    public MyQueue<Integer> adj(int v){
        return adj[v];
    }
}
