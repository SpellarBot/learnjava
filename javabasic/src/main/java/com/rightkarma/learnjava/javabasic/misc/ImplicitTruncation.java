package com.rightkarma.learnjava.javabasic.misc;

public class ImplicitTruncation {
    public static void main(String[] args) {
        float f1 = 10000000000f;
        System.out.println(String.format("%f", f1));
        f1++;
        System.out.println(String.format("%f", f1));
    }
}
/**
 * LearningNote
 * <p>
 * OUTPUT
 * 10000000000.000000
 * 10000000000.000000
 * that is because mantissa space is limited and 10exp10 does not fit in
 * so adding 1 makes no difference.
 * <p>
 * Note there is no exception generated here for overflow.
 * because this is ok for floating point numbers
 */
