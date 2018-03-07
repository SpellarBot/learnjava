package com.rightkarma.learnjava.javabasic.misc;

public class IntegerDivision {
    public static void main(String[] args) {
        int x = -5;
        int y = 3;
        float f = x / y;

        // LearningNote - Division of ints will lead to int only !!
        System.out.println(x / y); // LearningNote - result -1

        // LearningNote - Division of ints will lead to int only even if output captured in float !!
        System.out.println(f);// LearningNote - result -1.0

        // LearningNote - Division of ints should be done by converting to floats if decimal output is expected
        f = (float) x / (float) y; // LearningNote - -1.6666666
        System.out.println(f);
    }
}
