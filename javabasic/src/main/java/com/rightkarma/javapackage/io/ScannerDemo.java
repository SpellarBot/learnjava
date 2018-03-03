package com.rightkarma.javapackage.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		try (
				BufferedReader br = new BufferedReader(new FileReader("files/SomeFileForIO.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("files/ScannedFile.txt"));
				Scanner s = new Scanner(br);
				
				){
			s.useDelimiter(" ");
			while ( s.hasNext() ) {
				bw.write(s.next());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
