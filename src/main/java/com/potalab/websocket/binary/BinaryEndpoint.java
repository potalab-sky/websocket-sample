package com.potalab.websocket.binary;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;

@ServerEndpoint("/binary")
public class BinaryEndpoint {
    @OnMessage
    public String onBinary(ByteBuffer byteBuffer) {
        String msg = new String(byteBuffer.array());
        System.out.println("binary msg: " + msg);
        return "return: " + msg;
    }
}
