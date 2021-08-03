package com.bestrookie.test;

import com.bestrookie.sort.Insertion;
import com.bestrookie.sort.Shell;

import java.util.Arrays;

/**
 * @author : bestrookie
 * @date : 20:49 2021/5/9
 */
public class ShellTest {
    public static void main(String[] args) {
        Integer[] a = {4,3,2,10,12,1,6,5};
//        Bubble.sort(a);
        Shell.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
