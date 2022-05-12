package com.bestrookie.test;

import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @date 2022/5/12 11:00
 */
public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("出队："+queue.deQueue());
    }
}
