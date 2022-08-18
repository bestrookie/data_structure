package com.bestrookie.tree;


import com.bestrookie.heap.IndexMinPriorityQueueBack;

/**
 * @author bestrookie
 * @date 2022/8/16 9:28
 */
public class RedBlackTree <Key extends Comparable<Key>,Value>{
    private NodeTree root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public Integer size(){
        return N;
    }

    private Boolean isRed(NodeTree node){
        return node != null && node.color == RED;
    }

    /**
     * 左旋调整
     * @param h 节点
     * @return 左旋完成后位置
     */
    private NodeTree rotateLeft(NodeTree h){
        NodeTree x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * 右旋调整
     * @param h 待调整节点
     * @return 右旋完成后的位置
     */
    private NodeTree rotateRight(NodeTree h){
        NodeTree x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * 颜色反转
     * @param h 节点
     * @return 反转后的节点
     */
    private NodeTree flipColors(NodeTree h){
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
        return h;
    }

    public void put(Key key,Value value){
        root = put(root,key,value);
        root.color = BLACK;

    }

    private NodeTree put(NodeTree h,Key key,Value value){
        if (h == null){
            N++;
            return new NodeTree(key,value,null,null,RED);
        }
        if (h.key.compareTo(key) > 0){
            h.left = put(h.left,key,value);
        } else if (h.key.compareTo(key) < 0) {
            h.right = put(h.right,key,value);

        }else {
            h.value = value;
        }
        //查看是否需要左旋
        if (!isRed(h.left) && isRed(h.right)){
            h = rotateLeft(h);
        }
        //查看是否需要右旋
        if (isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if (isRed(h.right) && isRed(h.left)){
            flipColors(h);
        }
        return h;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(NodeTree h,Key key){
        if (h == null){
            return null;
        }
        if (h.key.compareTo(key) > 0){
            return get(h.left,key);
        }else if(h.key.compareTo(key) < 0){
            return get(h.right,key);
        }else {
            return h.value;
        }
    }
    private class NodeTree{
        public Key key;
        public Value value;
        public NodeTree left;
        public NodeTree right;
        public Boolean color;
        public NodeTree(Key key, Value value,NodeTree left,NodeTree right,Boolean color){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }

    }
}
