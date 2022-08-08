package com.bestrookie.heap;

/**
 * @author bestrookie
 * @date 2022/8/8 14:23
 */
public class MinPriorityQueue <T extends Comparable<T>> {
    private T[] items;
    private Integer N;

    public MinPriorityQueue(Integer capacity){
        this.N = 0;
        this.items = (T[]) new Comparable[capacity + 1];
    }

    public Integer size(){
        return N;
    }

    public Boolean isEmpty(){
        return N == 0;
    }

    private Boolean less(int i , int j){
        return items[i].compareTo(items[j]) < 0;
    }

    private void swap(int i , int j){
        T item = items[i];
        items[i] = items[j];
        items[j] = item;
    }

    private void swim(int k){
        while (k > 1){
            if (less(k/2,k)){
                break;
            }
            swap(k/2,k);
            k = k /2;
        }

    }

    private void sink(int k){
        while (2 * k <= N){
            int minIndex;
            if (2 * k + 1 <= N){
                minIndex = less(2 * k,2 * k + 1) ? 2 * k : 2 * k + 1;
            }else {
                minIndex = 2 * k;
            }
            if (less(k,minIndex)){
                break;
            }
            swap(k , minIndex);
            k = minIndex;
        }

    }
    public void insert(T item){
        items[++N] = item;
        swim(N);
    }

    public T delMin(){
        T min = items[1];
        swap(1,N);
        N--;
        sink(1);
        return min;
    }

}
