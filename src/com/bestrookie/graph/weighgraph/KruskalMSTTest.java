package com.bestrookie.graph.weighgraph;

import com.bestrookie.queue.MyQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/10/7 21:36
 */
public class KruskalMSTTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(PrimMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));
        int total = Integer.parseInt(reader.readLine());
        EdgeWeightedGraph graph = new EdgeWeightedGraph(total);

        int edgeNumbers = Integer.parseInt(reader.readLine());

        for (int i = 0; i < edgeNumbers; i++) {
            String line = reader.readLine();
            String[] s = line.split(" ");
            int v = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
            double weight = Double.parseDouble(s[2]);
            Edge edge = new Edge(v, w, weight);
            graph.addEdge(edge);
        }
        KruskalMST primMST = new KruskalMST(graph);
        MyQueue<Edge> edges = primMST.edges();
        for (Edge edge : edges) {
            int v = edge.either();
            int w = edge.getOther(v);
            double weight = edge.getWeight();
            System.out.println(v+"->"+w +"::"+weight);
        }

    }
}
