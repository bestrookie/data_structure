package com.bestrookie.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author bestrookie
 * @date 2022/9/20 17:52
 */
public class Road_Find_Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(Road_Find_Test.class.getClassLoader().getResourceAsStream("road_find.txt")));

        Integer total = Integer.parseInt(reader.readLine());
        MyGraph graph = new MyGraph(total);
        Integer road = Integer.parseInt(reader.readLine());
        for (int i = 0; i < road ; i++) {
            String edge = reader.readLine();
            String[] str = edge.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            graph.addEdge(v,w);
        }

        DepthFirstPath path = new DepthFirstPath(graph,0);
        path.getPath(4);
    }
}
