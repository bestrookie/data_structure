package com.bestrookie.test;

/**
 * @author bestrookie
 * @date 2022/4/6 14:25
 */
public class TestMain {
    public void sort(int [] array){
        int h  = 1;
        while (h < array.length/2){
            h = 2 * h + 1;
        }
        while (h > 0){
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h ; j = j - h) {
                    if (greater(array[j-h],array[j])){
                        swap(array,j-h,j);
                    }else {
                        break;
                    }
                }
            }
            h = h/2;
        }
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
