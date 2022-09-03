package com.bestrookie.uf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/9/1 21:08
 */
public class Traffic_Project_Test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        
        int totalCity = Integer.parseInt(br.readLine());
        UF_Tree_Weighted uf = new UF_Tree_Weighted(totalCity);
        int roadNumber = Integer.parseInt(br.readLine());
        for (int i = 0; i < roadNumber; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            uf.union(p, q);
        }
        System.out.println(uf.count() -1);

    }
}
