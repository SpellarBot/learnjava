package com.rightkarma.effectivejava.singleton;

import java.io.Serializable;

public class SingletonUsingStaticSerializable implements Serializable {
    public static final SingletonUsingStaticSerializable INSTANCE = new SingletonUsingStaticSerializable();

    private SingletonUsingStaticSerializable() {
    }

    // what is this ?? not sure.
    private Object readResolve(){
        return INSTANCE;
    }
}
