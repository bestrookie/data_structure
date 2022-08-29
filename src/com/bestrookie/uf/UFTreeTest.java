package com.bestrookie.uf;

import java.util.Scanner;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/8/29 22:18
 */
public class UFTreeTest {
    public static void main(String[] args) {
        UF_Tree uf = new UF_Tree(5);
        System.out.println("默认情况下，并查集中有"+uf.count()+"个分组");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入第一个要合并的元素：");
            int p = sc.nextInt();
            System.out.println("请输入第二个要合并的元素：");
            int q = sc.nextInt();
            if (uf.connected(p,q)){
                System.out.println("p+元素"+q+"元素已经在一个组中");
                continue;
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.count()+"个分组");
        }
    }
}
