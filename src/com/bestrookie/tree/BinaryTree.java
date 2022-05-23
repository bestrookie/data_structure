package com.bestrookie.tree;

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

    }

    public TreeNode put(TreeNode x,Key key,Value value){
        if (x == null){
            return new TreeNode(key,value,null,null);
        }else if (x.key.compareTo(key) > 0){
            x.right = put(x,key,value);
        }else if (x.key.compareTo(key) < 0){
            x.left = put(x,key,value);
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
            return get(x.right,key);
        }else if (x.key.compareTo(key) < 0){
            return get(x.left,key);
        }else {
            return x.value;
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
