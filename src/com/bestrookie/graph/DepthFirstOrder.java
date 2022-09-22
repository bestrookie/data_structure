package com.bestrookie.graph;

import com.bestrookie.stack.MyStack;

/**
 * @author bestrookie
 * @des 有向图生成线性队列
 * @date 2022/9/21 15:10
 */
public class DepthFirstOrder {
    private boolean[] marked;
    //使用栈，存储顶点序列
    private MyStack<Integer> reversePost;

    public DepthFirstOrder(Digraph digraph){
        this.marked = new boolean[digraph.getV()];

        this.reversePost = new MyStack<Integer>();

        for (int i = 0; i < digraph.getV(); i++) {
            if (!marked[i]){
                dfs(digraph,i);
            }
        }

    }

    private void dfs(Digraph digraph,int v){
        marked[v] = true;
        for (Integer w : digraph.adj(v)) {
            if (!marked[w]){
                dfs(digraph,w);
            }
        }
        reversePost.push(v);

    }

    public MyStack<Integer> reversePost(){
        return reversePost;
    }
}
