package com.bestrookie.graph;

/**
 * @author bestrookie
 * @des 检测有向图是否有环
 * @date 2022/9/21 10:54
 */
public class DirectedCycle {
    private boolean [] marked;

    private boolean hasCycle;

    private boolean[] onStack;

    public DirectedCycle(Digraph digraph){

        this.marked = new boolean[digraph.getV()];
        this.hasCycle = false;
        this.onStack = new boolean[digraph.getV()];

        for (int i = 0; i < digraph.getV(); i++) {
            if (hasCycle){
                break;
            }
            if (!marked[i]){
                dfs(digraph,i);
            }
        }


    }
    //基于深度优先遍历，检测图中是否有环
    private void dfs(Digraph digraph ,int v){
        marked[v] = true;
        onStack[v] = true;

        for (Integer w : digraph.adj(v)) {
            if (!marked[w]){
                dfs(digraph,w);
            }
            if (onStack[w]){
                hasCycle = true;
                return;
            }
        }
        onStack[v] = false;

    }

    public boolean hasCycle(){
        return hasCycle;
    }
}
