package com.bestrookie.test;

import com.bestrookie.link.SquuenceList;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/18 23:20
 */
public class TestList {
    public static void main(String[] args) {
        SquuenceList<Integer> list = new SquuenceList<>(10);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(1,3);
        System.out.println(list.isEmpty());
        System.out.println(list.indexOf(1));
        for (int i = 0; i < list.length() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
