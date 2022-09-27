package com.bestrookie.graph.weighgraph;

import com.bestrookie.heap.IndexMinPriorityQueue;
import com.bestrookie.queue.MyQueue;

import java.util.Arrays;

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
        this.edgeTo = new Edge[graph.getV()];

        this.distTo = new double[graph.getV()];

        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        this.marked = new boolean[graph.getV()];

        pq = new IndexMinPriorityQueue<Double>(graph.getV());
        //默认让顶点0进入到树中，但是树中只有一个顶点0，因此0顶点默认没有和其他顶点相连，所以让disTo对应位置处的值存储为0.0
        distTo[0] = 0.0;

        pq.insert(0,0.0);

        while (!pq.isEmpty()){
            visit(graph,pq.delMin());
        }

    }

    //将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph graph,int v){
        //把顶点v添加到最小生成树中
        marked[v] = true;
        //更新数据
        for (Edge edge : graph.adj(v)) {
            //获取edge的另外一个顶点
            int w = edge.getOther(v);
            //判断另外一个顶点是否已经在树中，如果是在树中，则不做任何处理，如果不再树中，更新数据
            if (marked[w]){
                continue;
            }

            //判断边edge的权重是否小于从w顶点到树中已经存在的最小边的权重
            if (edge.getWeight() < distTo[w]){
                //更新数据
                edgeTo[w] = edge;

                distTo[w] = edge.getWeight();

                if (pq.contains(w)){
                    pq.changeItem(w,edge.getWeight());
                }else {
                    pq.insert(w,edge.getWeight());
                }
            }

        }


    }

    //获取最小生成树的所有边
    public MyQueue<Edge>edges(){
        MyQueue<Edge> allEdges = new MyQueue<>();
        for (Edge edge : edgeTo) {
            if (edge != null) {
                allEdges.enQueue(edge);
            }
        }
        return allEdges;
    }
}
