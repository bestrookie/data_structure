package com.bestrookie.link;

import java.util.Iterator;
/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/18 22:30
 */
public class SquuenceList<T> implements Iterable<T>{
    private T[] num;
    private int N;
    public SquuenceList(int size){
        num = (T[]) new Object[size];
        N = 0;
    }

    public void clear(){
        this.N = 0;
    }

    public Boolean isEmpty(){
        return N == 0;
    }

    public int length(){
        return N;
    }

    public T get(int i){
        return num[i];
    }

    public void insert(T t){
        num[N++] = t;
    }

    public void insert(int i, T t){
        for (int j = N; j > i; j--) {
            num[j] = num[j-1];
        }
        num[i] = t;
        N++;
    }

    public T remove(int i){
        T result = num[i];
        for (int j = i; j < N-1; j++) {
            num[j] = num[j+1];
        }
        N--;
        return result;
    }

    public int indexOf(T t){
        for (int i = 0; i < N; i++) {
            if (t.equals(num[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private int cusor;
        public SIterator(){
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return num[cusor++];
        }
    }
}
