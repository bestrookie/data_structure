package com.bestrookie.tree;

import com.bestrookie.queue.MyQueue;

import java.util.Queue;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/5/23 22:03
 */
public class BinaryTree <Key extends Comparable<Key>,Value>{
    private TreeNode root;
    private int N;

    public int size(){
        return N;
    }

    public void put(Key key,Value value){
       root =  put(root,key,value);
    }

    public TreeNode put(TreeNode x,Key key,Value value){
        if (x == null){
            N++;
            return new TreeNode(key,value,null,null);
        }else if (x.key.compareTo(key) > 0){
            x.left = put(x.left,key,value);
        }else if (x.key.compareTo(key) < 0){
            x.right = put(x.right,key,value);
        }else {
            x.value = value;
        }

        return x;
    }

    public Value get(Key key){
        return get(root,key);
    }

    public Value get(TreeNode x,Key key){
        if (x == null){
            return null;
        }else if (x.key.compareTo(key) > 0){
            return get(x.left,key);
        }else if (x.key.compareTo(key) < 0){
            return get(x.right,key);
        }else {
            return x.value;
        }
    }

    public void delete(Key key){
        delete(root,key);
    }

    public TreeNode delete(TreeNode x ,Key key){
        if (x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0){
            x.right = delete(x.right,key);
        }else if (cmp < 0){
            x.left = delete(x.left,key);
        }else {
            N--;
            if (x.right == null){
                if (x == root){
                    root = x.left;
                }
                return x.left;
            }
            if (x.left == null){
                if (x == root){
                    root = x.right;
                }
                return x.right;
            }
            TreeNode mindNode = x.right;
            while (mindNode.left != null){
                mindNode = mindNode.left;
            }

            TreeNode n = x.right;
            while (n.left != null){
                if (n.left.left == null){
                    if (n.left.right != null){
                        n.left = n.left.right;
                    }else {
                        n.left = null;
                    }
                }else {
                    n = n.left;
                }
            }

            mindNode.left = x.left;
            mindNode.right = x.right;
            x = mindNode;

        }
        return x;
    }

    public Value min(){
        return min(root).value;
    }

    public TreeNode min(TreeNode n){
        if (n.left != null){
            return min(n.left);
        }else {
            return n;
        }
    }

    public Value max(){
        return max(root).value;
    }
    public TreeNode max(TreeNode n){
        if (n.right != null){
            return max(n.right);
        }else {
            return n;
        }
    }

    public MyQueue<Key> preErgodic(){
        MyQueue<Key> keys = new MyQueue<>();
        preErgodic(root,keys);
        return keys;
    }

    public void preErgodic(TreeNode x,MyQueue<Key> keys){
        if (x == null){
            return;
        }
        keys.enQueue(x.key);
        if (x.left != null){
          preErgodic(x.left,keys);
        }

        if (x.right != null){
            preErgodic(x.right,keys);
        }
    }




    private class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public Key key;
        public Value value;

        public TreeNode(Key key,Value value,TreeNode left,TreeNode right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
