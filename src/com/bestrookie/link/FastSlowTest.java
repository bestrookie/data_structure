package com.bestrookie.link;


/**
 * @author bestrookie
 * @date 2022/4/27 16:38
 */
public class FastSlowTest {
    public static void main(String[] args) {
        NodeMe<Integer> first = new NodeMe<>(1,null);
        NodeMe<Integer> second = new NodeMe<>(2,null);
        NodeMe<Integer> third = new NodeMe<>(3,null);
        NodeMe<Integer> fourth = new NodeMe<>(4,null);
        NodeMe<Integer> fifth = new NodeMe<>(5,null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        Integer mid = getFastSlowMid(first);
        System.out.println(mid);
    }
    public static Integer getFastSlowMid(NodeMe<Integer> first){
        NodeMe<Integer> fast = first;
        NodeMe<Integer> slow = first;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }
}
