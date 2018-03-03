package com.rightkarma.learnjava.javapackage.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWriteFile {

	public static void main(String[] args) {
		Path pathSource = Paths.get("files//SomeFileForIO.txt");
		Charset cs = Charset.forName("UTF-8");
		
		readFile(pathSource, cs);
		writeFile(pathSource, cs);
		readFile(pathSource, cs);
	}

	private static void writeFile(Path pathSource, Charset cs) {
		System.out.println("..............................");
		System.out.println("writing to file...");
		System.out.println("..............................");
		try (BufferedWriter bw = Files.newBufferedWriter(pathSource, cs, java.nio.file.StandardOpenOption.APPEND)){
			String line="extra last line..";
			bw.append(line); // Dont use write method.. it will wipe out existing contents.
			bw.newLine();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void readFile(Path pathSource, Charset cs) {
		System.out.println("..............................");
		System.out.println("reading file...");
		System.out.println("..............................");
		try (BufferedReader br = Files.newBufferedReader(pathSource, cs)){
			String line;
			while ((line=br.readLine())!= null) {
				System.out.println(line);
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

/*
OUTPUT
..............................
reading file...
..............................
a
b
c
..............................
writing to file...
..............................
..............................
reading file...
..............................
a
b
c
extra last line..

 * */
 