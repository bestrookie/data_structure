package com.bestrookie.test;

import com.bestrookie.sort.Selection;

import java.util.Arrays;

/**
 * @author : bestrookie
 * @date : 20:49 2021/5/9
 */
public class BubbleTest {
    public static void main(String[] args) {
        Integer[] a = {5,6,4,3,1,2};
//        Bubble.sort(a);
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
