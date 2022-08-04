package com.bestrookie.heap;

/**
 * @author bestrookie
 * @date 2022/8/2 11:21
 */
public class MyHeap <T extends Comparable<T>>{
    private T[] items;
    private int N;

    public MyHeap(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    private void swap(int i, int j){
        T t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    /**
     * 上浮算法
     * @param k 索引
     */
    private void swim(int k){
        while (k > 1){
            if (less(k/2,k)){
                swap(k/2,k);
            }else {
                break;
            }
            k = k/2;
        }
    }

    public T delMax(){
        T max = items[1];
        swap(1,N);
        items[N] = null;
        N--;
        sink(1);
        return max;

    }
    private void sink(int k){
        int max;
        while (2 * k <= N){
            if (2*k+1 <= N){
                max = items[2 * k].compareTo(items[2 * k +1]) > 0  ? 2*k : 2*k+1;
            }else {
                max = 2*k;
            }
            if (less(k,max)){
                swap(k,max);
            }else {
                break;
            }
            k = max;
        }

    }
}
