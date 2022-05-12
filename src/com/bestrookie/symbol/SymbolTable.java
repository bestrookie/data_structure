package com.bestrookie.symbol;

/**
 * @author bestrookie
 * @date 2022/5/12 16:32
 */
public class SymbolTable<Key extends Comparable<Key>,Value>{
    private TableNode head;
    private int N;

    public SymbolTable(){
        this.head = new TableNode(null,null,null);
        this.N = 0;
    }
    private class TableNode{
        public Key key;
        public Value value;
        public TableNode next;
        public TableNode(Key key,Value value,TableNode next){
            this.key = key;
            this.value  = value;
            this.next = next;
        }
    }
    
    public Boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }
    
    public void put(Key key,Value value){
        TableNode curr = head.next;
        TableNode pre = head;
        while (curr != null && key.compareTo(curr.key)>0){
            pre = curr;
            curr = curr.next;
        }
        if (curr != null && key.compareTo(curr.key) == 0){
            curr.value = value;
            return;
        }
        pre.next = new TableNode(key,value,curr);
        N++;
    }

    public void remove(Key key){
        TableNode n = head;
        while (n.next != null){
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public Value get(Key key){
        if (isEmpty()){
            return null;
        }
        TableNode n = head;
        while (n.next != null){
            n = n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }

}
