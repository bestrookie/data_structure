package com.bestrookie.heap;

/**
 * @author bestrookie
 * @date 2022/8/3 10:28
 */
public class HeapSort {
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j]) < 0;
    }
    private static void swap(Comparable[] heap,int i, int j){
        Comparable t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private static void createHeap(Comparable[] source,Comparable[] heap){
        System.arraycopy(source,0,heap,1,source.length);
        for (int i = (heap.length-1) / 2; i > 0 ; i--){
            sink(heap,i,heap.length-1);
        }

    }
    private static void sink(Comparable[] heap,int index,int range){
        while (2 * index <= range){
            //找出子节点中较大节点的位置
            int max;
            if (2 * index + 1 <= range){
                max = less(heap,2 * index,2 * index +1) ? 2 * index + 1 : 2 * index;
            }else {
                max = 2 * index;
            }
            if (!less(heap,index,max)){
                break;
            }
            swap(heap,index,max);
            index = max;
        }
    }

    public static void sort(Comparable[] source){
        //创建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source,heap);
        int index = heap.length -1;
        while (index != 1){
            swap(heap,1,index);
            index--;
            sink(heap,1,index);
        }
        System.arraycopy(heap,1,source,0,source.length);
    }
}
