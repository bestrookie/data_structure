package com.bestrookie.mypoxy;

/**
 * @author bestrookie
 * @date 2023/2/1 11:38
 */
public class testPoxy {
    public static void main(String[] args) {
        SendMessage sendMessage = (SendMessage) JdkProxyFactory.getPoxy(new SendMessageImpl());
        sendMessage.send();
    }
}
