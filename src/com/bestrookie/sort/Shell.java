package com.bestrookie.sort;

/**
 * @author : bestrookie
 * @date : 21:47 2021/5/12
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int h = 1;
        while (h > a.length / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            //找到待插入元素
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (generate(a[j - h], a[j])) {
                        swap(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
        }

    }

    public static boolean generate(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
