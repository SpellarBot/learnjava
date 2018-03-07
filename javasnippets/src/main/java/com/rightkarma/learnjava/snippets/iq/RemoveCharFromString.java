/*
 * LEARN Algo : remove a character from a string in 2 ways - 
 * recursive (function calling itself again and again) 
 * iterative ( using loops ) 
*/
package com.rightkarma.learnjava.snippets.iq;

public class RemoveCharFromString {
	
	public String removeIterative(String word, char unwanted) {
		StringBuilder sb = new StringBuilder();
		char[] letters = word.toCharArray();
		for (char c : letters) {
			if (c != unwanted) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public String removeRecursive(String word, char ch) {
		int index = word.indexOf(ch);
		if (index == -1) {
			return word;
		}
		return removeRecursive(
				word.substring(0, index)
						+ word.substring(index + 1, word.length()), ch);
	}
	
}
