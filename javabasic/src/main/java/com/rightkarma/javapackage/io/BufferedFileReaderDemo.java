package com.rightkarma.javapackage.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedFileReaderDemo {

	public static void main(String[] args) {
		try (
				BufferedReader br = new BufferedReader(new FileReader("files/SomeFileForIO.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("files/CopyOfSomeFileForIO.txt"));
				){
			int c;
			while ( ( c=br.read()) != -1 ) {
				bw.write(c);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
