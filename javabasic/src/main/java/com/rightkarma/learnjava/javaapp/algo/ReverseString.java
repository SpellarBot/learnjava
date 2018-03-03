package com.rightkarma.learnjava.javaapp.algo;

import java.io.FileNotFoundException;

import java.io.IOException;

public class ReverseString {

	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		String str = "Sony is going to introduce Internet TV soon";
		System.out.println("Original String: " + str);
		// reversed string using Stringbuffer
		String reverseStr = new StringBuffer(str).reverse().toString();
		System.out.println("Reverse String in Java using StringBuffer: "
				+ reverseStr);
		// iterative method to reverse String in Java
		reverseStr = reverse(str);
		System.out.println("Reverse String in Java using Iteration: "
				+ reverseStr);
		// recursive method to reverse String in Java
		reverseStr = reverseRecursively(str);
		System.out.println("Reverse String in Java using Recursion: "
				+ reverseStr);
		// recursive method to reverse String in Java
		reverseStr=reverseRecursivelyPurihim(str);
		System.out.println("Reverse String in Java using Recursion: "
				+ reverseStr);
	}

	public static String reverse(String str) {
		StringBuilder strBuilder = new StringBuilder();
		char[] strChars = str.toCharArray();
		for (int i = strChars.length - 1; i >= 0; i--) {
			strBuilder.append(strChars[i]);
		}
		return strBuilder.toString();
	}

	public static String reverseRecursively(String str) {
		if (str.length() < 2) {
			return str;
		}
		/*
		 * String java.lang.String.substring(int beginIndex) Returns a new
		 * string that is a substring of this string. The substring begins with
		 * the character at the specified index and extends to the end of this
		 * string.
		 */
		return reverseRecursively(str.substring(1)) + str.charAt(0);
	}

	private static void recurseRev(StringBuffer str, int startIndex,
			int lastIndex) {
		if (startIndex >= lastIndex)
			return;
		char temp = str.charAt(startIndex);
		str.replace(startIndex, startIndex + 1, "" + str.charAt(lastIndex - 1)); // "" + will convert char to string
		str.replace(lastIndex - 1, lastIndex, "" + temp);
		recurseRev(str, startIndex + 1, lastIndex - 1);
	}

	public static String reverseRecursivelyPurihim(String str) {

		StringBuffer sb = new StringBuffer(str);
		recurseRev(sb, 0, sb.length());
		return sb.toString();

	}

}