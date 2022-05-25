package com.bestrookie.test;

import com.bestrookie.queue.MyQueue;
import com.bestrookie.tree.BinaryTree;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/5/25 23:06
 */
public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String,Integer> tree = new BinaryTree<>();
        tree.put("E",5);
        tree.put("B",2);
        tree.put("G",7);
        tree.put("A",1);
        tree.put("D",4);
        tree.put("F",6);
        tree.put("H",8);
        tree.put("C",3);
        MyQueue<String> keys = tree.preErgodic();
        for (String key : keys) {
            Integer value = tree.get(key);
            System.out.println(key +" ------ "+ value);
        }
    }
}
