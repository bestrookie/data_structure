package com.bestrookie.graph;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/9/4 22:41
 */
public class DepthFistSearch {
    private final Boolean [] marked;
    public  int count;

    DepthFistSearch(MyGraph graph, int  vertices){
        this.marked = new Boolean[graph.V()];
        count = 0;
        for (int i = 0; i < graph.V(); i++) {
            this.marked[i] = false;
        }
        dfs(graph,vertices);
    }

    private void dfs(MyGraph graph, int v){
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if (!isMarked(w)){
                dfs(graph,w);
            }
        }
        count++;
    }

    public Boolean isMarked(int w){
        return marked[w];
    }

    public  Integer count(){
        return count;
    }
}
