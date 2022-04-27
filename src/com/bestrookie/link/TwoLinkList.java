package com.bestrookie.link;
import java.util.Iterator;
/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/24 22:35
 */
public class TwoLinkList<T> implements Iterable<T>{
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

    public void insert(T t){
        if (isEmpty()){
            last = new MyNode(t, head, null);
            head.next = last;
        }else {
            MyNode orderLast = last;
            MyNode newNode = new MyNode(t, last, null);
            orderLast.next = newNode;
            last = newNode;
        }
        N++;
    }

    public void insert(T t,int i){
        MyNode pre = this.head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        MyNode curr = pre.next;
        MyNode newNode = new MyNode(t, pre, curr);
        pre.next = newNode;
        curr.pre = newNode;
        N++;
    }

    public T get(int i){
        MyNode pre = head.next;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        return pre.item;
    }

    public int getIndexOf(T t){
        MyNode pre = head;
        for (int i = 0; pre.next != null ; i++) {
            pre = pre.next;
            if (pre.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    public T remove(int i){
        MyNode pre = head;
        for (int j = 0; j < i ; j++) {
            pre = pre.next;
        }
        MyNode curr = pre.next;
        MyNode next = curr.next;
        pre.next = next;
        next.pre = pre;
        N--;
        return curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator{
        MyNode node;
        public MyIterator(){
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
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
