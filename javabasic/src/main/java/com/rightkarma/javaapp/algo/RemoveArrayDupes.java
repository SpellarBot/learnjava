package com.rightkarma.javaapp.algo;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveArrayDupes {

	/** 
	 * This method would destroy the original array.
	 * advantage is that it saves from creating another large array
	 * this will need array to be sorted
	 * **/
	public static int[] removeDuplicatesSortedArrayOne(int[] sortedArrayInput){
        
        int j = 0;
        int i = 1;
        //return if the array length is less than 2
        if(sortedArrayInput.length < 2){
            return sortedArrayInput;
        }
        while(i < sortedArrayInput.length){
            if(sortedArrayInput[i] == sortedArrayInput[j]){
                i++;
            }else{
                sortedArrayInput[++j] = sortedArrayInput[i++];
            }    
        }
        int[] output = new int[j+1];
        for(int k=0; k<output.length; k++){
            output[k] = sortedArrayInput[k];
        }
         
        return output;
    }

	public static int[] removeDuplicatesUnSortedArrayOne(int[] unsortedArrayInput){
		int[] tempArray = new int[unsortedArrayInput.length];
		int outputArrayLocation = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<unsortedArrayInput.length;i++){
			int arrayValue = unsortedArrayInput[i];
			if (! set.contains(arrayValue)){
				tempArray[outputArrayLocation]=arrayValue;
				outputArrayLocation++;
				set.add(arrayValue);
			}
		}
		int size = set.size();
		//int[] output = new int[size];
		int[] output=Arrays.copyOf(tempArray, size);
		return output;
	}

	public static void main(String a[]){
        int[] sortedArrayInput = {2,3,6,6,8,9,10,10,10,12,12};
        int[] output = removeDuplicatesSortedArrayOne(sortedArrayInput);
        printArray(output);
        
        int[] unsortedArrayInput = {6,2,36,8,34,22,11,12,11,12,10, 9,10,12,12};
        output = removeDuplicatesUnSortedArrayOne(unsortedArrayInput);
        printArray(output);
    }

	private static void printArray(int[] output) {
		for(int i:output){
            System.out.print(i+" ");
        }
		System.out.println("\n");
	}
	
}
