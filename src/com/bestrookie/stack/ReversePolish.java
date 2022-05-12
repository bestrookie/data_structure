package com.bestrookie.stack;

import org.jcp.xml.dsig.internal.dom.ApacheOctetStreamData;

/**
 * @author bestrookie
 * @des 逆波兰
 * @date 2022/5/10 17:21
 */
public class ReversePolish {
    public static void main(String[] args) {
        String[] polish = {"3","17","15","-","*","18","6","/","+"};
        System.out.println(reversePolish(polish));

    }
    public static Integer reversePolish(String[] polish){
        MyStack<Integer> stack = new MyStack<>();

        for (String curr : polish) {
            Integer p1 =0;
            Integer p2 =0;
            Integer result =0;
            switch (curr) {
                case "+":
                    p1 = stack.pop();
                    p2 = stack.pop();
                    result = p1 + p2;
                    stack.push(result);
                    break;
                case "-":
                    p1 = stack.pop();
                    p2 = stack.pop();
                    result = p2 - p1;
                    stack.push(result);
                    break;
                case "*":
                    p1 = stack.pop();
                    p2 = stack.pop();
                    result = p1 * p2;
                    stack.push(result);
                    break;
                case "/":
                    p1 = stack.pop();
                    p2 = stack.pop();
                    result = p2 / p1;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(curr));
                    break;
            }
        }
        return stack.pop();
    }
}
