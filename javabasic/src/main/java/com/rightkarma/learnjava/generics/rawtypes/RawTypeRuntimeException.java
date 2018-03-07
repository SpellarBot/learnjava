package com.rightkarma.learnjava.generics.rawtypes;

import java.util.ArrayList;
import java.util.List;

public class RawTypeRuntimeException {
	public void addAnyThingToRawType() {
		List list = new ArrayList();
		list.add("A");
		list.add(1);
		list.add(new Object());
		System.out.println(list);
		
		List<String> listString = list;
		for ( String str: listString) {
			System.out.println(str); 
			/* Expect this error at Runtime:
			 * java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
	at in.purihim.javabasic.generics..rawtype.RawTypeRuntimeException.main(RawTypeRuntimeException.java:15)

			 * */
		}
	}
}
