package com.bestrookie.test;

import com.bestrookie.sort.Quike;

import java.util.Arrays;

/**
 * @author bestrookie
 * @date 2022/4/6 15:01
 */
public class test {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        Quike quike = new Quike();
        Integer[] a = {1,2,5,6,7,9,8,3};
        System.out.println("排列前顺序："+ Arrays.toString(a));
        testMain.sort(a);
        System.out.println("排列后顺序"+ Arrays.toString(a));
    }
}
