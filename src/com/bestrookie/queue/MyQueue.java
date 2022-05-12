package com.bestrookie.queue;


import java.util.Iterator;

/**
 * @author bestrookie
 * @date 2022/5/12 10:00
 */
public class MyQueue<T> implements Iterable<T>{
    private QueueNode head;
    private QueueNode last;
    private Integer N;
    public MyQueue(){
        this.head = new QueueNode(null,null);
        this.last = null;
        N = 0;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator{
        private QueueNode n;
        public MyIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    private class QueueNode{
        public T item;
        public QueueNode next;
        public QueueNode(T item,QueueNode next){
            this.item = item;
            this.next = next;
        }
    }

    public int size(){
        return N;
    }
    public Boolean isEmpty(){
        return N == 0;
    }
    public void enQueue(T t){
        if (last == null){
            last = new QueueNode(t,null);
            head.next = last;
        }else {
            QueueNode olderLast = this.last;
            last = new QueueNode(t,null);
            olderLast.next = last;
        }
        N++;
    }

    public T deQueue(){
        if (isEmpty()){
            return null;
        }
        QueueNode oderFirst = head.next;
        head.next = oderFirst.next;
        N--;
        if (isEmpty()){
            last = null;
        }
        return oderFirst.item;
    }
}
