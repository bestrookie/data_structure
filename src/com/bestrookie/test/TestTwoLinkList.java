package com.bestrookie.test;

import com.bestrookie.link.TwoLinkList;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/25 22:52
 */
public class TestTwoLinkList {
    public static void main(String[] args) {
        TwoLinkList<Integer> list = new TwoLinkList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(0,1);
        list.insert(4);
        list.remove(2);
        list.get(0);
        System.out.println(list.length());
        System.out.println(list.isEmpty());
        list.clean();
        System.out.println("+++++++++++++");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
