package com.bestrookie.mymap;

/**
 * @author : bestrookie
 * @date : 14:04 2021/5/10
 */
public interface MyMap <K,V>{
    /**
     * 向map中添加数据
     * @param key key
     * @param value value
     * @return v
     */
    V put(K key ,V value);
    V get(K key);

    /**
     * 模拟Hash中的结点
     * @param <K> key
     * @param <V> value
     */
    interface Entry<K,V>{
        /**
         * 获取key
         * @return 返回key
         */
        K getKey();
        V getValue();
    }
}
