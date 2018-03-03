/*
 * LEARN:
 * You can call a static method using and object and java would work fine
 * If you have tried to override the method, it won't work.
 * method called would depend upon Class Type not object type.
 * 
 * OUTPUT:
 * MyClass.doit
 * MySubClass.doit2
 * */
package com.rightkarma.javabasic.staticfunda;

public class MySubClass extends MyClass {

	public static void doit(){
		System.out.println("MySubClass.doit");
	}
	
	public void doit2(){
		System.out.println("MySubClass.doit2");
	}


	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MyClass m = new MySubClass();
		m.doit(); // doit of MyClass
		m.doit2(); // doit2 of MySubClass
	}
}
