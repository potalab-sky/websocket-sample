package com.potalab.websocket.encoder;

import com.potalab.websocket.object.Foo;
import org.json.JSONObject;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.nio.ByteBuffer;

public class FooBinaryEncoder implements Encoder.Binary<Foo> {
    @Override
    public ByteBuffer encode(Foo object) throws EncodeException {
        JSONObject dog = new JSONObject();
        dog.put("name", object.getName());
        dog.put("type", object.getType());
        dog.put("age", object.getAge());
        return ByteBuffer.wrap(dog.toString().getBytes());
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
