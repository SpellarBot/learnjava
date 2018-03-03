package com.rightkarma.javaapp.algo;
import java.util.Arrays;
public class InsertSort {
	/** 
	 * LEARN
	 * Pick an element, call it key. compare it to previous element.
	 * if the element is smaller, move the array forward till you find an element bigger than key
	 * if you don't find any element, reach the first location of array, the key would go to the beginning
	 * of the array.
	 * Here as we move forward in an array, the iterations will keep getting longer
	 * so in an array of 100 elements, when key is picked from 95th location,
	 * you might end up with upto 95 comparisons to find where the key fits in
	 * 
	 * This array would sort the array in place so good for memory.
	 * This array is O(n2) n square - so it will take very for large arrays to sort
	 * **/
	public static void sort(int[] array){
		for ( int j=1; j<array.length;j++){
			int i=j;
			int key = array[i];
			while (array[i-1]>key){
				array[i]=array[i-1];
				i=i-1;
				if ( i==0){
					break;
				}
			}
			array[i]=key;
		}
	}
	public static void main(String[] args) {
		int[] arrayToSort=new int[]{8,6,5,7,3,8,1,9};
		System.out.println(Arrays.toString(arrayToSort));
		InsertSort.sort(arrayToSort);
		System.out.println(Arrays.toString(arrayToSort));
	}
}
