package com.bestrookie.mymap;

/**
 * @author : bestrookie
 * @date : 14:20 2021/5/10
 */
public class MyHashMap<K,V> implements MyMap<K,V>{
    /**
     * 初始容量
     */
    private static final int DEFAULT_INITIAL_CAPACITY =16;
    /**
     * 默认加载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * 还是加载因子
     */
    private  float loadFactor = 0;
    /**
     * 数组的初始容量（桶的个数）
     */
    private int initCapacity = 0;
    /**
     * 数组（桶）
     */
    private Entry<K,V>[] table = null;

    /**
     * 自定义构造器
     */
    public MyHashMap(){
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.initCapacity = DEFAULT_INITIAL_CAPACITY;
        table = new Entry[this.initCapacity];
    }

    /**
     * hash计算散列 为了是散列更加均匀，减少hash冲突
     * @param key key
     * @return hash
     */
    private int hash(K key){
        int h;
        return (key==null)? 0:Math.abs((h = key.hashCode())) ^  (h>>>16);
    }

    @Override
    public V put(K key, V value) {
        //计算出存储的位置（数组的索引）
        int index = hash(key) % initCapacity;
        //如果存储的位置已经有数据就生成一个单向链表
        if (table[index] != null){
            Entry<K,V> e = table[index];
            Entry<K,V>e2 = null;
            while (e !=null){
                if (hash(e.key) == hash(key) && e.key.equals(key)){
                    //如果键相同，更新值
                    e.value = value;
                }
                //遍历链表判断是否已经存在相同的key;
                e2 = e;
                e = e.next;
            }
            //如果不存在相同的key，则直接插到尾结点的后面
            e2.next = new Entry<>(key,value,null,index);
        }else{
            Entry<K,V> e = new Entry<>(key,value,null,index);
            table[index] = e;
        }
        return value;

    }

    @Override
    public V get(K key) {
        //根据key，计算下标index;
        int index = hash(key) % initCapacity;
        Entry<K,V> e = table[index];
        if (e == null){
            return null;
        }
        while (e != null){
            if (e.key ==null && key ==null || hash(e.key) == hash(key) && e.key.equals(key)){
                return e.value;
            }
            e = e.next;
        }
        return null;
    }


    /**
     * 节点类
     * @param <K> key
     * @param <V> value
     */
    class Entry<K,V> implements MyMap.Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        int index;//记录下标
        Entry(K key, V value, Entry<K,V> next,int index){
            this.key = key;
            this.value = value;
            this.next = next;
            this.index = index;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
        public Entry<K,V> getNext(){
            return next;
        }
    }
}
