package com.bestrookie.graph.weighgraph;

import com.bestrookie.heap.IndexMinPriorityQueue;
import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @date 2022/9/26 11:27
 */
public class PrimMST {
    //索引代表顶点，值代表当前顶点和最小生成树之间的最短边
    private Edge[] edgeTo;
    //索引代表顶点，值代表顶点和最小生成树之间最短边的权重
    private double[] distTo;
    //索引代表顶点，如果当前顶点已经在树中，则为true，否则为false
    private boolean[] marked;
    //存放树中顶点雨非树中顶点之间的有效横切面
    private IndexMinPriorityQueue<Double>pq;

    //根据加权无向图，创建最小生成树计算对象
    public PrimMST(EdgeWeightedGraph graph){

    }

    //将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph graph,int v){

    }

    //获取最小生成树的所有边
    private MyQueue<Edge>edges(){
        return null;
    }
}
