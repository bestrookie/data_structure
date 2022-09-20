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
    }
}
