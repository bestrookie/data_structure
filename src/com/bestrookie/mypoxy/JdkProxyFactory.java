package com.bestrookie.mypoxy;


import java.lang.reflect.Proxy;

/**
 * @author bestrookie
 * @date 2023/2/1 11:31
 */
public class JdkProxyFactory {
    public static Object getPoxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new DeBugInvocationHandler(target));
    }
}
