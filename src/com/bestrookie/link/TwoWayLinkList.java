package com.bestrookie.link;

import java.util.Iterator;

/**
 * @author : bestrookie
 * @date : 9:25 2021/5/6
 */
public class TwoWayLinkList<T> implements Iterable<T> {
    /**
     * 头结点
     */
    private Node head;
    /**
     * 尾结点
     */
    private Node last;
    /**
     * 链表的总长度
     */
    private int N;
    private class Node {
        //存储数据
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个结点
        public Node next;
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
    public TwoWayLinkList(){
        //初始化头结点和尾结点
        this.head = new Node(null,null,null);
        this.last = null;
        //链表的总长度为0
        this.N = 0;
    }

    /**
     * 清空链表
     */
    public void clean(){
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    /**
     * 获取链表的长度
     * @return 链表长度
     */
    public int length(){
        return N;
    }

    /**
     * 判断链表是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 获取第一个元素
     * @return 第一个元素
     */
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }

    /**
     * 获取最后一个元素
     * @return 最后一个元素
     */
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }

     /**
     * 插入一个结点
     * @param t 插入的结点
     */
    public void insert(T t){
        if(isEmpty()){
            //如果链表为空
            //创建新结点
            //尾结点为新结点
            last = new Node(t,head,null);
            //头结点指向尾结点
            head.next = last;
        }else {
            //如果链表不为空
            //几率旧的尾结点
            Node oldLast = last;
            //创建新的结点
            Node newNode = new Node(t,oldLast,null);
            //当前尾结点指向新节点
            oldLast.next = newNode;
            //新节点称为尾结点
            last = newNode;
        }
        //链表长度+1
        N++;
    }

    /**
     * 在指定位置插入结点
     * @param i 指定位置
     * @param t 插入的元素
     */
    public void insert(int i,T t){
        //找到i位置的前一个结点
        Node pre = head;
        for (int index = 0; index < i; index++){
            pre = pre.next;
        }
        //找到当前结点
        Node curr = pre.next;
        //创建一个新结点
        Node newNode = new Node(t,pre,curr);
        //i位置的前一个结点的先一个结点指向新节点
        pre.next = newNode;
        //原来i位置结点的前一个结点指向新节点
        curr.pre = newNode;
        //链表长度+1
        N++;
    }

    /**
     * 获取指定位置的元素
     * @param i 指定位置
     * @return 元素内容
     */
    public T get(int i){
        Node n = head.next;
        for (int index = 0; index < i; index++){
            n = n.next;
        }
        return n.item;
    }

    /**
     * 获取指定元素第一次出现的位置
     * @param t 指定元素
     * @return 第一次出现的位置
     */
    public int indexOf(T t){
        Node n = head;
        for (int index = 0; n.next != null; index++){
            n = n.next;
            if (n.item.equals(t)){
                return index;
            }
        }
        return -1;

    }

    /**
     * 删除指定位置的元素
     * @param i 指定位置
     * @return 删除元素
     */
    public T remove(int i){
        //找到i位置的前一个结点
        Node pre = head;
        for (int index = 0;index < i; index++){
            pre = pre.next;
        }
        //找到当前结点
        Node curr = pre.next;
        //找到当前结点的下一个结点
        if (curr.next != null){
            Node nextNode = curr.next;
            //i位置的前一个结点指向i位置的下一个结点
            pre.next = nextNode;
            //i位置下一个结点的上一个结点指向i位置的前一个结点
            nextNode.pre = pre;
        }else {
            pre.next = null;
        }

        //链表长度-1
        N--;
        return curr.item;
    }
    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{
        private Node n;
        public TIterator(){
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
}
