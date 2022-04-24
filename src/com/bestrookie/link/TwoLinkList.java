package com.bestrookie.link;

import org.w3c.dom.Node;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/24 22:35
 */
public class TwoLinkList<T> {
    private MyNode head;
    private MyNode last;
    private int N;
    private class MyNode{
        public T item;
        private MyNode pre;
        private MyNode next;
        public MyNode(T item,MyNode pre,MyNode next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }


    }
}
