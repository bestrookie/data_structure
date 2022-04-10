package com.bestrookie.test;

/**
 * @author bestrookie
 * @date 2022/4/6 14:25
 */
public class TestMain {
    private static Comparable[] assist;
    public void sort(Comparable[] array){
        int lo = 0;
        int hi = array.length-1;;
        sort(array,lo,hi);
    }
    public void sort(Comparable[]a,int lo,int hi){
        if (hi <= lo){
            return;
        }
        int index = getIndex(a, lo, hi);
        sort(a,lo,index-1);
        sort(a,index+1,hi);
    }
    public int getIndex(Comparable[] a,int lo,int hi){
        Comparable key = a[lo];
        int left = lo;
        int right = hi + 1;
        while (true){
            while (less(key,a[--right])){
                if (right == left){
                    break;
                }
            }
            while (less(a[++left],key)){
                if (left == right){
                    break;
                }
            }

            if (left >= right){
                break;
            }else{
                swap(a,left,right);
            }
        }
        swap(a,lo,right);
        return right;
    }

    private Boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    private Boolean greater(Comparable a , Comparable b){
        return a.compareTo(b)>0;
    }
    private void swap(Comparable [] a , int i , int j){
        Comparable index = a[i];
        a[i] = a[j];
        a[j] = index;
    }
}
