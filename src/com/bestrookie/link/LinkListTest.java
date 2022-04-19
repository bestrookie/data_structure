package com.bestrookie.link;

import org.w3c.dom.Node;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/19 22:24
 */
public class LinkListTest<T> {
    private Node<T> head;
    private int n;

    public LinkListTest(){
        this.head = null;
        n = 0;
    }

    public void clean(){
        this.head = null;
        this.n = 0;
    }

    public Boolean isEmpty(){
        return n == 0;
    }
    public T get(int i){
        Node<T> current = head;
        for (int j = 0; j < i ; j++) {
            current = current.next;
        }
        return current.item;
    }

    public void insert(T t){
        Node<T> current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node<>(t,null);
        n++;
    }

    public void insert(T t,int i){
        Node<T> current = head;
        for (int index = 0 ; index < i ; i++){
            current = current.next;
        }
        Node<T> nowNode = current.next;
        current.next= new Node<>(t, nowNode);
        n++;
    }

    public T remove(int i){
        Node<T> prve = head;
        for (int j = 0; j < i; j++) {
            prve = prve.next;
        }
        Node<T> current = prve.next;
        prve.next = current.next;
        n--;
        return current.item;
    }

    public int indexOf(T t){
        Node<T> prve = head;

        for (int i = 0; i < n; i++) {
            prve = prve.next;
            if (prve.item.equals(t)){
                return i;
            }
        }
        return -1;
    }




   private class Node<T>{
       public T item;
       public LinkListTest<T>.Node<T> next;
       public Node(T item, LinkListTest<T>.Node<T> next){
           this.item = item;
           this.next = next;
       }
   }
}
