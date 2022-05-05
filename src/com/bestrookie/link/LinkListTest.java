package com.bestrookie.link;
import java.util.Iterator;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/19 22:24
 */
public class LinkListTest<T> implements Iterable<T> {
    private Node head;
    private int n;

    public LinkListTest(){
        this.head = new Node(null,null);
        n = 0;
    }

    public void clean(){
        this.head.next = null;
        this.n = 0;
    }

    public Boolean isEmpty(){
        return n == 0;
    }
    public T get(int i){
        Node current = head.next;
        for (int j = 0; j < i ; j++) {
            current = current.next;
        }
        return current.item;
    }

    public void insert(T t){
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node(t,null);
        n++;
    }

    public void insert(T t,int i){
        Node current = head;
        for (int index = 0 ; index < i ; i++){
            current = current.next;
        }
        Node nowNode = current.next;
        current.next= new Node(t, nowNode);
        n++;
    }

    public T remove(int i){
        Node prve = head;
        for (int j = 0; j < i; j++) {
            prve = prve.next;
        }
        Node current = prve.next;
        prve.next = current.next;
        n--;
        return current.item;
    }

    public int indexOf(T t){
        Node prve = head;

        for (int i = 0; i < n; i++) {
            prve = prve.next;
            if (prve.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        private Node n ;
        public MyIterator(){
            this.n  = head;
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

    public void reverse(){
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }
    public Node reverse(Node curr){
        if (curr.next == null){
            head.next = curr;
            return curr;
        }
        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;

    }

    private class Node{
        //存储数据
        T item;
        //下一个节点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
