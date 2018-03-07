package com.rightkarma.learnjava.snippets.iq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PrimeFactors {

    public static ArrayList<Integer> primeFactors(long number) {
        System.out.println("run program for number:" + number);
        ArrayList<Integer> primefactors = new ArrayList<>();
        long numberToCheck = number;
        for (int i = 2; i <= numberToCheck; i++) {
            if (numberToCheck % i == 0) {
                primefactors.add(i);
                // prime factor
                numberToCheck = numberToCheck / i;
                i--;
            }
        }
        System.out.println("prime factors:"+primefactors);
        return primefactors;
    }
}
