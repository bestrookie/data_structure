package com.bestrookie.stack;

/**
 * @author bestrookie
 * @date 2022/5/9 11:30
 * 本方法是 学习与LeetCode结合
 */
public class BracketMatch {
    public static void main(String[] args) {
            String s = "()[]{}";
        System.out.println("测试用例:"+ isMatch(s));

    }
    public static Boolean isMatch(String str){
        MyStack<String> stack = new MyStack<>();
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if (c.equals("(")){
                stack.push(")");
            }else if (c.equals("{")){
                stack.push("}");
            }else if (c.equals("[")){
                stack.push("]");
            }else if (c.equals(")") || c.equals("}") || c.equals("]")){
                if (!stack.isEmpty() && !c.equals(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
