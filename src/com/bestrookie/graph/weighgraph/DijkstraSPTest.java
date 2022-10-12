package com.bestrookie.graph.weighgraph;

import com.bestrookie.stack.MyStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author bestrookie
 * @date 2022/10/10 15:47
 */
public class DijkstraSPTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(DijkstraSPTest.class.getClassLoader().getResourceAsStream("min_route_test.txt")));
        int total = Integer.parseInt(reader.readLine());
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(total);

        int edgeNumbers = Integer.parseInt(reader.readLine());
        for (int i = 0; i < edgeNumbers; i++) {
            String line = reader.readLine();
            String[] strs = line.split(" ");
            int v = Integer.parseInt(strs[0]);
            int w = Integer.parseInt(strs[1]);
            double weight = Double.parseDouble(strs[2]);
            DirectedEdge e = new DirectedEdge(v,w,weight);
            graph.addEdge(e);
        }

        DijkstraSP dijkstraSP = new DijkstraSP(graph, 0);

        MyStack<DirectedEdge> edges = dijkstraSP.pathTo(6);

        for (DirectedEdge edge : edges) {
            System.out.println(edge.form()+"->"+edge.to()+" :: "+ edge.getWeight());
        }

    }
}
