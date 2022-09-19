package com.bestrookie.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/9/19 22:28
 */
public class Traffic_Project_Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test.class.getClassLoader().getResourceAsStream("traffic_project.txt")));

        //读取第一行数据20
        int totalNumber = Integer.parseInt(br.readLine());
        MyGraph G = new MyGraph(totalNumber);

        int roadNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < roadNumber; i++) {
            String road = br.readLine();
            String[] str = road.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            G.addEdge(v, w);
        }
        DepthFistSearch search = new DepthFistSearch(G,9);
        System.out.println(search.isMarked(8));
        System.out.println(search.isMarked(10));
    }

}
