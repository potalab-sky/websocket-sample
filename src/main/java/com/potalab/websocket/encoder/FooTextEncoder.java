package com.potalab.websocket.encoder;

import com.potalab.websocket.object.Foo;
import org.json.JSONObject;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class FooTextEncoder implements Encoder.Text<Foo> {
    @Override
    public String encode(Foo object) throws EncodeException {
        JSONObject dog = new JSONObject();
        dog.put("name", object.getName());
        dog.put("type", object.getType());
        dog.put("age", object.getAge());
        return dog.toString();
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {

    }
}
