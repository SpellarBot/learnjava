package com.rightkarma.learnjava.javabasic.misc;

// learn - any method code in the class will conform to the IEEE 754 standard rules for floating points.
// Without that modifier, floating points used in the methods might behave in a platform-dependent way.

public strictfp /*final*/ class StrictClass { // learn - making class final will make sub-class impossible
    float f1 = 1.0f;

     // learn - final method can't be overridden
    public final void printString(String str){
        System.out.println(str);
    }
}

class anotherClass extends StrictClass{
    // learn - not possible to override the final method

    /*public final void printString(String str){
        System.out.print(str);
    }*/
}