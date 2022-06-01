package com.bestrookie.tree;

import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @date 2022/6/1 14:22
 */
public class PagerFolding {
    public static void main(String[] args) {
        TreeNode<String> root = generateTree(5);
        printTree(root);
    }

    public static void printTree(TreeNode<String> root){
        if (root == null){
            return;
        }
        if (root.left != null){
            printTree(root.left);
        }
        System.out.print(root.item+" ");
        if (root.right != null){
            printTree(root.right);
        }

    }

    public static TreeNode<String> generateTree(int n){
        TreeNode<String>  root = null;
        for (int i = 0; i < n; i++) {
            if (i == 0){
                root = new TreeNode<>("down",null,null);
                continue;
            }
            MyQueue<TreeNode> queue = new MyQueue<>();
            queue.enQueue(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.deQueue();
                if(node.left != null){
                    queue.enQueue(node.left);
                }
                if (node.right != null){
                    queue.enQueue(node.right);
                }
                if (node.left == null && node.right == null){
                    node.left = new TreeNode("down",null,null);
                    node.right = new TreeNode("up",null,null);
                }
            }

        }
        return root;
    }

    public static class TreeNode<T>{
        public T item;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(T item,TreeNode left, TreeNode right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}
