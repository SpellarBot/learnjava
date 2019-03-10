package com.rightkarma.effectivejava.publicanddefault.t1;

import com.rightkarma.effectivejava.publicanddefault.t2.ClassTwo;

// learn - ClassTwo can't see ClassOne
// And that is way for you to hide your implementation within package.
// For other classes to use your class, give them interface of your class that is public.
// So here ClassTwo has interface object for ClassOne but can't see ClassOne implementation.
// It can only call methods from ClassOne


public class Main {
    public static void main(String[] args) {
        IClassOne c1 = new ClassOne();
        ClassTwo classTwo = new ClassTwo();
        classTwo.setClassOne(c1);
        classTwo.printString();
    }
}
