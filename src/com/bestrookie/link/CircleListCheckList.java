package com.bestrookie.link;

/**
 * @author bestrookie
 * @date 2022/4/27 17:21
 */
public class CircleListCheckList {
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

        System.out.println(isCircle(first));
    }

    public static boolean isCircle(NodeMe<Integer> first){
        NodeMe<Integer> fast = first;
        NodeMe<Integer> slow = first;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
