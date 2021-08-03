package com.bestrookie.test;

import com.bestrookie.sort.Merge;

import java.util.Arrays;

/**
 * @author : bestrookie
 * @date : 15:52 2021/5/18
 */
public class MergeTest {
    public static void main(String[] args) {
        Integer[] a ={8,4,5,7,1,3,6,2};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
