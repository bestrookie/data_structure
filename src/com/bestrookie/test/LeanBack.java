package com.bestrookie.test;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/5/4 20:52
 */
public class LeanBack {
    private static Comparable[] assist;
    public static void main(String[] args) {
        Integer[] a = {4,3,2,2,12,1,6,5};
        quick(a);
        System.out.println(Arrays.toString(a));
    }


    public static void quick(Comparable[] a){
        int lo = 0;
        int hi = a.length -1;
        quick(a,lo,hi);
    }
    public static void quick(Comparable[]a,int lo,int hi){
        if (lo >= hi){
            return;
        }
        int key = getKey(a, lo, hi);
        quick(a,lo,key-1);
        quick(a,key+1,hi);

    }
    public static int getKey(Comparable[]a,int lo,int hi){
        Comparable key = a[lo];
        int left = lo;
        int right = hi + 1;
        while (true){
            while (generate(a[--right],key)){
                if (right == left){
                    break;
                }
            }
            while (generate(key,a[++left])){
                if (left == right){
                    break;
                }
            }
            if (left >=right){
                break;
            }else {
                swap(a,left,right);
            }
        }
        swap(a,lo,right);
        return right;
    }



    public static void merge(Comparable a[]){
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length -1;
        sort(a,lo,hi);

    }
    public static void sort(Comparable[] a, int lo,int hi){
        if (hi <= lo){
            return;
        }
        int mid = lo + (hi -lo)/2;
        sort(a, lo,mid);
        sort(a,mid + 1,hi);
        merge(a,lo,mid,hi);
    }
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo;
        int p1 = lo;
        int p2 = mid +1;
        while (p1 <= mid && p2 <= hi){
            if (generate(a[p1],a[p2])){
                assist[i++] = a[p2++];
            }else {
                assist[i++] = a[p1++];
            }
        }
        while (p1 <= mid){
            assist[i++] = a[p1++];
        }
        while (p2 <= hi){
            assist[i++] = a[p2++];
        }
        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
    }
    public static void shell(Comparable a[]){
        int length = a.length;
        int h = 1;
        while (h > length / 2){
            h = h * 2 + 1;
        }
        while (h >= 1){
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h ; j = j -h) {
                    if (generate(a[j-h],a[j])){
                        swap(a,j-h,j);
                    }else {
                        break;
                    }
                }
            }
            h = h / 2;
        }
    }
    public static void swap(Comparable[] a, int i, int j){
        Comparable index = a[i];
        a[i] = a[j];
        a[j] = index;
    }
    public static Boolean generate(Comparable a,Comparable b){
        return a.compareTo(b) > 0;
    }
}
