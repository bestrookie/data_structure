package com.bestrookie.mymap;

/**
 * @author : bestrookie
 * @date : 16:45 2021/5/10
 */
public class TestMap {
    public static void main(String[] args) {
        MyHashMap<String,Object> map = new MyHashMap<>();
        map.put("1",2);
        map.put("2",3);
        System.out.println(map.get("2"));
    }
}
