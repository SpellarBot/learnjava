package com.rightkarma.learnjava.snippets.iq;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseArrayInPlaceTest {

    @Test
    public void reverse() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int[] expectedOutput= {7, 6, 5, 4, 3, 2, 1};
        ReverseArrayInPlace.reverse(numbers);
        assertArrayEquals(expectedOutput, numbers);
    }
}