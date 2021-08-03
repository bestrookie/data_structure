package com.bestrookie.test;

import com.bestrookie.link.LinkList;
import com.bestrookie.link.TwoWayLinkList;

/**
 * @author : bestrookie
 * @date : 19:00 2021/5/5
 */
public class TwoWayTestLink {
    public static void main(String[] args) {
        TwoWayLinkList<String> s1 =new TwoWayLinkList<>();
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert("詹姆斯");
        System.out.println("插入新元素前的元素个数："+s1.length());
        for (String s : s1) {
            System.out.println(s);
        }
        s1.insert(1,"库里");
        System.out.println("插入元素后的元素个数:"+s1.length());
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("=================");
        System.out.println("获取索引2的位置的数据:"+s1.get(2));
        String remove = s1.remove(4);
        System.out.println("删除索引3位置的数据并返回:"+remove+"删除后的元素个数"+s1.length());
        System.out.println("=======================");
        System.out.println("获取第一个元素:"+s1.getFirst());
        System.out.println("获取最后一个元素:"+s1.getLast());
        System.out.println("获取元素第一次出现的位置:"+s1.indexOf("科比"));
        s1.clean();
        System.out.println("========清空链表=======");
        System.out.println(s1.length());

    }
}
