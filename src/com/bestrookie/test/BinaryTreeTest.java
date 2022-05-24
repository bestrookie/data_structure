package com.bestrookie.test;

import com.bestrookie.tree.BinaryTree;
import com.bestrookie.tree.BinaryTreeBack;

import java.util.Objects;

/**
 * @author bestrookie
 * @date 2022/5/24 14:55
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTreeBack<Integer,String> tree = new BinaryTreeBack<>();

        tree.put(1,"一");
        tree.put(2,"二");
        tree.put(3,"三");
        System.out.println("元素个数:"+ tree.size());
        System.out.println("第二个元素:"+ tree.get(2));
        tree.remove(1);
        System.out.println(tree.get(1));
    }
}
