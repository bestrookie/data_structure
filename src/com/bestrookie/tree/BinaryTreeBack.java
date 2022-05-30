package com.bestrookie.tree;

import com.bestrookie.queue.MyQueue;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/5/24 22:03
 */
public class BinaryTreeBack<Key extends Comparable<Key>,Value> {
    private NodeTree root;
    private int N;

    public int size(){
        return N;
    }

    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    public NodeTree put(NodeTree x,Key key,Value value){
        if (x == null){
            N++;
            return new NodeTree(key,value,null,null);
        }
        int cmp = x.key.compareTo(key);
        if (cmp > 0){
            x.left = put(x.left,key,value);
        }else if (cmp < 0){
            x.right = put(x.right,key,value);
        }else {
            x.value = value;
        }
        return x;
    }

    public Value get(Key key){
        return get(root,key);
    }
    public Value get(NodeTree x,Key key){
        if (x == null){
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp > 0){
            return get(x.left,key);
        }else if (cmp < 0){
            return get(x.right,key);
        }else {
            return x.value;
        }
    }

    public void remove(Key key){
        remove(root,key);
    }

    public NodeTree remove(NodeTree x,Key key){
        if (x == null){
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp > 0 ){
            x.left =  remove(x.left,key);
        }else if (cmp < 0){
            x.right =  remove(x.right,key);
        }else {
            N--;
            if (x.left == null){
                if (x == root){
                    root = x.right;
                }
                return x.right;
            }
            if (x.right == null){
                if (x == root){
                    root = x.left;
                }
                return x.left;
            }

            NodeTree minNode = x.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }
            NodeTree n = x.right;
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
            minNode.left =x.left;
            minNode.right = x.right;
            x = minNode;
        }
        return x;
    }

    public Value min(){
        return min(root).value;
    }

    public NodeTree min(NodeTree x){
        if (x == null){
            return null;
        }
        if (x.left != null){
            return min(x.left);
        }
        return x;
    }

    public Value max(){
        return max(root).value;
    }
    public NodeTree max(NodeTree x){
        if (x == null){
            return null;
        }
        if (x.right != null){
            return max(x.right);
        }
        return x;

    }

    public MyQueue<Key> preErgodic(){
        MyQueue<Key> keys = new MyQueue<>();
        preErgodic(root,keys);
        return keys;
    }
    public void preErgodic(NodeTree x,MyQueue<Key> keys){
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




    private class NodeTree{
        public Key key;
        public Value value;
        public NodeTree left;
        public NodeTree right;

        public NodeTree(Key key,Value value,NodeTree left,NodeTree right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
