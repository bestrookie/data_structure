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
        list.remove(1);
        System.out.println(list.get(0));
        System.out.println(list.indexOf(3));
        System.out.println("============");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
