package com.bestrookie.graph;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/9/4 22:51
 */
public class DepthFirstSearchTest {
    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph(13);
        myGraph.addEdge(0,5);
        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,6);
        myGraph.addEdge(5,3);
        myGraph.addEdge(5,4);
        myGraph.addEdge(3,4);
        myGraph.addEdge(4,6);

        BreadthFirstSearch depthFistSearch = new BreadthFirstSearch(myGraph, 0);

        System.out.println("顶点："+0+"相同的顶点有："+depthFistSearch.size());

        System.out.println(depthFistSearch.isMarked(4));

        System.out.println(depthFistSearch.isMarked(11));
    }
}
