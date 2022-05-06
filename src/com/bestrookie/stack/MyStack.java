package com.bestrookie.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/5/6 22:10
 */
public class MyStack<T>  implements Iterable<T>{
    private StackNode head;
    public int N;

    public MyStack(){
        this.head = new StackNode(null,null);
        this.N = 0;
    }
    public Boolean isEmpty(){
        return N == 0;
    }

    public void push(T item){
        StackNode olderFirst = head.next;
        StackNode newNode = new StackNode(item, null);
        head.next = newNode;
        newNode.next = olderFirst;
        N++;
    }

    public int size(){
        return N;
    }
    public T pop(){
        StackNode poolNode = head.next;
        if (poolNode == null){
            return null;
        }
        head.next = poolNode.next;
        N--;
        return poolNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        StackNode n;
        public MyIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    private class StackNode{
        private T item;
        private StackNode next;
        public StackNode(T t, StackNode next){
            this.item = t;
            this.next = next;

        }
    }
}
