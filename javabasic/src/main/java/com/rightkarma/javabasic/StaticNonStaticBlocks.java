package com.rightkarma.javabasic;

public class StaticNonStaticBlocks {

	// non-static - executed every time on object instantiation
	{
		System.out.println(System.nanoTime() +" non-static");
	}
	
	// static - executed only once - first time on object instantiation
	// static executes before non-static during class load
	static {
		System.out.println(System.nanoTime() +" static");
	}
	
	public static void main(String[] args) {
		StaticNonStaticBlocks t = new StaticNonStaticBlocks();
		t = new StaticNonStaticBlocks();
		t = new StaticNonStaticBlocks();
		t = new StaticNonStaticBlocks();
	}
}
