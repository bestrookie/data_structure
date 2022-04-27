package com.bestrookie.test;

import com.bestrookie.link.LinkListTest;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/21 22:24
 */
public class TestLinList {
    public static void main(String[] args) {
        LinkListTest<Integer> list = new LinkListTest<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(0,0);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("============");
        list.reverse();
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
