package com.bestrookie.test;

import java.util.Arrays;

/**
 * @author bestrookie
 * @date 2022/4/6 15:01
 */
public class test {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        Integer[] a = {4,6,8,9,2,10,1,3,5};
        System.out.println("排列前顺序："+ Arrays.toString(a));
        testMain.sort(a);
        System.out.println("排列后顺序"+ Arrays.toString(a));
    }
}
