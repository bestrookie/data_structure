package com.bestrookie.graph;

import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/9/4 23:23
 */
public class BreadthFirstSearch {
    private Boolean[] marked;
    private int count;
    private MyQueue<Integer> waitSearch;

    BreadthFirstSearch(MyGraph myGraph,Integer s){
        this.marked = new Boolean[myGraph.V()];
        this.count = 0;
        this.waitSearch = new MyQueue<Integer>();
        for (int i = 0; i < myGraph.V(); i++) {
            marked[i] = false;
        }
        bfs(myGraph,s);
    }

    private void bfs(MyGraph myGraph,Integer v){
        waitSearch.enQueue(v);
        while (!waitSearch.isEmpty()){
            Integer wait = waitSearch.deQueue();

            for (Integer integer : myGraph.adj(wait)) {
                if (!isMarked(integer) && !integer.equals(v)){
                    marked[integer] = true;
                    count++;
                    waitSearch.enQueue(integer);
                }
            }
        }
    }

    public Boolean isMarked(Integer v){
        return marked[v];
    }

    public Integer size(){
        return count;
    }
}

