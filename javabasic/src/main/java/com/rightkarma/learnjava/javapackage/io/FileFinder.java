package com.rightkarma.learnjava.javapackage.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileFinder extends SimpleFileVisitor<Path> {

	private PathMatcher matcher;
	private List<Path> foundPaths = new ArrayList<>();

	public List<Path> getFoundPaths() {
		return foundPaths;
	}

	public FileFinder(String pattern) {
		matcher = FileSystems.getDefault().getPathMatcher("regex:" + pattern);
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Path name = file.getFileName();
		System.out.println("checking file : "+name);
		if ( matcher.matches(name)) {
			foundPaths.add(file);
		}
		
		return FileVisitResult.CONTINUE;
	}

	private static void callFileFinder(FileFinder ff) throws IOException {
		Path dirToSearch = Paths.get("files");
		Files.walkFileTree(dirToSearch, ff);
		List<Path> foundFiles = ff.getFoundPaths();
		if ( foundFiles.size()>0) {
			for ( Path p : foundFiles) {
				System.out.println(p.toRealPath(LinkOption.NOFOLLOW_LINKS));
			}
		} else {
			System.out.println("File not found..");
		}
	}
	public static void main(String[] args) throws IOException {
		FileFinder ff = new FileFinder("^S.+"); // will find files starting with S
		callFileFinder(ff);
		ff = new FileFinder("^S."); // will not find
		callFileFinder(ff);
		
		
	}
}
/*OUTPUT
checking file : anotherfile.txt
checking file : SomeFileForIO.txt
F:\aapurihitech\gitproject\GenJava\files\SomeFileForIO.txt
checking file : anotherfile.txt
checking file : SomeFileForIO.txt
File not found..

*/