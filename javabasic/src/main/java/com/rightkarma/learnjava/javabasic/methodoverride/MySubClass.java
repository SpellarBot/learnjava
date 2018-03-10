/**
 * LearningNote
 * You can call a static method using an object and java would manage fine
 * If you have tried to override the method, it won't manage.
 * method called would depend upon Class Type not object type.
 *

 * */
package com.rightkarma.learnjava.javabasic.methodoverride;

public class MySubClass extends MyClass {

    public static void staticMethod() {
        System.out.println("MySubClass.staticMethod");
    }

    public void nonStaticMethod() {
        System.out.println("MySubClass.nonStaticMethod");
    }

    public static void main(String[] args) {
        MyClass m = new MySubClass();
        m.staticMethod(); // staticMethod of MyClass
        m.nonStaticMethod(); // nonStaticMethod of MySubClass
    }
}
/**
 *
OUTPUT
 MyClass.staticMethod
 MySubClass.nonStaticMethod


 */
// LearningNote - static methods are called as per reference type. non-static methods are based upon actual object type.