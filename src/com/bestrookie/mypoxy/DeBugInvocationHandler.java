package com.bestrookie.mypoxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author bestrookie
 * @date 2023/2/1 11:16
 */
public class DeBugInvocationHandler implements InvocationHandler {
    private final Object target;
    public DeBugInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理方法之前");
        Object result = method.invoke(target, args);
        System.out.println("执行代理方法之后");
        return result;
    }
}
