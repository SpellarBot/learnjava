package com.rightkarma.learnjava.javapackage.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void main(String[] args) {
		
		/*
		 *  note - put all the resources you need to close within parenthesis in try block 
		 */
		
		try(
				FileReader fr = new FileReader("SomeFileForIO.txt");
				BufferedReader br = new BufferedReader(fr);
				)
		{
			String s;
			while ( (s=br.readLine()) != null ) {
				System.out.println("line read:"+s);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
