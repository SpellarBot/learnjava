package com.rightkarma.learnjava.snippets.interview;

import java.util.Arrays;

public class ReverseArrayInPlace {

	public static void reverse(int[] input)
	{ 
		System.out.println("original array : " + Arrays.toString(input)); 
		// handling null, empty and one element array
		if(input == null || input.length <= 1)
		{ 
			return; 
		} 
		for (int i = 0; i < input.length / 2; i++) 
		{ 
			int temp = input[i]; // swap numbers 
			input[i] = input[input.length - 1 - i]; 
			input[input.length - 1 - i] = temp; 
		} 
		System.out.println("reversed array : " + Arrays.toString(input)); 
	}
	
}
