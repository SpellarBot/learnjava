package com.rightkarma.javapackage.io;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UnderstandingPath {

	public static void main(String[] args) {
		Path path = Paths.get("files//SomeFileForIO.txt");
		System.out.println("path : "+path.toString());
		System.out.println("getFileName : "+path.getFileName()); 
		System.out.println("getNameCount : "+path.getNameCount()); 
		System.out.println("getName first : "+path.getName(0)); 
		System.out.println("getName 2nd : "+path.getName(1)); 
		
		try {
			Path realpath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
			System.out.println("realpath : "+realpath.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

/*
 * OUTPUT
path : files\SomeFileForIO.txt
getFileName : SomeFileForIO.txt
getNameCount : 2
getName first : files
getName 2nd : SomeFileForIO.txt
realpath : F:\aapurihitech\gitproject\GenJava\files\SomeFileForIO.txt


 */