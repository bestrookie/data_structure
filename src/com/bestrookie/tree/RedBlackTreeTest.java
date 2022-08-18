package com.bestrookie.tree;

/**
 * @author bestrookie
 * @date 2022/8/18 11:26
 */
public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String,String> tree = new RedBlackTree<String,String>();
        tree.put("1","张三");
        tree.put("2","李四");
        tree.put("3","王五");
        System.out.println(tree.get("1"));
        System.out.println(tree.get("2"));
        System.out.println(tree.get("3"));
    }
}
