package com.bestrookie.heap;

/**
 * @author bestrookie
 * @date 2022/8/9 11:19
 */
public class IndexMinPriorityQueueBack <T extends Comparable<T>>{
    private T [] items;
    private int [] indexMap;
    private int [] reverseMap;
    private int N;

    public IndexMinPriorityQueueBack(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.indexMap = new int[capacity +1];
        this.reverseMap = new int[capacity +1];
        this.N = 0;

        for (int i = 0; i < reverseMap.length; i++) {
            reverseMap[i] = -1;
        }
    }

    public Integer size(){
        return N;
    }

    public Boolean isEmpty(){
        return N == 0;
    }

    private Boolean less(int i, int j){
        return items[indexMap[i]].compareTo(items[indexMap[j]]) < 0;
    }

    private void swap(int i, int j){
        //首先交换堆中的顺序
        int t = indexMap[i];
        indexMap[i] = indexMap[j];
        indexMap[j] = t;

        //更新堆索引调表的位置
        reverseMap[indexMap[i]] = i;
        reverseMap[indexMap[j]] = j;
    }

    /**
     * 上浮算法
     * @param k 需要上浮节点的索引
     */
    private void swim(int k){
        while (k > 1){
            if (less(k / 2 , k)){
                break;
            }
            swap(k/2,k);
            k = k / 2;
        }
    }

    /**
     * 下沉算法
     * @param k 需要下沉节点索引
     */
    private void sink(int k){
        while (2 * k <= N){
            int minIndex;
            if (2 * k + 1 <= N){
                minIndex = less(2 * k , 2 * k + 1) ? 2*k : 2*k+1;
            }else {
                minIndex = 2*k;
            }

            if (less(k , minIndex)){
                break;
            }
            swap(k , minIndex);
            k = minIndex;
        }
    }

    public int delMin(){
        int minIndex = indexMap[1];
        swap(1,N);
        reverseMap[indexMap[N]] = -1;
        indexMap[N] = -1;
        items[minIndex] = null;
        N--;
        sink(1);
        return minIndex;

    }

    /**
     * 判断索引i处是否添加元素
     * @param k 索引
     * @return 是否添加元素
     */
    private Boolean contains(int k){
        return reverseMap[k] != -1;
    }

    public void insert(int i, T t){
        if (contains(i)){
            return;
        }
        N++;
        items[i] = t;
        indexMap[N] = i;
        reverseMap[i] = N;
        swim(N);
    }
    public Integer minIndex(){
        return indexMap[1];
    }

    public void changeItems(int i , T t){
        items[i] = t;
        int index = reverseMap[i];
        swim(index);
        sink(index);
    }

    public void delete(int i){
        int index = reverseMap[i];
        swap(index,N);
        items[i] = null;
        indexMap[N] = -1;
        reverseMap[indexMap[N]] = -1;
        N--;
        sink(index);
        swim(index);

    }
}
