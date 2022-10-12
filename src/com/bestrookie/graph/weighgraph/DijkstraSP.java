package com.bestrookie.graph.weighgraph;

import com.bestrookie.heap.IndexMinPriorityQueue;
import com.bestrookie.stack.MyStack;

import java.util.Arrays;

/**
 * @author bestrookie
 * @date 2022/10/10 11:50
 */
public class DijkstraSP {
    //索引表示顶点，值表示从顶点s到当前顶点的最短路径上的最后一跳边
    private  DirectedEdge[] edgeTo;

    //索引代表顶点，值从顶点s到当前顶点的最短路径的总权值
    private double[] disTo;

    //存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;


    public DijkstraSP(EdgeWeightedDigraph digraph,int s){
        this.edgeTo = new DirectedEdge[digraph.getV()];
        this.disTo = new double[digraph.getV()];

        Arrays.fill(disTo, Double.POSITIVE_INFINITY);

        this.pq = new IndexMinPriorityQueue<>(digraph.getV());

        disTo[s] = 0.0;
        pq.insert(s,0.0);

        while (!pq.isEmpty()){
            relax(digraph, pq.delMin());
        }

    }

    //松弛图中的顶点
    private void relax(EdgeWeightedDigraph digraph,int v){
        for (DirectedEdge directedEdge : digraph.adj(v)) {
            int w = directedEdge.to();

            if (distTo(v) + directedEdge.getWeight() < distTo(w)){
                disTo[w] = disTo[v] + directedEdge.getWeight();
                edgeTo[w] = directedEdge;

                if (pq.contains(w)){
                    pq.changeItem(w,disTo[w]);
                }else {
                    pq.insert(w,disTo[w]);
                }
            }
        }

    }

    //获取从顶点s到顶点v的最短路径总权重
    public double distTo(int v){
        return disTo[v];
    }

    //判断从顶点s到顶点v是否可达
    public boolean hasPathTo(int v){
        return disTo[v] < Double.POSITIVE_INFINITY;
    }

    public MyStack<DirectedEdge> pathTo(int v){
        MyStack<DirectedEdge> path = new MyStack<>();
        if (!hasPathTo(v)){
            return null;
        }

        while (true){
            DirectedEdge e = edgeTo[v];
            if (e == null){
                break;
            }
            path.push(e);
            v = e.form();

        }
        return path;
    }
}
