package com.bestrookie.test;

import com.bestrookie.link.LinkList;

/**
 * @author : bestrookie
 * @date : 19:00 2021/5/5
 */
public class TestLink {
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
        System.out.println("=================");
        System.out.println("获取索引2的位置的数据"+s1.get(2));
        String remove = s1.remove(3);
        System.out.println("删除索引3位置的数据并返回"+remove);
        System.out.println("获取元素第一次出现的位置");
        System.out.println(s1.indexOf("科比"));
        s1.clean();
        System.out.println(s1.length());

    }
}
