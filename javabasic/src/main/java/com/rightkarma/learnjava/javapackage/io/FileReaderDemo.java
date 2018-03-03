package com.rightkarma.learnjava.javapackage.io;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderDemo {

	public static void main(String[] args) {
		try (
				FileReader fs = new FileReader("files/SomeFileForIO.txt");
				FileWriter fos = new FileWriter("files/CopyOfSomeFileForIO");
				){
			int c;
			while ( ( c=fs.read()) != -1 ) {
				fos.write(c);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

/*
 * works in older versions of java and android.
 * best choice from compatibility point of view.
 * 
 */