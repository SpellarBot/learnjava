package com.rightkarma.learnjava.javaapp.algo;

import java.util.HashSet;
import java.util.Set;

public class PrimeFactors {
	public static void main(String args[]) {
		/*System.out.printf("Prime factors of number '%d' are : %s %n", 35,
				primeFactors(35));
*/		System.out.printf("Prime factors of integer '%d' are : %s %n", 72,
				primeFactors(72));
/*System.out.printf("Prime factors of positive number '%d' is : %s %n",
				189, primeFactors(189));
		System.out.printf(
				"Prime factors of number '%d' are as follows : %s %n", 232321,
				primeFactors(232321));
		System.out.printf(
				"Prime factors of number '%d' are as follows : %s %n",
				67232321, primeFactors(67232321));*/
	}

	/**
	 * * @return prime factors of a positive integer in Java. * @input 40 * @output
	 * 2, 5
	 */
	public static Set<Integer> primeFactors(long number) {
		System.out.println("run program for number:"+number);
		Set<Integer> primefactors = new HashSet<>();
		long copyOfInput = number;
		for (int i = 2; i <= copyOfInput; i++) {
			System.out.println("i:"+i);
			if (copyOfInput % i == 0) {
				primefactors.add(i);
				// prime factor
				copyOfInput = copyOfInput/i;
				System.out.println("copyOfInput:"+copyOfInput);
				i--;
			}
		}
		return primefactors;
	}
}
