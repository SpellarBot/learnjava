package com.rightkarma.learnjava.javabasic;

public class JavaLiterals {

	char a='a'; // char literal
	char letterN = '\u004E'; // The letter 'N' using Unicode
	/*characters are just 16-bit unsigned integers under the hood.*/
	char c = (char)70000; // The cast is required; 70000 is out of char range
	char d = (char) -98; // Ridiculous, but legal

	/*You can also use an escape code (the backslash) if you want to represent a
	character that can't be typed in as a literal, including the characters for linefeed,
	newline, horizontal tab, backspace, and quotes:*/
	char c1 = '\"'; // A double quote
	char d1 = '\n'; // A newline
	char tab = '\t'; // A tab
	
	int i = Integer.MAX_VALUE; // 2147483647
	int i2 = Integer.MAX_VALUE+1; // -2147483648
	int i3 = Integer.MAX_VALUE+2; // -2147483647
	
	boolean a2 = false ;// boolean literal
	double a3=2546789.343 ;// double literal
	
	/*Binary literals can use only the digits 0 and 1. 
	Binary literals must start with either 0B or 0b*/
	int b1 = 0B101010; // set b1 to binary 101010 (decimal 42)
	int b2 = 0b00011; // set b2 to binary 11 (decimal 3)
	
	/*Octal integers use only the digits 0 to 7. In Java, you represent an
	integer in octal form by placing a zero in front of the number*/
	int six = 06; // Equal to decimal 6
	int seven = 07; // Equal to decimal 7
	int eight = 010; // Equal to decimal 8
	int nine = 011; // Equal to decimal 9
	
	/*Hexadecimal (hex for short) numbers are constructed using 16 distinct symbols
	prefix 0x (or 0X) or the optional suffix extension L,*/
	int x = 0X0001;
	int y = 0x7fffffff;
	int z = 0xDeadCafe;
	
	/*All four integer literals (binary, octal, decimal, and hexadecimal) are defined as
	int by default, but they may also be specified as long by placing a suffix of L or l  after the number:*/
	long jo = 110599L;
	long so = 0xFFFFl; // Note the lowercase 'l'
	
	boolean t = true; // Legal
//	boolean f = 0; // Compiler error!

	public static void main(String[] args) {
		char d = (char) 100;
		System.out.println(d);
		
	}
	
}
