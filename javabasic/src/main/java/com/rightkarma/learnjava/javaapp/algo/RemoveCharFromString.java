/*
 * LEARN Algo : remove a character from a string in 2 ways - 
 * recursive (function calling itself again and again) 
 * iterative ( using loops ) 
*/
package com.rightkarma.learnjava.javaapp.algo;

public class RemoveCharFromString {
	
	private String pvtRemove(String word, char unwanted) {
		StringBuilder sb = new StringBuilder();
		char[] letters = word.toCharArray();
		for (char c : letters) {
			if (c != unwanted) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private String pvtRemoveRecursive(String word, char ch) {
		int index = word.indexOf(ch);
		if (index == -1) {
			return word;
		}
		return removeRecursive(
				word.substring(0, index)
						+ word.substring(index + 1, word.length()), ch);
	}
	
	public String removeRecursive(String word, char ch){
		return pvtRemoveRecursive(word, ch);
	}
	public String remove(String word, char ch){
		return pvtRemove(word, ch);
	}
	public static void main(String[] args) {
		RemoveCharFromString r = new RemoveCharFromString();
		String word = "We are now in the final stages of the implementation of the AV and various IT equipment in the new office. Over the next few days we would be relocating various devices (from RT and 12th floor)  to the new office for the final implementation in readiness for the inauguration.  As we progress with the equipment relocation a few services may be temporarily disrupted. We regret the temporary inconvenience caused due to this relocation.";
		System.out.println(r.remove(word, 'a'));
		System.out.println(r.removeRecursive(word, 'a'));
	}
}
