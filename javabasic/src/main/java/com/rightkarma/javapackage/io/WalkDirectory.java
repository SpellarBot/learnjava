package com.rightkarma.javapackage.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkDirectory extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("About to visit : " + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if ( attrs.isRegularFile()) {
			System.out.print("Regular file : ");
		}
		System.out.println(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.out.println("failed file : " + file);
		return FileVisitResult.CONTINUE;

	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("Visited Dir : " + dir);
		return FileVisitResult.CONTINUE;

	}
	
	public static void main(String[] args) throws IOException {
		Path fileDir = Paths.get("files");
		WalkDirectory wd = new WalkDirectory();
		Files.walkFileTree(fileDir, wd);
	}

}

/*
OUTPUT

About to visit : files
About to visit : files\newdir
Visited Dir : files\newdir
Regular file : files\SomeFileForIO.txt
Visited Dir : files

 * */
