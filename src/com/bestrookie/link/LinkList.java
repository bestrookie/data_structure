package com.bestrookie.link;

import java.util.Iterator;

/**
 * @author : bestrookie
 * @date : 10:49 2021/5/4
 */
public class LinkList<T> implements Iterable<T>{
    /**
     * 定义头结点
     */
    private Node head;
    /**
     * 链表总长度
     */
    private int N;
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

    /**
     * 初始化链表
     */
    public LinkList(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    /**
     * 清空链表
     */
    public void clean(){
        head.next = null;
        this.N = 0;
    }

    /**
     * 判断链表是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 获取链表长度
     * @return
     */
    public int length(){
        return N;
    }

    /**
     * 获取指定的结点
     * @param i 指定结点的位置
     * @return 指定结点信息
     */
    public T get(int i){
        //通过循环，从头结点开始遍历往后找，依次找i次
        Node n = head.next;
        for (int index = 0; index < i; index++){
            n = n.next;
        }
        return n.item;
    }

    /**
     * 插入一个新的结点
     * @param t 新节点数据
     */
    public void insert(T t){
        //找到当前最后一个结点
        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        //使得最后一个结点指向新的结点
        n.next = new Node(t,null);
        //链表长度+1
        N++;
    }

    /**
     * 在指定位置插入结点
     * @param i 插入结点的位置
     * @param t 新节点的数据
     */
    public void insert(int i, T t){
        //默认当前结点为头结点
        Node prev = head;
        //找出插入位置的前一个结点
        for (int index = 0;index <= i-1;index++){
            prev = prev.next;
        }
        //记录i结点的位置
        Node current = prev.next;
        //创建一个新的结点，并且新的结点指向原来的位置
        prev.next = new Node(t,current);
        //链表长度+1
        N++;
    }

    /**
     * 删除指定结点，并返回被删除的元素
     * @return 被删除的元素
     */
    public T remove(int i){
        //默认当前结点为头结点
        Node prev = head;
        //找出插入位置的前一个结点
        for (int index = 0; index<= i-1; index++){
            prev = prev.next;
        }
        //找到i位置的结点
        Node current = prev.next;
        //记录i位置的下一个结点
        //  Node nextNode = current.next;
        //i位置的前一个结点指向i位置的后一个结点
        prev.next = current.next;
        //链表长度减一
        N--;
        //返回i位置数据
        return current.item;

    }

    /**
     * 查找元素t在链表中第一次出现的位置
     * @param t 元素t
     * @return 元素t第一次出现的位置
     */
    public int indexOf(T t){
        Node n = head;
        //从头结点开始遍历链表 对比item是否于t相同
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 翻转链表
     */
    public void reverse(){
        if (!isEmpty()){
            reverse(head.next);
        }
    }

    /**
     * 反转某个结点
     * @param curr 需要反转的结点
     * @return 返回反转的结点
     */
    public Node reverse(Node curr){
        //递归的出口
        if (curr.next == null){
            head.next = curr;
            return curr;
        }
        //反转结点的下一个结点如果不为空，递归调用反转下一个结点
        //如果是head,1,2,3,4 这里进入的为4结点，返回的为head,4
        Node prev = reverse(curr.next);
        //这里就是反转 head，4,3
        prev.next = curr;
        curr.next = null;
        return curr;
    }
    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }
    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
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
