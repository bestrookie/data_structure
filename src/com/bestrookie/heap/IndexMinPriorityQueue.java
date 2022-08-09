package com.bestrookie.heap;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/8/8 22:05
 */
public class IndexMinPriorityQueue <T extends Comparable<T>>{
    private T [] items;
    private int [] indexMap;
    private int [] reverseMap;
    private int N;

    public IndexMinPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.indexMap = new int[capacity +1 ];
        this.reverseMap = new int[capacity + 1];
        this.N = 0;

        for (int i = 0; i < reverseMap.length; i++) {
            reverseMap[i] = -1;
        }


    }
    public int size(){
        return N;
    }
    public Boolean isEmpty(){
        return N == 0;
    }

    private Boolean less(int i,int j){
        return items[indexMap[i]].compareTo(items[indexMap[j]]) < 0;
    }

    private void swap(int i, int j){
        //索引映射交换位置
        int t = indexMap[i];
        indexMap[i] = indexMap[j];
        indexMap[j] = t;
        // 索引的逆序映射变换
        reverseMap[indexMap[i]] = i;
        reverseMap[indexMap[j]] = j;

    }

    private Boolean contains(int k){
        return  reverseMap[k] != -1;
    }

    private int minIndex(){
        return indexMap[1];
    }

    public void insert(int i ,T t){
        if (contains(i)){
            return;
        }
        N++;
        items[i] = t;
        indexMap[N] = i;
        reverseMap[i] = N;
        swim(N);

    }

    public int delMin(){
        int minIndex = indexMap[1];
//        indexMap[1] = indexMap[N];
        swap(1,N);
        reverseMap[indexMap[N]] = -1;
        indexMap[N] = -1;
        items[minIndex] = null;
        N--;
        sink(1);
        return minIndex;
    }

    public void delIndex(int i){
        int targetIndex = reverseMap[i];
        swap(targetIndex,N);
        reverseMap[indexMap[N]] = -1;
        indexMap[N] = -1;
        items[i] = null;
        N--;
        swim(targetIndex);
        sink(targetIndex);
    }

    public void changeItem(int i,T t){
        items[i] = t;
        int indexMap = reverseMap[i];
        swim(indexMap);
        sink(indexMap);
    }

    private void swim(int i){
        while (i > 1){
            if (less(i / 2,i)){
                break;
            }
            swap(i/2,i);
            i = i / 2;
        }


    }

    private void sink(int i){
        while (2 * i <= N){
            int minIndex;
            if (2*i+1 <= N){
                minIndex = less(2*i,2*i+1) ? 2*i : 2*i+1;
            }else {
                minIndex = 2*i;
            }
            if (less(i,minIndex)){
                break;
            }
            swap(i,minIndex);
            i = minIndex;
        }
    }


}
