package com.rightkarma.learnjava.javamem.classloaderleak;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ApplicationRunner {

	public static void main(String[] args) throws Exception {
		final String pluginName="purihim.javamem.classloaderleak.ExamplePlugin";
		while (true){
			System.out.println("press any key to load plugin");
			System.in.read();
			
			final URL[] urls = { new File("bin/").toURI().toURL() };
			final URLClassLoader classLoader = new URLClassLoader(urls, null);
			Class<?> aClass = classLoader.loadClass(pluginName);
			final Object plugin=aClass.newInstance();
			aClass.getMethod("initialize").invoke(plugin); // you would expect that after this call, class object would disappear. But it won't 
															// that is becuase this class has inner class that Java Logger would not let GC
															// which would keep main object also in memory.
		}
	}
}
