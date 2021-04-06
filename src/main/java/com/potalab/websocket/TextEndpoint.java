package com.potalab.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/text")
public class TextEndpoint {
    @OnMessage
    public String onText(String msg) {
        System.out.println(msg);
        return "return: " + msg;
    }
}
