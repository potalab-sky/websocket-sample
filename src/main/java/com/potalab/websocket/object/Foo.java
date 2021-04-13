package com.potalab.websocket.object;

public class Foo {
    private String name;
    private String type;
    private int age;

    public Foo() {

    }
    public Foo(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }
}
