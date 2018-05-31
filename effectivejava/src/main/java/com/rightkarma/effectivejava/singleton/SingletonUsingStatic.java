package com.rightkarma.effectivejava.singleton;

import java.lang.reflect.AccessibleObject;

public class SingletonUsingStatic {
    public static final SingletonUsingStatic INSTANCE = new SingletonUsingStatic();

    private SingletonUsingStatic() {
    }

    // hack ? - reflection.
    // AccessibleObject.setAccessible
    // Safegaurd - Constructor should throw exception if called again.

}
