package com.bestrookie.test;

import com.bestrookie.heap.HeapSort;
import com.bestrookie.heap.MyHeap;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author bestrookie
 * @date 2022/8/2 17:11
 */
public class HeapTest {
    public static void main(String[] args) {
//        MyHeap<String> heap = new MyHeap<>(10);
//        heap.insert("A");
//        heap.insert("B");
//        heap.insert("C");
//        heap.insert("D");
//        heap.insert("E");
//        heap.insert("F");
//        heap.insert("G");
//        String result = null;
//        while ((result = heap.delMax()) != null){
//            System.out.println(result);
//        }
        String[] array = {"S","O","R","T","E","X","A","M","P","L","E"};
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));

    }
}
