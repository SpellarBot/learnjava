package com.rightkarma.learnjava.snippets.algo;

/*
Merge sort will keep splitting the array in 2 till end
and then merge the split arrays.
*/

public class MergeSort {
    private int[] array;
    private int[] tempMergArr;
    private int length;


    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            System.out.println("doMergeSort:"+lowerIndex+ " "+middle+ " "+higherIndex);
            int tmp = middle + 1;
            // Below step sorts the left side of the array
            System.out.println("calling for left side");
            doMergeSort(lowerIndex, middle);
            System.out.println("calling for right side");
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            System.out.println("calling merge parts");
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        System.out.println("lowerIndex:"+lowerIndex+ "middle:"+middle+" higherIndex:"+higherIndex);

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
