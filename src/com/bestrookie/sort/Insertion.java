package com.bestrookie.sort;

/** 插入排序
 * @author : bestrookie
 * @date : 21:49 2021/5/10
 */
public class Insertion {
    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length ; i++) {
            for (int j = i; j > 0 ; j--) {
                if (greater(a[j-1],a[j])){
                    swap(a,j-1,j);
                }else {
                    break;
                }
            }
        }

    }
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) >0;
    }
    public static void swap(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
