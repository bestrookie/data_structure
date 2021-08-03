package com.bestrookie.test;

import com.bestrookie.sort.Insertion;
import com.bestrookie.sort.Selection;

import java.util.Arrays;

/**
 * @author : bestrookie
 * @date : 20:49 2021/5/9
 */
public class InsertTest {
    public static void main(String[] args) {
        Integer[] a = {4,3,2,10,12,1,6,5};
//        Bubble.sort(a);
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
