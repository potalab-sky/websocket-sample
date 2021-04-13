package com.potalab.websocket.text;

import com.potalab.websocket.decoder.FooBinaryDecoder;
import com.potalab.websocket.decoder.FooTextDecoder;
import com.potalab.websocket.encoder.FooBinaryEncoder;
import com.potalab.websocket.encoder.FooTextEncoder;
import com.potalab.websocket.object.Foo;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/object",
        encoders = {FooTextEncoder.class, FooBinaryEncoder.class},
        decoders = {FooTextDecoder.class, FooBinaryDecoder.class})
public class FooEndpoint {
    @OnMessage
    public void onMessage(Session session, Foo foo) {
        System.out.println(foo);
        session.getAsyncRemote().sendObject(foo);
    }
}
