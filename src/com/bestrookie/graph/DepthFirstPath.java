package com.bestrookie.graph;

import com.bestrookie.stack.MyStack;

/**
 * @author bestrookie
 * @description 深度遍历查询无向图路径
 * @date 2022/9/20 11:10
 */
public class DepthFirstPath {
    //索引代表顶点，值代表当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点起到当前顶点路径上的最后一个顶点
    private int [] edgeTo;

    public DepthFirstPath(MyGraph graph, int s){
        this.marked = new boolean[graph.V()];

        this.s = s;

        dfs(graph,s);
    }

    /**
     * 深度优先遍历
     * @param graph 图
     * @param v 顶点
     */
    private void dfs(MyGraph graph,int v){
        marked[v] = true;
        for (Integer adj : graph.adj(v)) {
            if (!marked[adj]){
                edgeTo[adj] = v;
                dfs(graph,adj);
            }
        }


    }

    //判断是否存在路径
    public boolean hasPathTo(int v){
        return marked[v];
    }

    //从起点s到顶点v的路径
    public MyStack<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        MyStack<Integer> path = new MyStack<>();
        for (int i = v; i != s ; i = edgeTo[v]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }

    public void getPath(int v){
        MyStack<Integer> path = pathTo(v);
        for (Integer s : path) {
            System.out.print(s+" ");
        }
    }
}
