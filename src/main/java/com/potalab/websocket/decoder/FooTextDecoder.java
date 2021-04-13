package com.potalab.websocket.decoder;

import com.potalab.websocket.object.Foo;
import org.json.JSONObject;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class FooTextDecoder implements Decoder.Text<Foo> {
    @Override
    public Foo decode(String s) throws DecodeException {
        JSONObject dog = new JSONObject(s);
        return new Foo(dog.getString("name"), dog.getString("type"), dog.getInt("age"));
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
