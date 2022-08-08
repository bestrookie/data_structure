package com.bestrookie.heap;


/**
 * @author bestrookie
 * @date 2022/8/8 10:41
 */
public class MaxPriorityQueue <T extends Comparable<T>>{
    private T [] items;
    private int N;

    public MaxPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    private Boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }
    private void swap(int i, int j){
        T t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    public Integer size(){
        return N;
    }

    public Boolean isEmpty(){
        return N == 0;
    }

    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    public T delMax(){
        T max = items[1];
        swap(1,N);
        N--;
        sink(1);
        return max;
    }

    private void swim(int i){
        while (i > 1){
            if (!less(i /2,i)){
                break;
            }
            swap(i /2 , i);
            i = i / 2;
        }

    }
    private void sink(int i){
        while (2 * i <= N){
            int maxNode;
            if (2 * i + 1 <= N){
                maxNode = less(2 * i , 2 * i +1 ) ? 2 * i + 1 : 2 * i;
            }else {
                maxNode = 2 * i;
            }
            if (less(maxNode,i)){
                break;
            }
            swap(maxNode,i);
            i = maxNode;
        }
    }
}
