package com.bestrookie.test;

import com.bestrookie.heap.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.WeakHashMap;

/**
 * @author bestrookie
 * @date 2022/8/2 17:11
 */
public class HeapTest {
    public static void main(String[] args) {
//        MyHeap<String> heap = new MyHeap<>(10);
//        MinPriorityQueue<String> heap = new MinPriorityQueue<>(10);
//        heap.insert("F");
//        heap.insert("G");
//        heap.insert("E");
//        heap.insert("A");
//        heap.insert("B");
//        heap.insert("C");
//        heap.insert("D");
//
//
//        String result = null;
//        while (!heap.isEmpty()){
//            System.out.println(heap.delMin());
//        }
//        String[] array = {"S","O","R","T","E","X","A","M","P","L","E"};
//        HeapSort.sort(array);
//        System.out.println(Arrays.toString(array));

        IndexMinPriorityQueueBack<String> queue  = new IndexMinPriorityQueueBack<>(10);
       // IndexMinPriorityQueue<String> queue  = new IndexMinPriorityQueue<>(10);
        queue.insert(0,"A");
        queue.insert(1,"C");
        queue.insert(2,"F");
        queue.changeItems(2,"B");

        while (!queue.isEmpty()){
            System.out.println(queue.delMin());
        }


    }
}
