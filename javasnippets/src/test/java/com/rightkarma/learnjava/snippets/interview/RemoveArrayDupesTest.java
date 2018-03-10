package com.rightkarma.learnjava.snippets.interview;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RemoveArrayDupesTest {


    @Test
    public void removeDuplicatesSortedArray() {
        int[] sortedArrayInput = {2,3,6,6,8,9,10,10,10,12,12};
        int[] expectedArray = {2, 3, 6, 8, 9, 10, 12};
        int[] output = RemoveArrayDupes.removeDuplicatesSortedArray(sortedArrayInput);
        assertArrayEquals(expectedArray, output);
    }

    @Test
    public void removeDuplicatesUnSortedArray() {
        int[] unsortedArrayInput = {6,2,8,8,3,9,10,12,12};
        int[] expectedArray = {2, 3, 6, 8, 9, 10, 12};
        int[] output = RemoveArrayDupes.removeDuplicatesUnSortedArray(unsortedArrayInput);
        Arrays.sort(output);
        assertArrayEquals(expectedArray, output);
    }
}