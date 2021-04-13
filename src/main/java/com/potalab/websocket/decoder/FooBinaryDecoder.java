package com.potalab.websocket.decoder;

import com.potalab.websocket.object.Foo;
import org.json.JSONObject;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.nio.ByteBuffer;

public class FooBinaryDecoder implements Decoder.Binary<Foo> {
    @Override
    public Foo decode(ByteBuffer bytes) throws DecodeException {
        String msg = new String(bytes.array());
        JSONObject dog = new JSONObject(msg);
        return new Foo(dog.getString("name"), dog.getString("type"), dog.getInt("age"));
    }

    @Override
    public boolean willDecode(ByteBuffer bytes) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
