package com.rightkarma.learnjava.javabasic.reflection;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ClassClass {

    // LearningNote - understanding using ArrayList
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Class<?> c = list.getClass();

        System.out.println(c);// LearningNote - class java.util.ArrayList
        System.out.println(c.getName());// LearningNote - java.util.ArrayList
        System.out.println(c.getSimpleName());// LearningNote - ArrayList
        System.out.println("class package : " + c.getPackage().getName());// LearningNote - class package : java.util

        System.out.println("Super class: " + c.getSuperclass().getName());// LearningNote - Super class: java.util.AbstractList
        // LearningNote - java - you can walk up. not down, as child classes may not be in memory.

        Constructor<?>[] constructors = c.getConstructors();
        System.out.println("number of constructors :  " + constructors.length);// LearningNote - number of constructors :  3

        try {
            Object obj = constructors[1].newInstance();
            System.out.println(obj);// LearningNote - []
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
