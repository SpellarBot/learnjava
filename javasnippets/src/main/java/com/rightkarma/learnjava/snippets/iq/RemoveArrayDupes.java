package com.rightkarma.learnjava.snippets.iq;

import java.util.*;

public class RemoveArrayDupes {

	/** 
	 * This method would destroy the original array.
	 * advantage is that it saves from creating another large array
	 * this will need array to be sorted
	 * **/
	public static int[] removeDuplicatesSortedArray(int[] inputArray){
        
        int i = 0;
        int j = 1;
        //return if the array length is less than 2
        if(inputArray.length < 2){
            return inputArray;
        }
        while(j < inputArray.length){
            if(inputArray[i]==inputArray[j]){
                j++;
            }else{
                i++;
                inputArray[i] = inputArray[j];
                j++;
            }
        }
        int[] output = new int[i+1];
        for(int k=0; k<output.length; k++){
            output[k] = inputArray[k];
        }
         
        return output;
    }

	public static int[] removeDuplicatesUnSortedArray(int[] arrayInput){
        List<Integer> tempList = new ArrayList<Integer>(arrayInput.length);
        for (int i : arrayInput) {
            tempList.add(i);
        }
        HashSet<Integer> integerSet = new HashSet<Integer>(tempList);
        int[] finalIntArray = new int[integerSet.size()];
        int i=0;
        for (Integer integer : integerSet) {
            finalIntArray[i]=integer;
            i++;
        }
        return finalIntArray;
	}


}
