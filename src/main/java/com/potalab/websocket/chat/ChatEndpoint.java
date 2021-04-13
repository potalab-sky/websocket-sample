package com.potalab.websocket.chat;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat/{id}")
public class ChatEndpoint {
    @OnOpen
    public void onOpen(Session session, @PathParam("id")String id) {
        String msg = "enjoy " + id;
        System.out.println(msg);
        session.getOpenSessions().forEach(toSession -> toSession.getAsyncRemote().sendText(msg));
    }
    @OnMessage
    public void onMessage(Session session, String msg, @PathParam("id")String id) {
        msg = id + ":" + msg;
        String finalMsg = msg;
        session.getOpenSessions().forEach(toSession -> {
            if(toSession.isOpen()) {
                toSession.getAsyncRemote().sendText(finalMsg);
            }
        });
    }
}
