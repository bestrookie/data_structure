package com.bestrookie.link;

/**
 * @author bestrookie
 * @date 2022/4/27 16:39
 */
public class NodeMe<T>{
    public T item;
    public NodeMe next;
    public NodeMe(T t,NodeMe next){
        this.item = t;
        this.next = next;
    }

}
