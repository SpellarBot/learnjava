package com.rightkarma.learnjava.snippets.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] arrayToSort = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        int[] arraySortManual = {4, 11, 23, 28, 43, 45, 65, 77, 89, 98};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arrayToSort);
        assertArrayEquals(arraySortManual, arrayToSort);
    }
}