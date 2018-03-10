package com.rightkarma.learnjava.jvm.gc;

/*// LearningNote -
 * running this program by giving -Djava.security.manager
 * you can see that file access will be restricted.
 * 
 * */

import java.io.FileWriter;
import java.io.IOException;

public class SimpleSecurity  {
	public static void main(String[] args) throws IOException {
		String version = System.getProperty("java.version");
		System.out.println(version);
		try(FileWriter writer=new FileWriter("c:/temp/out.txt")){
			writer.write("HW");
		}
	}
}
