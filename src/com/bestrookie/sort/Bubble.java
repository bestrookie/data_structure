package com.bestrookie.sort;

/**
 * @author : bestrookie
 * @date : 20:30 2021/5/9
 */
public class Bubble {
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }

            }
        }
    }
    /**
     * 判断元素v是否大于元素w
     * @param v 做比较的数据
     * @param w 作比较的数据
     * @return 是否相等
     */
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 交换位置
     * @param a 原来的一组数据
     * @param i 位置
     * @param j 位置
     */
    public static void exch(Comparable[] a,int i ,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
