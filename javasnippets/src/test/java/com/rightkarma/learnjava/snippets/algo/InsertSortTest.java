package com.rightkarma.learnjava.snippets.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertSortTest {

    private int[] originalArray=new int[]{8,6,5,7,3,8,1,9};
    private int[] sortedArray=new int[]{1,3,5,6,7,8,8,9};

    @Test
    public void sort() {
        InsertSort.sort(originalArray);
        assertArrayEquals(originalArray,sortedArray);
    }
}