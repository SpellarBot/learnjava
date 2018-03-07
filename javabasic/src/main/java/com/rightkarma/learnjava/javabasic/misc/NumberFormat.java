package com.rightkarma.learnjava.javabasic.misc;

public class NumberFormat {
    public static void main(String[] args) {
        int anynum = 1_00_0000; // // LearningNote - java 7 - numbers can have _ in them
        float anothernum = 2_3.00_78f; // // LearningNote - floats are also covered

        anynum++; // 1000001
        System.out.println(anynum);

        anothernum++; // 24.0078
        System.out.println(anothernum);
    }
}
