package com.bestrookie.link;


import org.w3c.dom.Node;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/28 21:04
 */
public class JosephRing {
    public static void main(String[] args) {
        //构建双向列表
        NodeMe<Integer> first = null;
        NodeMe<Integer> pre = null;
        int count = 0;

        for (int i = 1; i <= 41; i++) {
            if (i == 1){
                first = new NodeMe<>(i,null);
                pre = first;
                continue;
            }
            NodeMe<Integer> newNode = new NodeMe<>(i, null);
            pre.next = newNode;
            pre = newNode;
            if (i == 41){
                pre.next = first;
            }
        }

        //约瑟夫环拖出来枪毙

        NodeMe<Integer> n = first;
        NodeMe<Integer> curr = null;
         while (n != n.next){
             count++;
              if (count == 3){
                  curr.next = n.next;
                  count = 0;
                  System.out.print(n.item+",");
              }else {
                  curr = n;
              }
             n = n.next;
         }
        System.out.print(n.item);

    }
}
