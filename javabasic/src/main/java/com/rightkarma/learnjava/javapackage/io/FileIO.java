package com.rightkarma.learnjava.javapackage.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileIO {

	public static void main(String[] args) throws IOException {
		Path pathSource = Paths.get("files//SomeFileForIO.txt");
		Path pathTarget = Paths.get("files//CopyOfSomeFileForIO.txt");
		Files.copy(pathSource, pathTarget, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("File copied..");
		Files.delete(pathTarget);
		System.out.println("file deleted");
		Path newdir = Paths.get("files//newdir");
		Files.createDirectory(newdir);
		System.out.println("directory created");
		
	}
}
