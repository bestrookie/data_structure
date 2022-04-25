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

    public TwoLinkList(){
        this.head = new MyNode(null,null,null);
        this.last = new MyNode(null,null,null);
        this.N = 0;
    }
    public void clean(){
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }
    public Boolean isEmpty(){
        return N == 0;
    }
    public Integer length(){
        return N;
    }
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }











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
