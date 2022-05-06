package com.bestrookie.test;

import com.bestrookie.stack.MyStack;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/5/6 22:44
 */
public class StackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("弹出元素："+stack.pop());
        System.out.println("栈长度："+stack.N);
        for (Integer item : stack) {
            System.out.println(item);
        }

    }
}
