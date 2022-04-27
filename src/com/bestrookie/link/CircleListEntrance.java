package com.bestrookie.link;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2022/4/27 22:09
 */
public class CircleListEntrance {
    public static void main(String[] args) {
        NodeMe<String> first = new NodeMe<>("aa",null);
        NodeMe<String> second = new NodeMe<>("bb",null);
        NodeMe<String> third = new NodeMe<>("cc",null);
        NodeMe<String> fourth = new NodeMe<>("dd",null);
        NodeMe<String> fifth = new NodeMe<>("ee",null);
        NodeMe<String> six = new NodeMe<>("ff",null);
        NodeMe<String> seven = new NodeMe<>("gg",null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        seven.next= third;
        System.out.println(getEntrance(first).item);
    }

    public static NodeMe getEntrance(NodeMe<String> first){
        NodeMe<String> fast = first;
        NodeMe<String> slow = first;
        NodeMe<String> temp = null;
        while (fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                temp = first;
                continue;
            }
            if (temp != null){
                temp = temp.next;
                if (temp == slow){
                    break;
                }
            }
        }
        return temp;
    }
}
