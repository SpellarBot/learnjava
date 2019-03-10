package com.rightkarma.effectivejava.noninstantiable;

// to make it clear that you don't want class to be instantiated,
// create constructore as private
// create other methods as static

public class NonInstantiableUtilityClass {
    private NonInstantiableUtilityClass() {
    }

    public static void otherStaticMethods(){
        //...
    }
}
