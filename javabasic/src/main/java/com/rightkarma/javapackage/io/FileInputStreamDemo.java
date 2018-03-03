package com.rightkarma.javapackage.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		try (
				FileInputStream fs = new FileInputStream("files/FileForIOTesting.jpg");
				FileOutputStream fos = new FileOutputStream("files/CopyOfFileForIOTesting.jpg");
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
