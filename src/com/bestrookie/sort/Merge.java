package com.bestrookie.sort;

import java.util.Comparator;

/** 归并排序
 * @author : bestrookie
 * @date : 11:15 2021/5/18
 */
public class Merge {
    /**
     * 归并排序所需要的辅助数组
     */
    private static Comparable[] assist;
    /**
     * 对数组a进行排序
     * @param a 数组a
     */
    public static void sort(Comparable[] a){
        //1.初始化辅助数组assist
        assist = new Comparable[a.length];
        //2.定义一个lo变量和hi变量，分别记录数组中最小的索引和最大的索引
        int lo = 0;
        int hi = a.length-1;
        //3.调用sort的重载方法，对索引lo到索引hi的元素进行排序
        sort(a,lo,hi);
    }
    private static void sort(Comparable[] a ,int lo,int hi){
        //先做安全性的检查
        if(hi <= lo){
            return;
        }
        //对lo到hi之间的元素进行分组 分为两个组
        int mid = lo +(hi-lo)/2;
        //分别对每一组进行排序
        sort(a, lo, mid);
        sort(a,mid+1, hi);
        //再把两个组中的数据合并
        merge(a, lo, mid, hi);
    }

    /**
     * 归并数组 并在归并的过程中排序
     * @param a 数组
     * @param lo 最小索引
     * @param mid 中间值
     * @param hi 最大索引
     */
    private static void merge(Comparable[]a,int lo,int mid,int hi){
        //1.定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid+1;
        //遍历，移动p1指针和p2指针，比较对应索引处的值，找出小的那个，放到辅助数组对应索引处
        while (p1 <= mid && p2<=hi){
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }
        //遍历，如果P1处的指针没有走完，那么顺序移动P1指针，把对应元素放到辅助数组对应索引处
        while (p1 <= mid){
            assist[i++] = a[p1++];
        }
        //遍历，如果P2处的指针没有走完，那么顺序移动P2指针，把对应元素放到辅助数组对应索引处
        while (p2 <= hi){
            assist[i++] = a[p2++];
        }
        //将辅助数组中的元素拷贝到原数组中
        for (int index = lo; index<= hi; index++){
            a[index] = assist[index];
        }

    }
    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void swap(Comparable[]a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
