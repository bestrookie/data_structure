package com.bestrookie.test;

/**
 * @author bestrookie
 * @date 2022/4/6 14:25
 */
public class TestMain {
    private static Comparable[] assist;
    public void sort(Comparable[] array){
        assist = new Comparable[array.length];
        int lo = 0;
        int hi = array.length-1;
        sort(array,lo,hi);

    }


    private void sort(Comparable[] array,int lo,int hi){
        if (hi <= lo){
            return;
        }

        int mid  = lo + (hi - lo) / 2;
        sort(array,lo,mid);
        sort(array,mid + 1,hi);
        merge(array,lo,mid,hi);

    }
    private void merge(Comparable []a,int lo ,int mid,int hi){
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;
        while (p1<=mid && p2<= hi){

            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }

        while (p1 <= mid){
            assist[i++] = a[p1++];
        }

        while (p2 <= hi){
            assist[i++] = a[p2++];
        }

        if (hi + 1 - lo >= 0) {
            System.arraycopy(assist, lo, a, lo, hi + 1 - lo);
        }

    }
    private Boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    private Boolean greater(int a , int b){
        return a > b;
    }
    private void swap(int [] a , int i , int j){
        int index = a[i];
        a[i] = a[j];
        a[j] = index;
    }
}
