package com.bestrookie.test;

import com.bestrookie.link.NodeMe;

/**
 * @author bestrookie
 * @date 2022/5/5 15:43
 */
public class LinkBack {
    public static void main(String[] args) {
        NodeMe<String> first = new NodeMe<>("aa",null);
        NodeMe<String> second = new NodeMe<>("bb",null);
        NodeMe<String> third = new NodeMe<>("cc",null);
        NodeMe<String> four = new NodeMe<>("dd",null);
        NodeMe<String> five = new NodeMe<>("ee",null);
        NodeMe<String> six = new NodeMe<>("ff",null);
        NodeMe<String> seven = new NodeMe<>("gg",null);
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = third;
        josephRing();
    }
    public static Integer getMid(NodeMe<Integer> first){
        NodeMe<Integer> fast = first;
        NodeMe<Integer> slow = first;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }
    public static Boolean isCircle(NodeMe<Integer> first){
        NodeMe<Integer> fast = first;
        NodeMe<Integer> slow = first;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
    public static String getEnter(NodeMe<String> first){
        NodeMe<String> fast = first;
        NodeMe<String> slow = first;
        NodeMe<String> index = null;
        while (fast.next != null && fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                index = first;
                continue;
            }
            if (index!=null){
                index = index.next;
                if (index == slow){
                    return index.item;
                }
            }
        }
        return null;
    }

    public static void josephRing(){
        NodeMe<Integer> first = null;
        NodeMe<Integer> pre = null;
        for (int i = 1; i < 42; i++) {
            if (i == 1){
                first = new NodeMe<>(i,null);
                pre = first;
                continue;
            }
            NodeMe<Integer> node = new NodeMe<>(i,null);
            pre.next = node;
            pre = node;
            if (i == 41){
                pre.next = first;
            }
        }
        int count = 0;
        NodeMe<Integer> n = first;
        while (n != n.next){
            count++;
            if (count == 3){
                pre.next = n.next;
                System.out.print(n.item+",");
                count = 0;
                n = n.next;
            }else {
                pre = n;
                n = n.next;
            }
        }
        System.out.print(n.item);
    }

}
