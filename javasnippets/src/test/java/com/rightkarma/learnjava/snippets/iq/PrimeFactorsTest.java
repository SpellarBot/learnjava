package com.rightkarma.learnjava.snippets.iq;

import com.rightkarma.learnjava.snippets.iq.PrimeFactors;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class PrimeFactorsTest {

    @Test
    public void primeFactors() {
        List<Integer> primeFactors = PrimeFactors.primeFactors(1);
        assertTrue(primeFactors.isEmpty());
    }

    @Test
    public void primeFactors2() {
        ArrayList<Integer> primeFactors = PrimeFactors.primeFactors(2);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        assertArrayEquals(integers.toArray(), primeFactors.toArray());
    }

    @Test
    public void primeFactors3() {
        ArrayList<Integer> primeFactors = PrimeFactors.primeFactors(6);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        assertArrayEquals(integers.toArray(), primeFactors.toArray());
    }
}