package com.bestrookie.sort;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/10 16:10
 */
public class Quike {
    public void  sort(Comparable[] arrays){
        int lo = 0;
        int hi = arrays.length -1 ;
        sort(arrays,lo,hi);

    }

    public void sort(Comparable[] a, int lo ,int hi){
        if (hi <= lo){
            return;
        }
        int partition = partition(a, lo, hi);
        //左子组有序
        sort(a,lo,partition-1);
        //右子组有序
        sort(a,partition+1,hi);
    }
    private int partition(Comparable[]a,int lo,int hi){
        Comparable key = a[lo];
        int left = lo;
        int right = hi +1;
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
                    }else {
                        swap(a,left,right);
                    }

            }
        swap(a,lo,right);
        return right;
    }


    public Boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    public void swap(Comparable[]a,int i , int j){
        Comparable index = a[i];
        a[i] = a[j];
        a[j] = index;
    }
}
