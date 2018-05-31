package com.rightkarma.effectivejava.singleton;

public class SingletonUsingStaticFactory {
    private static final SingletonUsingStaticFactory INSTANCE = new SingletonUsingStaticFactory();

    private SingletonUsingStaticFactory() {
    }

    public static SingletonUsingStaticFactory getInstance(){
        return INSTANCE;
    }

    // hack ? - reflection.
    // AccessibleObject.setAccessible
    // Safegaurd - Constructor should throw exception if called again.
    
}
