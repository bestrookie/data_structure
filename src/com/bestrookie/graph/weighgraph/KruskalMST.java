package com.bestrookie.graph.weighgraph;

import com.bestrookie.heap.MinPriorityQueue;
import com.bestrookie.queue.MyQueue;
import com.bestrookie.uf.UF_Tree_Weighted;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/10/7 20:52
 * @description 最小生成树kruskal算法实现
 */
public class KruskalMST {

    //保存最小生成树的所有边
    private MyQueue<Edge> mst;
    //所以代表顶点，使用uf.connect判断顶点v和顶点w是否在同一颗树中，使用uf.union（v,w）把顶点v所在的树和顶点w所在的树合并
    private UF_Tree_Weighted uf;
    //存储途中所有的边，使用最小优先队列，对边按照权重进行排序
    private MinPriorityQueue<Edge> pq;

    //根据加权无向图，创建最小生成树计算对象
    public KruskalMST(EdgeWeightedGraph graph){
        this.mst = new MyQueue<Edge>();
        this.uf = new UF_Tree_Weighted(graph.getV());
        this.pq = new MinPriorityQueue<>(graph.getE());

        for (Edge edge : graph.getEdge()) {
            pq.insert(edge);
        }

        while (!pq.isEmpty() && mst.size() < graph.getV()-1){
            Edge edge = pq.delMin();

            int v = edge.either();
            int w = edge.getOther(v);

            if (uf.connected(v,w)){
                continue;
            }
            uf.union(v,w);
            mst.enQueue(edge);
        }

    }

    public MyQueue<Edge> edges(){
        return mst;
    }

}
