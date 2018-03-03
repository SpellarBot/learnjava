package com.rightkarma.javabasic.reflection;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ClassClass {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Class<?> c = list.getClass();
		
		System.out.println(c);
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		
		Constructor<?>[] constructors = c.getConstructors();
		System.out.println("number of constructors :  "+constructors.length);
		
		try{
			Object obj=constructors[1].newInstance();
			System.out.println(obj);
		} catch ( Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Super class: "+c.getSuperclass().getName()); // java - you can walk up. not down, as child classes may not be in memory.
		
		System.out.println("class package : "+c.getPackage().getName());
	}
}
