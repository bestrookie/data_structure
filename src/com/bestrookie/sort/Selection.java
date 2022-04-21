package com.bestrookie.sort;

/**
 * @author : bestrookie
 * @date : 21:38 2021/5/9
 */
public class Selection {
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < a.length ; j++) {
                if (generate(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
            swap(a,i,minIndex);
        }
    }
    /**
     * 比较元素v是否大于元素w
     * @param v 元素v
     * @param w 元素w
     * @return 是否大于
     */
    public static boolean generate(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 交换i,j的位置
     * @param a 原数组
     * @param i 交换的位置
     * @param j 交换的位置
     */
    public static void swap(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
