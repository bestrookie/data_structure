package com.bestrookie.test;

import com.bestrookie.link.LinkList;

/**
 * @author : bestrookie
 * @date : 19:00 2021/5/5
 */
public class TestLink2 {
    public static void main(String[] args) {
        LinkList<String> s1 =new LinkList<>();
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert("詹姆斯");
        System.out.println(s1.length());
        s1.insert(1,"库里");
        System.out.println(s1.length());
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("=======================");
        s1.reverse();
        for (String s : s1) {
            System.out.println(s);
        }

    }
}
