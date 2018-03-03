package com.rightkarma.learnjava.javamem.classloaderleak;

import java.util.logging.Level;
import java.util.logging.Logger;



public class ExamplePlugin implements Plugin {

	public static final long[] LOTS_OF_MEMORY = new long[8*1024*1024]; // too many instances of ExamplePlugin will choke memory because of this variable
	private ExamplePluginLevel level = new ExamplePluginLevel();
	@Override
	public void initialize() {
		Logger.getLogger("ExamplePlugin").log(level, "Hello World !!"); // every time we initialize, log will be printed
	}

	/** 
	 * 
	 * inner class will hold reference of main class
	 * because this is LoggerLevel class, java.util.Logger will keep this class alive i.e. any objects of this class.
	 * Since inner class will not go away from memory, it will continue to hold the main class also.
	 *  
	 *
	 */
	private class ExamplePluginLevel extends Level { 
		private static final long serialVersionUID = 1L;

		private ExamplePluginLevel() {
			super("ExamplePluginLevel log", 1000);
		}
	}
}
